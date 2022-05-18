package com.challenge4.apichallenge4.Service;

import com.challenge4.apichallenge4.Dto.StudioDto;
import com.challenge4.apichallenge4.Entity.MasterStudio;
import com.challenge4.apichallenge4.Entity.Studio;
import com.challenge4.apichallenge4.Repository.MasterStudioRepo;
import com.challenge4.apichallenge4.Repository.StudioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudioServices {
    @Autowired
    StudioRepo studioRepo;
    @Autowired
    MasterStudioService masterStudioService;
    @Autowired
    MasterStudioRepo masterStudioRepo;

    public Studio saveStudio(StudioDto studioDto){
        Studio saveStudio = new Studio();
        saveStudio.setStudioId(studioDto.getStudio());

        //get kursi
        MasterStudio studio = masterStudioRepo.findByIdStudio(studioDto.getMasterStudioDto().getIdStudio());


        studioDto.getMasterStudioDto().setNoSeat(studio.getNoSeat());
        studioDto.getMasterStudioDto().setStudio_name(studio.getStudio());

        saveStudio.setSeats(studio.getNoSeat());
        saveStudio.setStudioName(studio.getStudio());

        return studioRepo.save(saveStudio);

    }
}
