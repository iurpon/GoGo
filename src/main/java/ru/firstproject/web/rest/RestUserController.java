package ru.firstproject.web.rest;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.firstproject.model.Menu;
import ru.firstproject.model.User;
import ru.firstproject.model.Vote;
import ru.firstproject.web.AbstractController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/rest/user")
public class RestUserController  extends AbstractController{

    @GetMapping(value = "/menu",produces = MediaType.APPLICATION_JSON_VALUE)
    List<Menu> getMenu(){
        return menuRepository.findByDate(LocalDate.now());
    }

    @PostMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    Vote setVote(@PathVariable("id") int id, @RequestBody Menu menu){
        logger.debug("setVote user/{}",id);
        logger.debug("Menu is {} ",menu);
        Vote vote = new Vote();
        vote.setRestaurant(menu.getRestaurant());
        vote.setUser(userRepository.get(id));
        logger.debug("Vote is {}",vote);
        voteRepository.save(vote);
        return vote;
    }

    @GetMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    Vote getVote(@PathVariable("id") int id){
        Vote vote = voteRepository.getUserVote(id,LocalDate.now());
        return vote;
    }

/*    @PostMapping(value = "/vote/{id}",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    Vote setVote(@RequestBody Menu menu,@PathVariable("id") int id){
        Vote vote = new Vote();
        vote.setRestaurant(menu.getRestaurant());
        User user = userRepository.get(id);
        vote.setUser(user);
        logger.debug("vote is {}",vote);
        voteRepository.save(vote);
        logger.debug("saved vote is {}",vote);
        return vote;
    }*/

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    List<User> getAll(){
        return userRepository.getAll();
    }

}
