package ru.firstproject.repository;

import ru.firstproject.model.Restaurant;

import java.util.List;

public interface RestaurantRepository {
    Restaurant get(int id);
    Restaurant getByName(String name);
    Restaurant save(Restaurant restaurant);
    String getName(int id);
    List<Restaurant> getAll();
    void delete(int id);
}
