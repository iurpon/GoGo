package ru.firstproject.model;

import org.springframework.data.annotation.AccessType;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import static ru.firstproject.model.Restaurant.START_SEQ;

@Entity
@AccessType(AccessType.Type.FIELD)
@Table(name = "users")
public class User {

    @Id
    @SequenceGenerator(name = "global_seq", sequenceName = "global_seq", allocationSize = 1, initialValue = START_SEQ)
    //    @Column(name = "id", unique = true, nullable = false, columnDefinition = "integer default nextval('global_seq')")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "global_seq")
    private int id;

    @Column(name = "name",nullable = false)
    @NotNull
    @NotBlank
    @Size(min = 2, max = 100)
    private String name;

    @Column(name = "name",nullable = false)
    @NotNull
    @Email
    private String email;

    @Column(name = "name",nullable = false)
    @NotNull
    @Size(min = 4,max = 30)
    private String password;

    @Column(name = "isAdmin",nullable = false)
    @NotNull
    private boolean isAdmin;
}
