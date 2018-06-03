package ru.firstproject.repository;

import ru.firstproject.model.Menu;

import java.time.LocalDate;
import java.util.List;

public interface MenuRepository {
    List<Menu> getAll();
    List<Menu> findByDate(LocalDate date);
}
