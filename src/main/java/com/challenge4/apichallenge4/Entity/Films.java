package com.challenge4.apichallenge4.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "Films")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Films {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "film_code")
    private int filmCode;
    @Column(name = "film_name")
    private String film_name;
    @Column(name = "show_film")
    private boolean showFilm;

    public Films(){

    }
    public Films(String film_name, boolean showFilm){
        this.film_name = film_name;
        this.showFilm = showFilm;
    }

    public int getFilmCode() {
        return filmCode;
    }

    public void setFilmCode(int filmCode) {
        this.filmCode = filmCode;
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
