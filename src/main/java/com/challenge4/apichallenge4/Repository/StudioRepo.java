package com.challenge4.apichallenge4.Repository;

import com.challenge4.apichallenge4.Entity.Studio;
import com.challenge4.apichallenge4.Entity.StudioPk;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudioRepo extends JpaRepository<Studio, StudioPk> {
    List<Studio> findByStudioIdFilmCode(int filmCode);
    List<Studio> findByStudioIdScheduleId(int scheduleId);

}
