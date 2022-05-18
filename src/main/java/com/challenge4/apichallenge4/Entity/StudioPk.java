package com.challenge4.apichallenge4.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Setter
@Getter
public class StudioPk implements Serializable {

    private int filmCode;
    private int scheduleId;

}
