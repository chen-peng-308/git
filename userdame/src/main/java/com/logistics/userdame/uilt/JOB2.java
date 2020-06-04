package com.logistics.userdame.uilt;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import javax.annotation.Resource;

public class JOB2 implements Job {
    @Resource
    private WaybillDate waybillDate;
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        waybillDate.delete();
    }
}
