package com.challenge4.apichallenge4.Dto;

import com.challenge4.apichallenge4.Entity.Films;
import com.challenge4.apichallenge4.Entity.MasterStudio;
import com.challenge4.apichallenge4.Entity.Schedules;
import com.challenge4.apichallenge4.Entity.Users;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.apache.catalina.User;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Setter
@Getter
public class OrderCustomerDto {
    private int idTiket;
    private int idSeat;
    private boolean status;
    private int schedules_id;
    private Integer filmCode;
    private int films;
    private int users;
}
