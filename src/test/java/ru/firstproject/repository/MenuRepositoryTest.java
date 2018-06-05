package ru.firstproject.repository;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.firstproject.MenuData;
import ru.firstproject.model.Menu;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;

public class MenuRepositoryTest  extends AbstractServiceTest{

    @Autowired
    private MenuRepository repository;

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Test
    public void getAll() throws Exception {
        List<Menu> list = repository.getAll();
        MenuData.assertMatch(MenuData.MENU,list);
    }

    @Test
    public void findByDate() throws Exception {
        List<Menu> list = repository.findByDate(LocalDate.of(2018,5,27));
        MenuData.assertMatch(MenuData.MENU,list);
    }

    @Test
    public void save() throws Exception {
        Menu menu = new Menu(LocalDate.now(),35,"sadfjlsdls");

        menu.setRestaurant(restaurantRepository.get(100000));
        repository.save(menu);
        List<Menu> list = repository.getAll();
        Assert.assertEquals(6,list.size());

    }

}