package ru.firstproject.utils;

import ru.firstproject.model.Lunch;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LunchData {
    private LunchData(){}
    private static String[] description = {
      "chicken, barbeque sauce, vegetable, slice bread, milk",
            "hot dog, french fries, beans, fruit, milk",
            "taco, cheese , salsa, fruit, milk",
            "cheese, pizza, vegetable,fruit, milk",
            "hamburger, ketchup, backed chips, fruit, milk",

    };
    public static List<Lunch> lunchList = new ArrayList<>();

    public static final Lunch LUNCH1
            = new Lunch(description[0],"Always fresh", 23.34, LocalDate.of(2018,5,23));
    public static final Lunch LUNCH2
            = new Lunch(description[1],"Good lunch", 18.22, LocalDate.of(2018,5,23));
    public static final Lunch LUNCH3
            = new Lunch(description[2],"Taco Bell", 20.01, LocalDate.of(2018,5,23));
    public static final Lunch LUNCH4
            = new Lunch(description[3],"Italian restaurant", 23.34, LocalDate.of(2018,5,23));
    public static final Lunch LUNCH5
            = new Lunch(description[4],"Burger King", 17.56, LocalDate.of(2018,5,23));
    static {
        lunchList.add(LUNCH1);
        lunchList.add(LUNCH2);
        lunchList.add(LUNCH3);
        lunchList.add(LUNCH4);
        lunchList.add(LUNCH5);
    }
}
