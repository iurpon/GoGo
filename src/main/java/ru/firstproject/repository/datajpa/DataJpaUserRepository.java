package ru.firstproject.repository.datajpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.firstproject.model.User;
import ru.firstproject.repository.UserRepository;

import java.util.List;


@Repository
public class DataJpaUserRepository implements UserRepository {

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
        return repository.getOne(id);
    }

    @Override
    public List<User> getAll() {
        return repository.findAll();
    }
}
