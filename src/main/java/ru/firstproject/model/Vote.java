package ru.firstproject.model;

import org.springframework.data.annotation.AccessType;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.time.LocalDate;

import static ru.firstproject.model.Restaurant.START_SEQ;

@Entity
@AccessType(AccessType.Type.FIELD)
@Table(name = "votes")
public class Vote {

    @Id
    @SequenceGenerator(name = "global_seq", sequenceName = "global_seq", allocationSize = 1, initialValue = START_SEQ)
    //    @Column(name = "id", unique = true, nullable = false, columnDefinition = "integer default nextval('global_seq')")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "global_seq")
    private int id;

    @Column(name = "date", columnDefinition = "date default now()")
    @NotNull
    private LocalDate registered = LocalDate.now();

    @OneToOne
    @JoinColumn(name = "rest_id")
    private Restaurant restaurant;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
