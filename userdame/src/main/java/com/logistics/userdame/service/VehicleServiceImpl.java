package com.logistics.userdame.service;

import com.logistics.userdame.bean.LogUser;
import com.logistics.userdame.bean.LogVehicle;
import com.logistics.userdame.dao.VehicleDao;
import com.logistics.userdame.uilt.Pager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class VehicleServiceImpl implements VehicleService {
    @Resource
    private VehicleDao vehicleDao;

    @Override
    public List<LogVehicle> VehicleList() {
        return vehicleDao.getVehicleList();
    }

    @Override
    public void VehicleAdd(LogVehicle logVehicle) {
        vehicleDao.setVehicleAdd(logVehicle);
    }

    @Override
    public void VehicleDelete(Integer vid) {
        vehicleDao.setVehicleDelete(vid);
    }

    @Override
    public void VehicleUpdate(LogVehicle logVehicle) {
        vehicleDao.setVehicleUpdate(logVehicle);
    }

    @Override
    public LogVehicle Vehicle(Integer vid) {
        return vehicleDao.getVehicle(vid);
    }

    @Override
    public List<String> VehicleCategory() {
        return vehicleDao.getVehicleCategory();
    }

    @Override
    public int VPageSize1() {
        return vehicleDao.getVPageSize();
    }

    @Override
    public List<LogVehicle> VPage1(Pager pager) {
        int i=(pager.getCurrPage()-1)*pager.pageSize;
        return vehicleDao.getVPage(i,pager.pageSize);
    }
}
