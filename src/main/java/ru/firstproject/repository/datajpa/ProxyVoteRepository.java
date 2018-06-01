package ru.firstproject.repository.datajpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import ru.firstproject.model.Vote;

import java.time.LocalDate;

@Transactional(readOnly = true)
public interface ProxyVoteRepository extends JpaRepository<Vote,Integer> {
    Vote getVoteByUserIdAndDate(int userId,LocalDate date);

    @Override
    @Transactional
    Vote save(Vote entity);
}
