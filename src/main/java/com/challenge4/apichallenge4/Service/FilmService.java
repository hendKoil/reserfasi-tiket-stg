package com.challenge4.apichallenge4.Service;

import com.challenge4.apichallenge4.Dto.FilmsDto;
import com.challenge4.apichallenge4.Entity.Films;
import com.challenge4.apichallenge4.Repository.FilmsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FilmService {
    @Autowired
    FilmsRepo filmsRepo;


    public Films submit_films(FilmsDto filmsDto) {
        Films save = new Films(filmsDto.getFilm_name(), filmsDto.isShowFilm());
        System.out.println(save.getFilmCode());
        return filmsRepo.save(save);
    }
    public int getIdFilmSave(FilmsDto filmsDto){
        Films save = submit_films(filmsDto);

        return save.getFilmCode();
    }

    }