package ru.firstproject.model;

import java.time.LocalDate;

public class LunchXX {
    private String description;
    private String restaurant;
    private double price;
    private LocalDate localDate;

    public LunchXX(String description, String restaurant, double price, LocalDate localDate) {
        this.description = description;
        this.restaurant = restaurant;
        this.price = price;
        this.localDate = localDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(String restaurant) {
        this.restaurant = restaurant;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }


    @Override
    public String toString() {
        return "Lunch{" +
                "description='" + description + '\'' +
                ", restaurant='" + restaurant + '\'' +
                ", price=" + price +
                ", localDate=" + localDate +
                '}';
    }
}
