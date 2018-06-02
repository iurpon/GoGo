package ru.firstproject.repository.datajpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.firstproject.model.User;
import ru.firstproject.model.Vote;
import ru.firstproject.repository.UserRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;


@Repository
public class DataJpaUserRepository implements UserRepository {
    private Logger logger = LoggerFactory.getLogger(DataJpaUserRepository.class);

    @Autowired
    private ProxyUserRepository repository;

    @Transactional
    @Override
    public User save(User user) {
        return repository.save(user);
    }

    @Transactional
    @Override
    public void delete(int id) {
         repository.deleteById(id);
    }

    @Override
    public User get(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<User> getAll() {
        return repository.findAll();
    }

    @Override
    public Vote findUserVote(int userId, LocalDate localDate) {
        return null;
    }
}
