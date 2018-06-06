package ru.firstproject.repository.datajpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import ru.firstproject.model.Label;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Transactional(readOnly = true)
public interface ProxyLabelRepository extends JpaRepository<Label,Integer> {

    Label getByLocalDate(LocalDate date);

    @Override
    @Transactional
    Label save(@NotNull Label entity);


}
