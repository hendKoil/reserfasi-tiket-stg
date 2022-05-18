package com.challenge4.apichallenge4.Service;

import com.challenge4.apichallenge4.Entity.MasterStudio;
import com.challenge4.apichallenge4.Repository.MasterStudioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MasterStudioService {
    @Autowired
    MasterStudioRepo masterStudioRepo;

    public List<MasterStudio> getByStatusStudioMaster(boolean status){
        return masterStudioRepo.findByStatus(status);
    }

    public  MasterStudio updateStatusStudio(int idStudio, boolean status){
        MasterStudio updateStudio = masterStudioRepo.findByIdStudio(idStudio);

        if(updateStudio != null){
            updateStudio.setStatus(status);
            return masterStudioRepo.save(updateStudio);
        }else{
            System.out.println("studio not fount");
        }
        return updateStudio;
    }
}
