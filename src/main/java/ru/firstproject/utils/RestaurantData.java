package ru.firstproject.utils;

import ru.firstproject.model.Restaurant;

import java.util.ArrayList;
import java.util.List;

public class RestaurantData {
    private RestaurantData(){}
    public static final Restaurant RESTAURANT1 = new Restaurant("Always fresh");
    public static final Restaurant RESTAURANT2 = new Restaurant("Good lunch");
    public static final Restaurant RESTAURANT3 = new Restaurant("Taco Bell");
    public static final Restaurant RESTAURANT4 = new Restaurant("Italian restaurant");
    public static final Restaurant RESTAURANT5 = new Restaurant("Burger King");

    public static List<Restaurant> restaurantList = new ArrayList<>();
    static {
        RESTAURANT1.addMenu(MenuData.MENU1);
        RESTAURANT2.addMenu(MenuData.MENU2);
        RESTAURANT3.addMenu(MenuData.MENU3);
        RESTAURANT4.addMenu(MenuData.MENU4);
        RESTAURANT5.addMenu(MenuData.MENU5);
        restaurantList.add(RESTAURANT1);
        restaurantList.add(RESTAURANT2);
        restaurantList.add(RESTAURANT3);
        restaurantList.add(RESTAURANT4);
        restaurantList.add(RESTAURANT5);
    }
}
