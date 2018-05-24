package ru.firstproject.utils;

import ru.firstproject.model.LunchXX;
import ru.firstproject.model.Menu;

import java.time.LocalDate;

public class MenuData {
    private MenuData(){}

    public static final Menu MENU1
            = new Menu(LocalDate.now(),23.34, "chicken", "barbeque sauce", "vegetable", "slice bread", "milk" );
    public static final Menu MENU2
            = new Menu(LocalDate.now(),18.22, "hot dog", "french fries", "beans", "fruit", "milk" );
    public static final Menu MENU3
            = new Menu(LocalDate.now(),20.01, "taco", "cheese", "salsa", "fruit", "milk" );
    public static final Menu MENU4
            = new Menu(LocalDate.now(),23.34, "cheese", "pizza", "vegetable", "fruit", "milk" );
    public static final Menu MENU5
            = new Menu(LocalDate.now(),17.56, "hamburger", "ketchup", "backed chips", "fruit", "milk" );
}
