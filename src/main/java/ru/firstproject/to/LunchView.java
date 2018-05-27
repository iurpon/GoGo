package ru.firstproject.to;

import ru.firstproject.model.Menu;
import ru.firstproject.model.Restaurant;


import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class LunchView {
    private String description;
    private String restaurant;
    private double price;
    private LocalDate localDate;
    public LunchView(Restaurant restaurant){
        this.restaurant = restaurant.getName();
//        fillTheView(restaurant.getMenuList());

    }

/*
    private void fillTheView(List<Menu> menu){
        if(menu == null){
            this.description = "No lunch today. We are sorry";
            this.price = 0;
            this.localDate = LocalDate.now();
        }

        Optional<Menu> optional = menu.stream().filter( m -> m.getLocalDate().isEqual(LocalDate.now())).findAny();
        Menu menu1 = optional.get();
        if(menu1 == null){
            this.description = "No lunch today. We are sorry";
            this.price = 0;
            this.localDate = LocalDate.now();
        }
        else{
            this.localDate = menu1.getLocalDate();
            this.price = menu1.getPrice();
//            String[] dish =  menu1.getDishes();
            this.description = "";
            for(int i = 0; i<dish.length; i++){
                this.description += dish[i] + ", ";
            }
        }

    }
*/

    public String getDescription() {
        return description;
    }

    public String getRestaurant() {
        return restaurant;
    }

    public double getPrice() {
        return price;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }
}
