package com.challenge4.apichallenge4.Repository;

import com.challenge4.apichallenge4.Entity.MasterStudio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MasterStudioRepo extends JpaRepository<MasterStudio, Integer> {
    public List<MasterStudio> findByStatus(boolean status);
    public MasterStudio findByIdStudio(int studioId);
    List<MasterStudio> findByIdStudio(Integer studioId);
}
