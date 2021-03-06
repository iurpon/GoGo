package ru.firstproject.repository;

import ru.firstproject.model.Vote;

import java.time.LocalDate;
import java.util.List;

public interface VoteRepository {
    Vote getVote(int userId, LocalDate date);
    Vote save(Vote vote);
    Vote getUserVote(int userId,LocalDate date);
    List<Vote> getTodayVotes();
}
