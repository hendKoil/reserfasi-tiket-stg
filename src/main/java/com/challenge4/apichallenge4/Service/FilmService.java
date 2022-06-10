package com.challenge4.apichallenge4.Service;

import com.challenge4.apichallenge4.Dto.FilmsDto;
import com.challenge4.apichallenge4.Entity.Films;
import com.challenge4.apichallenge4.Repository.FilmsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Service
@CacheConfig(cacheNames  = "filmCache")
public class FilmService {
    @Autowired
    FilmsRepo filmsRepo;

//    private final String hashReference= "film";

//    @Resource(name="redisTemplate")          // 'redisTemplate' is defined as a Bean in redisConfigClass.java
//    private HashOperations<String, Integer, Films> hashOperations;

    @CacheEvict(cacheNames = "films", allEntries = true)
    public Films submit_films(FilmsDto filmsDto) {
        Films save = new Films(filmsDto.getFilm_name(), filmsDto.isShowFilm());
        System.out.println(save.getFilmCode());
        filmsRepo.save(save);
//        hashOperations.putIfAbsent(hashReference,save.getFilmCode(),save);
        return save;
    }

    public int getIdFilmSave(FilmsDto filmsDto){
        Films save = submit_films(filmsDto);

        return save.getFilmCode();
    }

    @Cacheable(cacheNames = "films")
    public List<Films> getAllFilms(){
        waitSomeTime();
        List<Films> films = filmsRepo.findAll();
//        hashOperations.entries(hashReference);
        return films;
    }
    private void waitSomeTime() {
        System.out.println("Long Wait Begin");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Long Wait End");
    }

    }