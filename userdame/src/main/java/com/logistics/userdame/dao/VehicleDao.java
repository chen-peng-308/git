package com.logistics.userdame.dao;

import com.logistics.userdame.bean.LogUser;
import com.logistics.userdame.bean.LogVehicle;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public interface VehicleDao {
    List<LogVehicle> getVehicleList();//获取车辆列表
    void setVehicleAdd(LogVehicle logVehicle);//添加车辆
    void setVehicleDelete(Integer vid);//删除车辆
    LogVehicle getVehicle(Integer vid);//查找车辆
    void setVehicleUpdate(LogVehicle logVehicle);//修改车辆
    List<String> getVehicleCategory();//查询车辆类型
    int getVPageSize();//查询数据数量
    List<LogVehicle> getVPage(@Param("page") int page, @Param("pageSize") int pageSize);//分页查询
}
