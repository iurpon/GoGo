package ru.firstproject.repository.datajpa;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import ru.firstproject.model.Menu;

import java.time.LocalDate;
import java.util.List;
@Transactional(readOnly = true)
public interface ProxyMenuRepository extends JpaRepository<Menu,Integer> {
    @Override
    List<Menu> findAll(Sort sort) ;

    List<Menu> findByLocalDateOrderByPriceAsc(LocalDate localDate);

    @Override
    @Transactional
    Menu save(Menu entity);
}
