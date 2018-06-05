package ru.firstproject.repository.datajpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import ru.firstproject.model.Menu;
import ru.firstproject.repository.MenuRepository;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

@Repository
public class DataJpaMenuRepositoryImpl  implements MenuRepository{
    private static Logger logger  = LoggerFactory.getLogger(DataJpaMenuRepositoryImpl.class);
    private static final Sort SORT_PRICE = new Sort(Sort.Direction.ASC, "price");

    @Autowired
    private ProxyMenuRepository repository;

    @Override
    public List<Menu> getAll() {
        logger.debug("DataJpaMenuRepositoryImpl getAll()");
        return repository.findAll(SORT_PRICE);
    }

    @Override
    public List<Menu> findByDate(LocalDate date) {
        List<Menu> menuList = repository.findByLocalDateOrderByPriceAsc(date);
        if(menuList == null){
            return Collections.emptyList();
        }
        return menuList;
    }

    @Override
    public Menu save(Menu menu) {
        logger.debug("DataJpaMenuRepository save()");
        return repository.save(menu);
    }
}
