package ru.firstproject.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import ru.firstproject.repository.MenuRepository;
import ru.firstproject.repository.RestaurantRepository;
import ru.firstproject.repository.UserRepository;
import ru.firstproject.repository.VoteRepository;

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
}
