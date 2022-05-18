package com.challenge4.apichallenge4.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "customer_order")
@Setter
@Getter
public class OrderCustomer {
    @Id
    @Column(name = "id_tiket")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTiket;

    @Column(name = "id_seat")
    private int idSeat;

    @Column(name = "schedules_id")
    private int schedules_id;


    @Column(name = "film_code")
    private int filmCode;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_users", nullable = false)
    private Users idUser;

}
