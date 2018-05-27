package ru.firstproject.repository;

import ru.firstproject.model.Menu;

import java.util.List;

public interface MenuRepository {
    List<Menu> getAll();
}
