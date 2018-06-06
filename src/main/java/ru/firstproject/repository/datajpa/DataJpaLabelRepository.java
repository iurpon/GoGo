package ru.firstproject.repository.datajpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.firstproject.model.Label;
import ru.firstproject.repository.LabelRepository;

import java.time.LocalDate;

@Repository
public class DataJpaLabelRepository implements LabelRepository{
    @Autowired
    private ProxyLabelRepository repository;

    @Override
    public boolean isMenuReady() {
        return repository.getByLocalDate(LocalDate.now()) != null;
    }

    @Override
    public Label add(Label label) {
        return repository.save(label);
    }

    @Override
    public Label getToday() {
        return repository.getByLocalDate(LocalDate.now());
    }
}
