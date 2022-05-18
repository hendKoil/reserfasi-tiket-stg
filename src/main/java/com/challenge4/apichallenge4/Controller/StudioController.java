package com.challenge4.apichallenge4.Controller;

import com.challenge4.apichallenge4.Dto.StudioDto;
import com.challenge4.apichallenge4.Entity.Studio;
import com.challenge4.apichallenge4.Service.StudioServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class StudioController {

    @Autowired
    StudioServices studioServices;


//    @PostMapping("api/v2/studio/")
//    public Studio submitStudio(@RequestBody StudioDto studioDto){
//        Studio studio = studioServices.saveStudio(studioDto);
//        return studio;

//    }
    @PostMapping("api/v1/studio/")
    public Map<String, Object> submitStudio2(@RequestBody StudioDto studioDto){
        Studio studios = studioServices.saveStudio(studioDto);
        Map<String, Object> map = new HashMap<>();
        map.put("film_schedule", studios);
        map.put("detail_studio", studioDto.getMasterStudioDto());
        return map;

    }
}
