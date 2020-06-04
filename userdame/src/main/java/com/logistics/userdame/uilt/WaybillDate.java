package com.logistics.userdame.uilt;

import com.logistics.userdame.bean.LogWaybill;
import com.logistics.userdame.service.WaybillService;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Repository
//时间比较方法
public class WaybillDate {
    @Resource
    private WaybillService waybillService;
    public void delete(){
        List<LogWaybill> logWaybills=waybillService.WaybillList();
        for (LogWaybill logWaybill:logWaybills) {
            //比较时间差
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

            Date d1 = null;
            try {
                d1 = df.parse(logWaybill.getLogwordertime());
                Date d2 = df.parse(BsUilt.setDate(new Date()));
                long diff = d2.getTime() - d1.getTime();
                long days = diff / (1000 * 60 * 60 * 24);
                if(days>=1){
                    waybillService.WaybillDelete(logWaybill.getLogwid());
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }
}
