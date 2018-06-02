package ru.firstproject.model;

import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

import static ru.firstproject.model.Restaurant.START_SEQ;

@NamedQueries({
        @NamedQuery(name = Menu.ALL_SORTED, query = "SELECT m FROM Menu m")
})
@Entity
@Access(AccessType.FIELD)
@Table(name = "menu")
public class Menu {
    public static final String ALL_SORTED = "Menu.getAllSorted";

    @Id
    @SequenceGenerator(name = "global_seq", sequenceName = "global_seq", allocationSize = 1, initialValue = START_SEQ)
    //    @Column(name = "id", unique = true, nullable = false, columnDefinition = "integer default nextval('global_seq')")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "global_seq")
    private int id;

    @Column(name = "date",nullable = false)
    @NotNull
    private LocalDate localDate;

    @Column(name = "price",nullable = false)
    @NotNull
    private double price;
//    private String[] dishes;

    @Column(name = "description",nullable = false)
    @NotNull
    @NotBlank
    private String description;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "rest_id")
    @BatchSize(size = 200)
    private Restaurant restaurant;

    public Menu(LocalDate localDate, double price, String description) {
        this.localDate = localDate;
        this.price = price;
        this.description = description;
    }

    public Menu() {
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public double getPrice() {
        return price;
    }

//    public String[] getDishes() {
//        return dishes;
//    }


    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }


    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", localDate=" + localDate +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", restaurant=" + restaurant +
                '}';
    }
}
