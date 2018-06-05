package ru.firstproject;

import ru.firstproject.model.Menu;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MenuData {
    private MenuData(){}

    public static final Menu MENU1
            = new Menu(100005,LocalDate.of(2018,5,27),23.35,
            "chicken, barbeque sauce, vegetable, slice bread, milk" );
    public static final Menu MENU2
            = new Menu(100006,LocalDate.of(2018,5,27),18.22,
            "hot dog, french fries, beans, fruit, milk" );
    public static final Menu MENU3
            = new Menu(100007,LocalDate.of(2018,5,27),20.01,
            "taco, cheese , salsa, fruit, milk" );
    public static final Menu MENU4
            = new Menu(100008,LocalDate.of(2018,5,27),23.34,
            "cheese, pizza, vegetable,fruit, milk" );
    public static final Menu MENU5
            = new Menu(100009,LocalDate.of(2018,5,27),17.56,
            "hamburger, ketchup, backed chips, fruit, milk" );

    public static final List<Menu> MENU = Arrays.asList(MENU5, MENU2, MENU3, MENU4, MENU1);


    public static void assertMatch(Menu actual, Menu expected) {
        assertThat(actual).isEqualToIgnoringGivenFields(expected, "restaurant");
    }

    public static void assertMatch(Iterable<Menu> actual, Menu... expected) {
        assertMatch(actual, Arrays.asList(expected));
    }

    public static void assertMatch(Iterable<Menu> actual, Iterable<Menu> expected) {
        assertThat(actual).usingElementComparatorIgnoringFields("restaurant").isEqualTo(expected);
    }
}
