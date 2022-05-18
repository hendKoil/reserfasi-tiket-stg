package com.challenge4.apichallenge4.Dto;

import com.challenge4.apichallenge4.Entity.Films;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.util.Date;

public class SchedulesDto {
    private int schedule_id;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date tanggal_tayang;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Date jam_mulai;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Date jam_selesai;
    private BigDecimal harga_tiket;
    private Films films;

    public int getSchedule_id() {
        return schedule_id;
    }

    public void setSchedule_id(int schedule_id) {
        this.schedule_id = schedule_id;
    }

    public Date getTanggal_tayang() {
        return tanggal_tayang;
    }

    public void setTanggal_tayang(Date tanggal_tayang) {
        this.tanggal_tayang = tanggal_tayang;
    }

    public Date getJam_mulai() {
        return jam_mulai;
    }

    public void setJam_mulai(Date jam_mulai) {
        this.jam_mulai = jam_mulai;
    }

    public Date getJam_selesai() {
        return jam_selesai;
    }

    public void setJam_selesai(Date jam_selesai) {
        this.jam_selesai = jam_selesai;
    }


    public BigDecimal getHarga_tiket() {
        return harga_tiket;
    }

    public void setHarga_tiket(BigDecimal harga_tiket) {
        this.harga_tiket = harga_tiket;
    }

    public Films getFilms() {
        return films;
    }

    public void setFilms(Films films) {
        this.films = films;
    }
}
