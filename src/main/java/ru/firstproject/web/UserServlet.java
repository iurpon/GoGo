package ru.firstproject.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.firstproject.AuthorizedUser;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserServlet extends HttpServlet {
    private static Logger logger = LoggerFactory.getLogger(UserServlet.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.debug("UserServlet doGet");
//        super(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.debug("UserServlet doPost");
        int userId = Integer.parseInt(req.getParameter("userId"));
        AuthorizedUser.setId(userId);
        resp.sendRedirect("lunch");
    }
}
