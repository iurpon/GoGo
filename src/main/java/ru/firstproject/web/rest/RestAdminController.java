package ru.firstproject.web.rest;


import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.firstproject.model.Menu;
import ru.firstproject.model.Restaurant;
import ru.firstproject.to.LunchView;
import ru.firstproject.web.AbstractController;


import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/rest/admin")
public class RestAdminController extends AbstractController {

    @GetMapping(value = "/restaurant", produces = MediaType.APPLICATION_JSON_VALUE)
    List<Restaurant> getAllRestaurants(){
        return restaurantRepository.getAll();
    }

    @GetMapping(value = "/restaurant/byName", produces = MediaType.APPLICATION_JSON_VALUE)
    Restaurant getByName(@RequestParam(value = "name", required = true) String name){
        logger.debug("/restaurant/byName");
        return restaurantRepository.getByName(name);
    }

    @GetMapping(value = "/restaurant/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    Restaurant getById(@PathVariable("id") int id){
        logger.debug("/restaurant/{}",id);
        return restaurantRepository.get(id);
    }

    @PostMapping(value = "/restaurant", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    Restaurant create(@RequestBody Restaurant restaurant){
        logger.debug("/restaurant/byName");
        Restaurant savedRestaurant  = restaurantRepository.save(restaurant);
        return savedRestaurant;
    }

    @PostMapping(value = "/restaurant/{id}/menu",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    LunchView addLunch(@RequestBody Menu menu,@PathVariable("id") int id){
        Restaurant restaurant = restaurantRepository.get(id);
        menu.setRestaurant(restaurant);
        menuRepository.save(menu);
        LunchView lunchView = new LunchView(restaurant,menu.getDescription(),menu.getPrice());
        return lunchView;
    }
    @GetMapping(value = "/restaurant/menu",produces = MediaType.APPLICATION_JSON_VALUE)
    List<LunchView> getTodayLunch(){
        List<Restaurant> restaurantList = restaurantRepository.getAll();
        List<Menu> menuList = menuRepository.findByDate(LocalDate.now());
        List<LunchView> lunchViewList = createLunchView(restaurantList,menuList);
        return lunchViewList;
    }
/*
    @DeleteMapping(value = "/restaurant/{id}")
    void  delete(@PathVariable("id") int id){
        logger.debug("/restaurant/{} delete",id);
        restaurantRepository.delete(id);
    }*/

}
