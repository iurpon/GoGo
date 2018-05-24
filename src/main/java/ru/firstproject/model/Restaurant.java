package ru.firstproject.model;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private String name;
    private List<Menu> menuList;

    public Restaurant(String name) {
        this.name = name;
        menuList = new ArrayList<>();
    }
    public void addMenu(Menu menu){
        menuList.add(menu);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMenuList(List<Menu> menuList) {
        this.menuList = menuList;
    }

    public String getName() {
        return name;
    }

    public List<Menu> getMenuList() {
        return menuList;
    }
}
