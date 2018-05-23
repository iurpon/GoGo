package ru.firstproject;

import ru.firstproject.utils.LunchData;

public class Main {
    public static void main(String[] args){
        LunchData.lunchList.stream().forEach(System.out::println);
    }
}
