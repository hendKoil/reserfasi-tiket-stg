package com.challenge4.apichallenge4.Controller;

import com.challenge4.apichallenge4.Entity.MasterStudio;
import com.challenge4.apichallenge4.Service.MasterStudioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MasterStudioController {
    @Autowired
    MasterStudioService masterStudioService;

    @GetMapping("api/studio/check/seats/")
    public List<MasterStudio> getAllStudioByStatus(@RequestParam(value = "status", required = true) boolean status){
        List<MasterStudio> lsStudio = masterStudioService.getByStatusStudioMaster(status);
        return lsStudio;
    }
}
