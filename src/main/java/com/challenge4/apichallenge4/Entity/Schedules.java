package com.challenge4.apichallenge4.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Time;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "schedules")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Setter
@Getter
public class Schedules {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "schedules_generator")
    private int id;

    @Column(name = "tanggal_tayang")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date tanggal_tayang;

    @Column(name = "jam_mulai")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Date jam_mulai;

    @Column(name = "jam_selesai")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Date jam_selesai;

    @Column(name = "harga_tiket")
    private BigDecimal harga_tiket;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "films_code", nullable = false)
    private Films films;



//    private Set<Users> users;





    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getTanggal_tayang() {
        return tanggal_tayang;
    }

    public void setTanggal_tayang(Date tanggal_tayang) {
        this.tanggal_tayang = tanggal_tayang;
    }


    public void setJam_mulai(Time jam_mulai) {
        this.jam_mulai = jam_mulai;
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

    public void setJam_selesai(Time jam_selesai) {
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
