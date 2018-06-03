package ru.firstproject.to;

import ru.firstproject.model.Menu;
import ru.firstproject.model.Restaurant;


import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class LunchView {
    private String description;
    private String restaurantName;
    private double price;
    private final LocalDate localDate;
    private int  restId;
    public LunchView(Restaurant restaurant){
        this.restaurantName = restaurant.getName();
        restId = restaurant.getId();
        localDate = LocalDate.now();
//        fillTheView(restaurant.getMenuList());

    }

    public LunchView(Restaurant restaurant,String description, double price) {
        localDate = LocalDate.now();
        this.restaurantName = restaurant.getName();
        restId = restaurant.getId();
        this.description = description;
        this.price = price;
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

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }




    public int getRestId() {
        return restId;
    }

    public void setRestId(int restId) {
        this.restId = restId;
    }
}
