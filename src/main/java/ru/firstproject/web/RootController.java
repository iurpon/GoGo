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
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class RootController {
    private Logger logger = LoggerFactory.getLogger(RootController.class);
    @Autowired
    private MenuRepository menuRepository;
    @Autowired
    private VoteRepository voteRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RestaurantRepository restaurantRepository;

    @GetMapping(value = "/")
    public String root() {
        return "index";
    }

    @GetMapping("/menu")
    public String users(Model model, RedirectAttributes attributes) {
        logger.debug("RootController Get(/menu");

        Vote vote = voteRepository.getUserVote(AuthorizedUser.getId(),LocalDate.now());
        if(vote != null){
            checkVote(AuthorizedUser.getId(),model,vote.getRestaurant().getName());
        }

        model.addAttribute("menus", menuRepository.getAll());

        return "menu";
    }
    @GetMapping("/admin")
    public String adminJob(Model model){
        logger.debug("/admin adminJob()");

        List<Restaurant> restaurantList = restaurantRepository.getAll();
        List<Menu> menuList = menuRepository.findByDate(LocalDate.now());
        List<LunchView> lunchViewList = createLunchView(restaurantList,menuList);
        model.addAttribute("lunchList",lunchViewList);


        return "admin";
    }

    private List<LunchView> createLunchView(List<Restaurant> restaurantList, List<Menu> menuList) {
        logger.debug(" createLunchView ");
        if(menuList.isEmpty()){
            logger.debug("menuList is empty");
            List<LunchView> lunchViewList = restaurantList.stream()
                    .map(LunchView::new)
                    .collect(Collectors.toList());
            return lunchViewList;
        }else{
            logger.debug("menulist not empty");
            Map<Integer,Menu>  menuMap = menuList.stream()
                    .collect(Collectors.toMap(m -> m.getRestaurant().getId(),m -> m));
            List<LunchView> lunchViewList = new ArrayList<>();
            restaurantList.stream().
                    forEach(r -> lunchViewList.add(
                            new LunchView(r,menuMap.getOrDefault(r.getId(),new Menu(0.0,"")).getDescription()
                                    ,menuMap.getOrDefault(r.getId(),new Menu(0.0,"")).getPrice())
                            )
                    );
            return lunchViewList;
        }
//        logger.debug("why we are here?");
//        return null;
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
    @GetMapping("/addMenu/{id}/{restaurantName}")
    public String addMenu(@PathVariable("id") int restId,Model model,@PathVariable("restaurantName") String name){
        logger.debug("/addMenu getmappint");
        model.addAttribute("restId",restId);
        model.addAttribute("restaurantName",name);
        return "addForm";
    }
    @PostMapping("/addMenu")
    public String addMenu(Model model,HttpServletRequest request,RedirectAttributes attributes){
        logger.debug("/addMenu postmapping");
        int restId = Integer.parseInt(request.getParameter("id"));
        List<Menu> list = menuRepository.findByDate(LocalDate.now());
        boolean isPresent = list.stream().anyMatch(m -> m.getRestaurant().getId() == restId);
        logger.debug(" isPresent " + isPresent + " menu for restaurant " + restId);
        String msgToAdmin = "";
        if(isPresent){
            msgToAdmin = "menu is already done. Cant change it";

        }else{
            Restaurant restaurant = restaurantRepository.get(restId);
            String menuDescription = getDescription(request);
            double price = Double.parseDouble(request.getParameter("price"));
            Menu newMenu = new Menu(price,menuDescription);
            newMenu.setRestaurant(restaurant);
            newMenu = menuRepository.save(newMenu);
            logger.debug("trying to print saved newMenu");
//        System.out.println(newMenu); lazy inti exception
            msgToAdmin = "menu added succes";
        }


        attributes.addFlashAttribute("msgToAdmin", msgToAdmin);
        return "redirect:admin";
    }

    private String getDescription(HttpServletRequest request) {
        StringBuilder sb = new StringBuilder();
        String dish1 = request.getParameter("dish1");
        addDish(dish1,sb);
        String dish2 = request.getParameter("dish2");
        addDish(dish2,sb);
        String dish3 = request.getParameter("dish3");
        addDish(dish3,sb);
        String dish4 = request.getParameter("dish4");
        addDish(dish4,sb);
        String dish5 = request.getParameter("dish5");
        addDish(dish5,sb);
        return sb.toString();
    }

    private void addDish(String dish1, StringBuilder sb) {
        if(!dish1.isEmpty()){
            sb.append(dish1);
            sb.append(", ");
        }
    }
}
