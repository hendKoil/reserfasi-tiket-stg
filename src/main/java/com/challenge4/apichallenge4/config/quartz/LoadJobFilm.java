package com.challenge4.apichallenge4.config.quartz;

import com.challenge4.apichallenge4.Service.FilmService;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class LoadJobFilm  extends QuartzJobBean {

    FilmService filmService;

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        filmService.getAllFilms();
    }
}

