package ru.firstproject.utils;

import ru.firstproject.to.LunchView;

import java.util.ArrayList;
import java.util.List;

public class LunchViewData {
    private LunchViewData(){}

    public static List<LunchView> lunchViewDataList = new ArrayList<>();
    static {
        lunchViewDataList.add(new LunchView(RestaurantData.RESTAURANT1));
        lunchViewDataList.add(new LunchView(RestaurantData.RESTAURANT2));
        lunchViewDataList.add(new LunchView(RestaurantData.RESTAURANT3));
        lunchViewDataList.add(new LunchView(RestaurantData.RESTAURANT4));
        lunchViewDataList.add(new LunchView(RestaurantData.RESTAURANT5));
    }
}
