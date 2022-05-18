package com.challenge4.apichallenge4.Entity;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Table(name = "master_studio")
@Setter
@Getter
public class MasterStudio {
    @Id
    @Column(name = "id_studio")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int idStudio;

    @Column(name = "studio")
    public String studio;

    @Column(name = "no_seat")
    public int noSeat;

    @Column(name = "status")
    public boolean status;
}
