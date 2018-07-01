package ru.firstproject.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.AccessType;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.util.List;

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

    @Column(name = "email",nullable = false,unique = true)
    @NotNull
    @Email
    private String email;

    @Column(name = "password",nullable = false)
    @NotNull
    @Size(min = 4,max = 30)
    private String password;

    @Column(name = "isAdmin",nullable = false)
    @NotNull
    private boolean isAdmin;


    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Vote> votes;

    public List<Vote> getVotes() {
        return votes;
    }

    public void setVotes(List<Vote> votes) {
        this.votes = votes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }
}
