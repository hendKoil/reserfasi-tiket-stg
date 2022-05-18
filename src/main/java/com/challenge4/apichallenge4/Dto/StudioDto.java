package com.challenge4.apichallenge4.Dto;

import com.challenge4.apichallenge4.Entity.Studio;
import com.challenge4.apichallenge4.Entity.StudioPk;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Setter
@Getter
public class StudioDto {
    private int film_code;
    private int schedule_id;
    private int seat;
    private int idStudio;
    private StudioPk studio;
    public String studioName;
//    int studioId;
//    boolean status;
//    @JsonIgnore
   private MasterStudioDto masterStudioDto;
}
