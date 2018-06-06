package ru.firstproject.model;

import org.springframework.data.annotation.AccessType;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

import static ru.firstproject.model.Restaurant.START_SEQ;

@Entity
@Table(name = "label",uniqueConstraints = {@UniqueConstraint(columnNames = "date", name = "label_unique_date_idx")})
@AccessType(AccessType.Type.FIELD)
public class Label {
    @Id
    @SequenceGenerator(name = "global_seq", sequenceName = "global_seq", allocationSize = 1, initialValue = START_SEQ)
    //    @Column(name = "id", unique = true, nullable = false, columnDefinition = "integer default nextval('global_seq')")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "global_seq")
    private int id;

    @Column(name = "date",nullable = false,unique = true)
    @NotNull
    private LocalDate localDate;


    public Label() {
        this.localDate = LocalDate.now();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }
}
