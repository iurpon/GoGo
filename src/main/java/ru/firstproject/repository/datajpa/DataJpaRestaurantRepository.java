package ru.firstproject.repository.datajpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.firstproject.model.Restaurant;
import ru.firstproject.repository.RestaurantRepository;

import java.util.List;

@Repository
public class DataJpaRestaurantRepository implements RestaurantRepository {
    private static Logger logger = LoggerFactory.getLogger(DataJpaRestaurantRepository.class);
    @Autowired
    private ProxyRestaurantRepository repository;

    @Override
    public Restaurant get(int id) {
        logger.info("DataJpaRestaurantRepository get(int id)");
        return repository.getOne(id);
    }

    @Override
    @Transactional
    public Restaurant save(Restaurant restaurant) {
        return repository.save(restaurant);
    }

    @Override
    public String getName(int id) {
        return repository.getName(id);
    }

    @Override
    public List<Restaurant> getAll() {
        return repository.findAll();
    }
}
