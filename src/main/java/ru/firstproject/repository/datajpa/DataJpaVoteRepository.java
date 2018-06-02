package ru.firstproject.repository.datajpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.firstproject.model.Vote;
import ru.firstproject.repository.VoteRepository;

import java.time.LocalDate;

@Repository
public class DataJpaVoteRepository implements VoteRepository{
    private Logger logger = LoggerFactory.getLogger(DataJpaVoteRepository.class);
    @Autowired
    private  ProxyVoteRepository repository;



    @Override
    public Vote getVote(int userId, LocalDate date) {
        return repository.getVoteByUserIdAndRegistered(userId,date);
    }

    @Override
    @Transactional
    public Vote save(Vote vote) {
        return repository.save(vote);
    }

    @Override
    public Vote getUserVote(int userId, LocalDate date) {
        logger.debug("DataJpaVoteRepository getUserVote()");
        return repository.findUserVote(userId,date);
    }
}
