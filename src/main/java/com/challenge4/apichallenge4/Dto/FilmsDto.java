package com.challenge4.apichallenge4.Dto;

import com.challenge4.apichallenge4.Entity.Schedules;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class FilmsDto {
    int film_code;
    String film_name;
    boolean showFilm;
//    Schedules schedules;

//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }


    public int getFilm_code() {
        return film_code;
    }

    public void setFilm_code(int film_code) {
        this.film_code = film_code;
    }

    public String getFilm_name() {
        return film_name;
    }

    public void setFilm_name(String film_name) {
        this.film_name = film_name;
    }

    public boolean isShowFilm() {
        return showFilm;
    }

    public void setShowFilm(boolean showFilm) {
        this.showFilm = showFilm;
    }
}
