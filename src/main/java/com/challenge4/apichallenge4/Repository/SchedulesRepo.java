package com.challenge4.apichallenge4.Repository;

import com.challenge4.apichallenge4.Entity.Schedules;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface SchedulesRepo extends JpaRepository<Schedules, Integer> {
    List<Schedules> findByFilmsFilmCode(int postId);
    public Schedules findById(int idSchedules);
    @Transactional
     void deleteById(int filmCode);
}
