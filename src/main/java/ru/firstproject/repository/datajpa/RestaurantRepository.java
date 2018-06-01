package ru.firstproject.repository.datajpa;

import ru.firstproject.model.Restaurant;

public interface RestaurantRepository {
    Restaurant get(int id);
    Restaurant save(Restaurant restaurant);
}
