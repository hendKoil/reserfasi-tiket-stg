package com.challenge4.apichallenge4.config.quartz;

import org.quartz.JobDetail;
import org.quartz.Trigger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.scheduling.quartz.SpringBeanJobFactory;

@Configuration
public class QuartzSchedulerConfig {
    private ApplicationContext applicationContext;

    @Autowired
    public QuartzSchedulerConfig(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Bean
    public SpringBeanJobFactory springBeanJobFactory() {
        SpringBeanJobFactory jobFactory = new SpringBeanJobFactory();
        jobFactory.setApplicationContext(this.applicationContext);
        return jobFactory;
    }

    @Bean
    public SchedulerFactoryBean schedulerFactoryBean() {
        SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
        schedulerFactoryBean.setJobFactory(springBeanJobFactory());
        JobDetail[] jobDetail = {filmScheduleCheckJob().getObject()};
        Trigger[] triggers = {filmScheduleCheckTrigger().getObject()};

        schedulerFactoryBean.setJobDetails(jobDetail);
        schedulerFactoryBean.setTriggers(triggers);
        return schedulerFactoryBean;
    }

    @Bean
    public JobDetailFactoryBean filmScheduleCheckJob() {
        JobDetailFactoryBean jobDetailFactoryBean = new JobDetailFactoryBean();
        jobDetailFactoryBean.setJobClass(LoadJobFilm.class);
        jobDetailFactoryBean.setName("Load Films");
        jobDetailFactoryBean.setDescription("Show All Film");
        jobDetailFactoryBean.setDurability(true);
        return jobDetailFactoryBean;
    }

    @Bean
    public CronTriggerFactoryBean filmScheduleCheckTrigger() {
        CronTriggerFactoryBean cronTriggerFactoryBean = new CronTriggerFactoryBean();
        cronTriggerFactoryBean.setJobDetail(filmScheduleCheckJob().getObject());
        cronTriggerFactoryBean.setName("Load films every hour");
        cronTriggerFactoryBean.setCronExpression("0 1 * ? * *"); //At 1 minutes past the hour
        return cronTriggerFactoryBean;
    }
}
