package ru.firstproject.repository;

import ru.firstproject.model.Label;

public interface LabelRepository {
    boolean isMenuReady();
    Label add(Label label);
    Label getToday();
}
