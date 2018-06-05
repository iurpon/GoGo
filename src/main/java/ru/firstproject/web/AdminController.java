package ru.firstproject.web;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.firstproject.model.Menu;
import ru.firstproject.model.Restaurant;
import ru.firstproject.to.LunchView;
import ru.firstproject.utils.VotingStorage;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/admin")
public class AdminController extends AbstractController {
    private static final LocalDate DATETODAY = LocalDate.now();
    private static final LocalDate DATEAFTERTOMMOROW = LocalDate.now().plusDays(3);




    @GetMapping()
    public String adminJob(Model model){
        logger.debug("/admin adminJob()");

        List<Restaurant> restaurantList = restaurantRepository.getAll();
        List<Menu> menuList = menuRepository.findByDate(LocalDate.now());
        List<LunchView> lunchViewList = createLunchView(restaurantList,menuList);
        model.addAttribute("lunchList",lunchViewList);
        model.addAttribute("minDate",DATETODAY);
        model.addAttribute("maxDAte",DATEAFTERTOMMOROW);


        return "admin";
    }

    @GetMapping("/addMenu/{id}/{restaurantName}")
    public String addMenu(@PathVariable("id") int restId, Model model, @PathVariable("restaurantName") String name){
        logger.debug("/addMenu getmappint");
        model.addAttribute("restId",restId);
        model.addAttribute("restaurantName",name);
        return "addForm";
    }
    @PostMapping("/addMenu")
    public String addMenu(Model model, HttpServletRequest request, RedirectAttributes attributes){
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
        return "redirect:/admin";
    }
    @PostMapping("/start")
    public String startVoting(RedirectAttributes attributes){
        VotingStorage.startVoting.clear();
        VotingStorage.startVoting.put(LocalDate.now(),true);
        attributes.addFlashAttribute("aboutVote", "Vote started");
        return "redirect:/admin";
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
//        logger.debug("why we are here?");
//        return null;
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
