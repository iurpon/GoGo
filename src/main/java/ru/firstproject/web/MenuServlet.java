package ru.firstproject.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import ru.firstproject.model.Menu;
import ru.firstproject.repository.MenuRepository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class MenuServlet extends HttpServlet {
    public static Logger logger = LoggerFactory.getLogger(MenuServlet.class);

    @Autowired
    private MenuRepository repository;


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        logger.debug("doGet() MenuServlet");
        List<Menu> list = repository.getAll();
        if(list == null){
            logger.debug(" list is empty");
            resp.sendRedirect("users");
        }
        list.stream().forEach(System.out::println);
        request.setAttribute("menus", list);
        request.getRequestDispatcher("/menu.jsp").forward(request, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
