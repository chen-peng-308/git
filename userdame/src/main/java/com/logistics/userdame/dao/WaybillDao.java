package com.logistics.userdame.dao;


import com.logistics.userdame.bean.LogVehicle;
import com.logistics.userdame.bean.LogWaybill;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public interface WaybillDao {
    int setWaybillAdd(LogWaybill logWaybill);//添加订单
    List<LogWaybill> getMyWaybill(String name);//查找自己的订单
    void setWaybillDelete(Integer id);//删除订单
    int setWaybillPayment(@Param("id1") Integer id,@Param("payway1")String payway,@Param("paytime")String paytime);//付款操作
    int getWPageSize();//查询数据数量
    List<LogWaybill> getWPage(@Param("page") int page, @Param("pageSize") int pageSize);//分页查询
    LogWaybill getWaybill(Integer id);//查找某个订单
    void setWUpdate(LogWaybill logWaybill);//修改订单
    int getDateWaybill(String date);//查询每月收入
    List<LogWaybill> getWaybillList();//获取没付款全部数据
}
