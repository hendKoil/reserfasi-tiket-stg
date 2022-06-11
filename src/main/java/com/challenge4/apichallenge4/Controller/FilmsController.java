package com.challenge4.apichallenge4.Controller;

import com.challenge4.apichallenge4.Dto.CustomizeResponse;
import com.challenge4.apichallenge4.Dto.FilmsDto;

import com.challenge4.apichallenge4.Entity.Films;
import com.challenge4.apichallenge4.Repository.FilmsRepo;
import com.challenge4.apichallenge4.Service.FilmService;
import com.challenge4.apichallenge4.Service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class FilmsController {
    @Autowired
    FilmService filmService;


//    @PostMapping("api/films")
//    public ResponseEntity<?> submit_film_ctr(@RequestBody FilmsDto filmsDto){
//        Films film = filmService.submit_films(filmsDto);
//        Map<String , Object> map  = new HashMap<>();
//        map.put("films", film);
//
//        return new ResponseEntity<>(map, HttpStatus.ACCEPTED);
//    }

    @PostMapping("api/films") //customize response by dto
    public Map<String, Object> submit_film_ctr(@RequestBody FilmsDto filmsDto){
        Films film = filmService.submit_films(filmsDto);
        CustomizeResponse customizeResponse = new CustomizeResponse();
        Map<String, Object> map = new HashMap<>();
        customizeResponse.setFilm_name(film.getFilm_name());
        customizeResponse.setShow(film.isShowFilm());

        map.put("films", customizeResponse);
        int idFilm = filmService.getIdFilmSave(filmsDto);
         return map;
    }

    @GetMapping("api/films/all")
    public List<Films> getAllFilm(){

        return filmService.getAllFilms();
    }
    @PostMapping("api/films/all/{page}/{size}")
    public Map<String, Object> filmPaging(@PathVariable("page") int page, @PathVariable("size") int size){
        Pageable pageable = PageRequest.of(page,size);
        Page<Films> data = filmService.filmSorting(pageable);
        Map<String, Object> map = new HashMap<>();
        map.put("page size",size);
        map.put("rowCount", data.getTotalElements());
        map.put("page", pageable.getPageNumber());
        map.put("data", data.getContent());
        return map;
    }

}
