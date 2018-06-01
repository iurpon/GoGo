package ru.firstproject.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.firstproject.AuthorizedUser;
import ru.firstproject.repository.MenuRepository;


import javax.servlet.http.HttpServletRequest;

@Controller
public class RootController {
    private Logger logger = LoggerFactory.getLogger(RootController.class);
    @Autowired
    private MenuRepository repository;

    @GetMapping(value = "/")
    public String root() {
        return "index";
    }

    @GetMapping("/menu")
    public String users(Model model) {
        model.addAttribute("menus", repository.getAll());
        return "menu";
    }

    @PostMapping("/users")
    public String setUser(HttpServletRequest request) {
        int userId = Integer.valueOf(request.getParameter("userId"));
        AuthorizedUser.setId(userId);
        logger.debug("authorized user with id " + userId);
        return "redirect:menu";
    }
}
