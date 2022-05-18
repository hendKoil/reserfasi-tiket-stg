package com.challenge4.apichallenge4.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "studio")
@Setter
@Getter
public class Studio {

        @EmbeddedId
        @AttributeOverrides
                ({
                        @AttributeOverride(name = "filmCode", column = @Column(name = "film_code")),
                        @AttributeOverride(name = "scheduleId", column = @Column(name = "schedule_id"))
                })
       private StudioPk studioId;

        private String studioName;
        private int seats;
}
