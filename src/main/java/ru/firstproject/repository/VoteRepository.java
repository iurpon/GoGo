package ru.firstproject.repository;

import ru.firstproject.model.Vote;

import java.time.LocalDate;

public interface VoteRepository {
    Vote getVote(int userId, LocalDate date);
    Vote save(Vote vote);
}
