package ru.firstproject.repository;

import ru.firstproject.model.User;

import java.util.List;

public interface UserRepository {
    User save(User user);

    // false if not found
    void delete(int id);

    // null if not found
    User get(int id);

    List<User> getAll();
}
