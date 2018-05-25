package ru.firstproject.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.firstproject.AuthorizedUser;
import ru.firstproject.utils.LunchData;
import ru.firstproject.utils.LunchViewData;
import ru.firstproject.utils.VotingStorage;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

public class LunchServlet extends HttpServlet {
    private  static final Logger logger = LoggerFactory.getLogger(LunchServlet.class);
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.debug("forward lunch.jsp");
        String choise = "";
        String restaurantName = request.getParameter("vote");
        String restaurantName1 = VotingStorage.getVote(AuthorizedUser.getId());
        if(restaurantName != null || restaurantName1 != null){
            if(restaurantName != null){
                choise = VotingStorage.addVote(AuthorizedUser.getId(),restaurantName);
            }else{
                restaurantName = restaurantName1;
//                choise = VotingStorage.addVote(AuthorizedUser.getId(),restaurantName);
            }


        }else{
            restaurantName = "";
            choise = "Please make a choise";
        }
        request.setAttribute("restaurantName", restaurantName);
//        request.setAttribute("lunch", LunchData.lunchList);
        request.setAttribute("choise", choise);
        request.setAttribute("lunch", LunchViewData.lunchViewDataList);
        request.setAttribute("date", LocalDate.now().toString());
        request.getRequestDispatcher("/lunch.jsp").forward(request, response);
    }
}
