package ru.firstproject.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.firstproject.AuthorizedUser;
import ru.firstproject.model.Menu;
import ru.firstproject.model.Restaurant;
import ru.firstproject.model.User;
import ru.firstproject.model.Vote;
import ru.firstproject.repository.MenuRepository;
import ru.firstproject.repository.UserRepository;
import ru.firstproject.repository.VoteRepository;
import ru.firstproject.repository.RestaurantRepository;
import ru.firstproject.to.LunchView;
import ru.firstproject.utils.VotingStorage;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/")
public class RootController  extends AbstractController{



    @GetMapping()
    public String root() {
        return "index";
    }

    @GetMapping("/menu")
    public String users(Model model, RedirectAttributes attributes) {
        logger.debug("RootController Get(/menu");

        if(labelRepository.isMenuReady()){
            Vote vote = voteRepository.getUserVote(AuthorizedUser.getId(),LocalDate.now());
            if(vote != null){
                checkVote(AuthorizedUser.getId(),model,vote.getRestaurant().getName());
            }
            List<Vote> resultVoting = voteRepository.getTodayVotes();
            String resultVotingMsg = "";
            if(resultVoting != null ){
                logger.debug("resultVoting != null");
                 resultVotingMsg = getMsg(resultVoting);
            }


            model.addAttribute("votingMsgResult", resultVotingMsg);
            model.addAttribute("menus", menuRepository.findByDate(LocalDate.now()));
        }else{
            model.addAttribute("notReadyMsg","Sorry.Menu not ready");
        }



        return "menu";
    }

    private String getMsg(List<Vote> resultVoting) {
        logger.info("getMsg");
        StringBuilder sb = new StringBuilder("Voting Result : \n");
        Map<String,Integer> map = new HashMap<>();
                resultVoting.stream()
                .forEach(v -> map.merge(v.getRestaurant().getName(),1, (v1,v2) -> v1+v2));
        if(map.isEmpty()){
            return "No voting results yet";
        }
        else{
            map.keySet().stream().forEach( str -> sb.append(str + " : " + map.get(str)+ "\n"));
        }
        return sb.toString();
    }


    @GetMapping("/restaurant/{id}/{restaurantName}")
    public String getVote(@PathVariable("id") int id, @PathVariable("restaurantName") String restName,Model model,
                          RedirectAttributes attributes) {
        logger.debug("RootController get(/restaurant/id)");
        logger.debug("id = " + id + ", restaurantName = " + restName);
        checkVote(id,model,attributes,restName);
        return "redirect:/menu";
    }

    @PostMapping("/users")
    public String setUser(HttpServletRequest request) {
        logger.debug("/users  setUser()");
        int userId = Integer.valueOf(request.getParameter("userId"));
        AuthorizedUser.setId(userId);
        User user = userRepository.get(userId);
        if(user == null){
            logger.debug("user == null");
        }
        else {
            logger.debug("user != null");
        }
        String routing = "";
        if(user.isAdmin()){
            routing = "redirect:admin";
        }else {
            routing  = "redirect:menu";
        }
        logger.debug("authorized user with id " + userId);
        return routing;
    }

    public void checkVote(int restId,Model model,RedirectAttributes attributes,String restaurantName){


        StringBuilder sb = newOrUpdate(restId,model,restaurantName);
        logger.debug(" StringBuilder in da hous : " + sb.toString());
        attributes.addFlashAttribute("msg", sb.toString());
        attributes.addFlashAttribute("restaurantName", restaurantName);
    }
    public void checkVote(int restId,Model model,String restaurantName){

//           model.addAttribute("msg",sb.toString());
//        String restName = restaurantRepository.getName(restId);
        StringBuilder sb = newOrUpdate(restId,model,restaurantName);
        logger.debug(" StringBuilder in da hous : " + sb.toString());
        model.addAttribute("msg", sb.toString());
        model.addAttribute("restaurantName", restaurantName);
    }

    public StringBuilder newOrUpdate(int restId, Model model,String restName){
        StringBuilder sb = new StringBuilder();
        LocalTime timeNow = LocalTime.now();
        Vote alreadyVoted = voteRepository.getVote(AuthorizedUser.getId(), LocalDate.now());
        Restaurant restaurant = restaurantRepository.get(restId);

        String restChoise = "you have already chosen a restaurant " +restName + "\n";
//        String restChoise = "You have chouse " + restaurant.getName() + "\n"; //lazy init exception
        sb.append(restChoise);
        if (alreadyVoted == null) {
            Vote vote = new Vote(LocalDate.now());
            vote.setUser(userRepository.get(AuthorizedUser.getId()));
            vote.setRestaurant(restaurant);
            voteRepository.save(vote);
            sb.append("Thank for voting. \n");
            if (timeNow.isBefore(VotingStorage.timeLimit)) {
                LocalTime expiredTime = VotingStorage.timeLimit.minusHours(timeNow.getHour());
                sb.append(" You can change your mind . Time left " + expiredTime.toString() + " hours");
            } else {
                sb.append(" You can't remind");
            }


        } else {
            if (timeNow.isBefore(VotingStorage.timeLimit)) {
                alreadyVoted.setRestaurant(restaurant);
                voteRepository.save(alreadyVoted);

                LocalTime expiredTime = VotingStorage.timeLimit.minusHours(timeNow.getHour());
                String append = " You can change your mind . Time left " + expiredTime.toString() + " hours";
                sb.append(append);

            } else {
                sb.append(" You can't remind");
            }
        }
        return sb;
    }



}
