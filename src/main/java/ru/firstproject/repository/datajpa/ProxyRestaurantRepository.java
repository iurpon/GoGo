package ru.firstproject.repository.datajpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import ru.firstproject.model.Restaurant;

@Transactional(readOnly = true)
public interface ProxyRestaurantRepository extends JpaRepository<Restaurant,Integer> {
    @Override
    Restaurant getOne(Integer integer);

    @Override
    @Transactional
    Restaurant save(Restaurant entity);
}
