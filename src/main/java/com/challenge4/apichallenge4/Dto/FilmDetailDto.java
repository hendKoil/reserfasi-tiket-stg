package com.challenge4.apichallenge4.Dto;

//import com.challenge4.apichallenge4.Entity.VwJadwalFilms;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Setter
@Getter
public class FilmDetailDto {

        private int idJadwal;
        private Date tanggalTayang;
        private String filmName;
        private int filmCode;
        private BigDecimal hargaTiket;
        private String studiName;
        private int seats;

    }

