package ru.firstproject.repository.datajpa;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import ru.firstproject.model.User;

import java.util.List;
import java.util.Optional;

@Transactional(readOnly = true)
public interface ProxyUserRepository extends JpaRepository<User,Integer> {
    @Override
    List<User> findAll(Sort sort);

    @Transactional
    @Override
    User save(User entity);

    @Override
    Optional<User> findById(Integer integer);

    @Transactional
    @Override
    void deleteById(Integer integer);
}
