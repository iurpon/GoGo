package ru.firstproject.repository.datajpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.firstproject.model.Vote;
import ru.firstproject.repository.VoteRepository;

import java.time.LocalDate;

@Repository
public class DataJpaVoteRepository implements VoteRepository{
    @Autowired
    private ProxyVoteRepository repository;

    @Override
    public Vote getVote(int userId, LocalDate date) {
        return repository.getVoteByUserIdAndRegistered(userId,date);
    }

    @Override
    @Transactional
    public Vote save(Vote vote) {
        return repository.save(vote);
    }
}
