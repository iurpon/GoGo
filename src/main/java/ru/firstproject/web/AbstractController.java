package ru.firstproject.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import ru.firstproject.model.Menu;
import ru.firstproject.model.Restaurant;
import ru.firstproject.repository.*;
import ru.firstproject.to.LunchView;
import ru.firstproject.web.mvc.AdminController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

abstract public class AbstractController {
    protected static Logger logger = LoggerFactory.getLogger(AdminController.class);

    @Autowired
    protected MenuRepository menuRepository;
    @Autowired
    protected VoteRepository voteRepository;
    @Autowired
    protected UserRepository userRepository;
    @Autowired
    protected RestaurantRepository restaurantRepository;
    @Autowired
    protected LabelRepository labelRepository;


    protected List<LunchView> createLunchView(List<Restaurant> restaurantList, List<Menu> menuList) {
        logger.debug(" createLunchView ");
        if(menuList.isEmpty()){
            logger.debug("menuList is empty");
            List<LunchView> lunchViewList = restaurantList.stream()
                    .map(LunchView::new)
                    .collect(Collectors.toList());
            return lunchViewList;
        }else{
            logger.debug("menulist not empty");
            Map<Integer,Menu> menuMap = menuList.stream()
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
    }
}
