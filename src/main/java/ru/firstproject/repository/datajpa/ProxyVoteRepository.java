package ru.firstproject.repository.datajpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.firstproject.model.Vote;

import java.time.LocalDate;
import java.util.List;

@Transactional(readOnly = true)
public interface ProxyVoteRepository extends JpaRepository<Vote,Integer> {

    Vote getVoteByUserIdAndRegistered(int userId,LocalDate date);

    @Override
    @Transactional
    Vote save(Vote entity);

    @Query("select v from Vote v left join fetch v.user where v.user.id =:id and v.registered =:date")
    Vote findUserVote(@Param("id") int id,@Param("date") LocalDate date);

    List<Vote> getAllByRegistered(LocalDate date);
}
