package com.challenge4.apichallenge4.Controller;

import com.challenge4.apichallenge4.Dto.SchedulesDto;
import com.challenge4.apichallenge4.Entity.Schedules;
import com.challenge4.apichallenge4.Repository.SchedulesRepo;
import com.challenge4.apichallenge4.Service.SchedulesService;
import com.challenge4.apichallenge4.Service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SchedulesController {
    @Autowired
    SchedulesService schedulesService;
    @Autowired
    SchedulesRepo schedulesRepo;


    @PostMapping("api/schedules/{film_code}")
    public Schedules submit_schedules_ctr(@PathVariable("film_code") int film_code, @RequestBody SchedulesDto schedulesDto){
        return schedulesService.submit_schedules(film_code, schedulesDto);
    }

    @GetMapping("api/schedules/list/")
    public List<Schedules> getAllSchedules(){
        return schedulesRepo.findAll();
    }

    @GetMapping("api/schedule/{id_film}")
    public List<Schedules> getAllSchedules(@PathVariable("id_film") int idFilm){
        return schedulesRepo.findByFilmsFilmCode(idFilm);
    }
}
