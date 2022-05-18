package com.challenge4.apichallenge4.Service;

import com.challenge4.apichallenge4.Dto.SchedulesDto;
import com.challenge4.apichallenge4.Entity.Films;
import com.challenge4.apichallenge4.Entity.Schedules;
import com.challenge4.apichallenge4.Repository.FilmsRepo;
import com.challenge4.apichallenge4.Repository.SchedulesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SchedulesService {
    @Autowired
    SchedulesRepo schedulesRepo;
    @Autowired
    FilmsRepo filmsRepo;
        public Schedules submit_schedules(int filmCode , SchedulesDto schedulesDto){
        Optional<Films> films = filmsRepo.findById(filmCode);
        Schedules schedules_save = new Schedules();
        schedules_save.setTanggal_tayang(schedulesDto.getTanggal_tayang());
        schedules_save.setHarga_tiket(schedulesDto.getHarga_tiket());
        schedules_save.setJam_mulai(schedulesDto.getJam_mulai());
        schedules_save.setJam_selesai(schedulesDto.getJam_selesai());
        schedules_save.setFilms(schedulesDto.getFilms());

        return schedulesRepo.save(schedules_save);

    }

}
