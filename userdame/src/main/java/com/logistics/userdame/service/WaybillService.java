package com.logistics.userdame.service;

import com.logistics.userdame.bean.LogVehicle;
import com.logistics.userdame.bean.LogWaybill;
import com.logistics.userdame.uilt.Pager;

import java.util.List;

public interface WaybillService {
    int WaybillAdd(LogWaybill logWaybill);//添加订单
    List<LogWaybill> MyWaybill(String name);////查找自己的订单
    void WaybillDelete(Integer id);//删除订单
    boolean WaybillPayment(Integer id,String p,String paytime);//付款操作
    int WPageSize1();//查询数据总数
    List<LogWaybill> WPage1(Pager pager);//查询分页
    LogWaybill Waybill(Integer id);//查找某个订单
    void WUpdate(LogWaybill logWaybill);//修改订单
    int DateWaybill(String date);//查询每月收入
    List<LogWaybill> WaybillList();//获取没付款全部数据
}
