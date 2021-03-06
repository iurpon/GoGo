package ru.firstproject.repository.datajpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;
import ru.firstproject.model.Restaurant;

import java.util.List;
import java.util.Optional;

@Transactional(readOnly = true)
public interface ProxyRestaurantRepository extends JpaRepository<Restaurant,Integer> {


    @Override
    Optional<Restaurant> findById(Integer integer);

    Restaurant getByName(String name);

    @Override
    @Transactional
    Restaurant save(Restaurant entity);

    @Query("select r.name from Restaurant r where r.id =:id")
    String getName(@Param("id") int id);

    @Override
    List<Restaurant> findAll();

    @Override
    @Transactional
    void deleteById(Integer integer);
}
