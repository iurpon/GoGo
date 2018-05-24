package ru.firstproject.model;

import java.time.LocalDate;

public class Menu {
    private LocalDate localDate;
    private double price;
    private String[] dishes;

    public Menu(LocalDate localDate, double price, String... dishes) {
        this.localDate = localDate;
        this.price = price;
        this.dishes = dishes;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public double getPrice() {
        return price;
    }

    public String[] getDishes() {
        return dishes;
    }
}
