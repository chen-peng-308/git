package com.logistics.userdame.service;

import com.logistics.userdame.bean.LogUser;
import com.logistics.userdame.bean.LogVehicle;
import com.logistics.userdame.dao.VehicleDao;
import com.logistics.userdame.uilt.Pager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

public interface VehicleService {
    List<LogVehicle> VehicleList();//获取车辆列表
    void VehicleAdd(LogVehicle logVehicle);//添加车辆
    void VehicleDelete(Integer vid);//删除车辆
    void VehicleUpdate(LogVehicle logVehicle);//修改车辆
    LogVehicle Vehicle(Integer vid);//查找车辆
    List<String> VehicleCategory();//查询车辆类型
    int VPageSize1();//查询数据总数
    List<LogVehicle> VPage1(Pager pager);//查询分页
}
