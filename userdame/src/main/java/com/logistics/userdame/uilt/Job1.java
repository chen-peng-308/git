package com.logistics.userdame.uilt;

import com.logistics.userdame.bean.LogFinance;
import com.logistics.userdame.service.FinancialService;
import com.logistics.userdame.service.FinancialServiceImpl;
import com.logistics.userdame.service.WaybillService;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.SimpleScheduleBuilder;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Job1 implements Job {
    @Resource
    private FinancialService financialService;
    @Resource
    private WaybillService waybillService;
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date date2 = new Date();//获取当前时间    
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date2);
//        calendar.add(Calendar.YEAR, -1);//当前时间减去一年，即一年前的时间    
        calendar.add(Calendar.MONTH, -1);//当前时间前去一个月，即一个月前的时间    
//        calendar.getTime();//获取一年前的时间，或者一个月前的时间    
        //获取时间
        String date=simpleDateFormat.format(calendar.getTime());
        System.out.println(date);
//        截取时间
        String date1=date.substring(0,7);
        int i= financialService.DateFinance(date1);//时间段支出的金额总和
        int i1=waybillService.DateWaybill(date1);//时间段收入的金额总和
        int i2=i1-i;
        System.out.println("支出"+i+"收入"+i1+"利润"+i2);
        LogFinance logFinance=new LogFinance();
        logFinance.setLogftime(simpleDateFormat.format(new Date()));
        logFinance.setLogfexpenditure(i);
        logFinance.setLogfincome(i1);
        logFinance.setLogfprofit(i2);
        System.out.println(logFinance.toString());
        financialService.LogFinanceAdd(logFinance);

    }
}
