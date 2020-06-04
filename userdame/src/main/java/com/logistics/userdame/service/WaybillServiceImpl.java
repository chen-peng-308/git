package com.logistics.userdame.service;

import com.logistics.userdame.bean.LogVehicle;
import com.logistics.userdame.bean.LogWaybill;
import com.logistics.userdame.dao.WaybillDao;
import com.logistics.userdame.uilt.Pager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class WaybillServiceImpl implements WaybillService {
    @Resource
    private WaybillDao waybillDao;

    @Override
    public int WaybillAdd(LogWaybill logWaybill) {
        return waybillDao.setWaybillAdd(logWaybill);
    }

    @Override
    public List<LogWaybill> MyWaybill(String name) {
        return waybillDao.getMyWaybill(name);
    }

    @Override
    public void WaybillDelete(Integer id) {
        waybillDao.setWaybillDelete(id);
    }

    @Override
    public boolean WaybillPayment(Integer id,String p,String paytime) {
        int i=waybillDao.setWaybillPayment(id,p,paytime);
        if(i==0){
            return false;
        }else {
            return true;
        }
    }

    @Override
    public int WPageSize1() {
        return waybillDao.getWPageSize();
    }

    @Override
    public List<LogWaybill> WPage1(Pager pager) {
        int i=(pager.getCurrPage()-1)*pager.pageSize;
        return waybillDao.getWPage(i,pager.pageSize);
    }

    @Override
    public LogWaybill Waybill(Integer id) {
        return waybillDao.getWaybill(id);
    }

    @Override
    public void WUpdate(LogWaybill logWaybill) {
        waybillDao.setWUpdate(logWaybill);
    }

    @Override
    public int DateWaybill(String date) {
        String date1="%"+date+"%";
        return waybillDao.getDateWaybill(date1);
    }

    @Override
    public List<LogWaybill> WaybillList() {
        return waybillDao.getWaybillList();
    }
}
