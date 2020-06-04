package com.logistics.userdame.uilt;

import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


//星号(*)：可用在所有字段中，表示对应时间域的每一个时刻，例如，*在分钟字段时，表示“每分钟”；
//        问号（?）：该字符只在日期和星期字段中使用，它通常指定为“无意义的值”，相当于点位符；
//        减号(-)：表达一个范围，如在小时字段中使用“10-12”，则表示从10到12点，即10,11,12；
//        逗号(,)：表达一个列表值，如在星期字段中使用“MON,WED,FRI”，则表示星期一，星期三和星期五；
//        斜杠(/)：x/y表达一个等步长序列，x为起始值，y为增量步长值。如在分钟字段中使用0/15，则表示为0,15,30和45秒，而5/15在分钟字段中表示5,20,35,50，你也可以使用*/y，它等同于0/y；

@Configuration
public class JOBConfig {
    @Bean
    public JobDetail getJobDetail(){
        JobDetail jobDetail=JobBuilder.newJob(Job1.class).withIdentity("job1").storeDurably().build();
        return jobDetail;
        //JobDataMap可以给任务execute传递参数
//        JobDataMap jobDataMap=new JobDataMap();
//        jobDataMap.put("",);
    }

    @Bean
    public Trigger myTrigger(){
        Trigger trigger=TriggerBuilder.newTrigger().forJob(getJobDetail()).withDescription("trigger").startNow()
//                .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInHours(2).repeatForever())
//                .withSchedule(CronScheduleBuilder.cronSchedule("0 25 11 25 5 ? *"))//每隔两秒执行一次
                .withSchedule(CronScheduleBuilder.cronSchedule("0 0 0 1 * ? *"))//每月执行一次
                .build();
        return trigger;
    }

    @Bean
    public JobDetail getJobDetai2(){
        JobDetail jobDetail=JobBuilder.newJob(JOB2.class).withIdentity("JOB2").storeDurably().build();
        return jobDetail;
    }

    @Bean
    public Trigger myTrigger1(){
        Trigger trigger=TriggerBuilder.newTrigger().forJob(getJobDetai2()).withDescription("trigger").startNow()
                .withSchedule(CronScheduleBuilder.cronSchedule("0 0/5 * * * ? "))//每5分钟执行一次
                .build();
        return trigger;
    }
}
