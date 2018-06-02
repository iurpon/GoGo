package ru.firstproject.repository;

import org.springframework.data.repository.query.Param;
import ru.firstproject.model.User;
import ru.firstproject.model.Vote;

import java.time.LocalDate;
import java.util.List;

public interface UserRepository {
    User save(User user);

    // false if not found
    void delete(int id);

    // null if not found
    User get(int id);

    List<User> getAll();

    Vote findUserVote(int userId, LocalDate localDate);
}
