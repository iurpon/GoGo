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
import ru.firstproject.AuthorizedUser;
import ru.firstproject.model.Vote;
import ru.firstproject.repository.MenuRepository;
import ru.firstproject.repository.UserRepository;
import ru.firstproject.repository.VoteRepository;
import ru.firstproject.repository.datajpa.RestaurantRepository;

import java.time.LocalDate;

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
    public String users(Model model) {
        logger.debug("RootController Get(/menu");
        model.addAttribute("menus", menuRepository.getAll());
        return "menu";
    }
    @GetMapping("/restaurant/{id}")
    public String getVote(@PathVariable("id") int id, Model model){
        logger.debug("RootController get(/restaurant/id)");
        Vote vote = new Vote(LocalDate.now());
        vote.setUser(userRepository.get(AuthorizedUser.getId()));
        vote.setRestaurant(restaurantRepository.get(id));
           voteRepository.save(vote);
           return "redirect:/menu";
    }

    @PostMapping("/users")
    public String setUser(HttpServletRequest request) {
        int userId = Integer.valueOf(request.getParameter("userId"));
        AuthorizedUser.setId(userId);
        logger.debug("authorized user with id " + userId);
        return "redirect:menu";
    }
}
