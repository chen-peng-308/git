package com.logistics.userdame.controller;


import com.logistics.userdame.bean.LogUser;
import com.logistics.userdame.bean.LogVehicle;
import com.logistics.userdame.bean.LogWaybill;
import com.logistics.userdame.service.UserService;
import com.logistics.userdame.service.VehicleService;
import com.logistics.userdame.service.WaybillService;
import com.logistics.userdame.uilt.BsUilt;
import com.logistics.userdame.uilt.Pager;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

@Controller
public class WController {
    @Resource
    private VehicleService vehicleService;
    @Resource
    private UserService userService;
    @Resource
    private WaybillService waybillService;

    @RequestMapping("/WAdd")//用户添加订单的跳转
    public String WAdd(Model model){
        return "WaybillAdd";
    }

    @RequestMapping("/WAdd1")//用户添加订单
    public String WAdd1(LogWaybill logWaybill){
        logWaybill.setLogwordertime(BsUilt.setDate(new Date()));
        int id= waybillService.WaybillAdd(logWaybill);
        return "index1";
    }

    @RequestMapping(value = "/MyWaybill")//My订单
    public String MyWaybill(String Wname,Model model){
        List<LogWaybill> logWaybills=waybillService.MyWaybill(Wname);
        model.addAttribute("my",logWaybills);
        return "MyWaybill";
    }

    @RequestMapping(value = "/WDelete")//删除订单
    public String WDelete(Integer id,String Wname,RedirectAttributes attr){
        waybillService.WaybillDelete(id);
        if(Wname!=null){//用户删除
            attr.addAttribute("Wname", Wname);//跳转地址带上test参数,可以解决中文乱码方法
            return "redirect:MyWaybill";
        }else {//管理员删除
            return "redirect:WList";
        }
    }

    @ResponseBody
    @RequestMapping("/WPayment")//付款操作
    public Boolean WPayment(Integer id,String payway){
        String date=BsUilt.setDate(new Date());
//        System.out.println(date);
        boolean i= waybillService.WaybillPayment(id,payway,date);
        return i;
    }


    @RequestMapping("/WList")//订单列表
    public String WList(Model model, Pager pager){
        pager.page(waybillService.WPageSize1());//总数据
        pager.data =waybillService.WPage1(pager);//分页数据
        model.addAttribute("wpage",pager);
        return "WaybillList";
    }

    @RequestMapping("/WUpdate")//修改跳转
    public String WUpdate(Integer id,Model model){
        List<LogUser> list=userService.WUserList();//获取全的司机
        List<LogVehicle> logVehicles=vehicleService.VehicleList();//获取全部的车辆信息
        LogWaybill logWaybill=waybillService.Waybill(id);//查询订单信息
        model.addAttribute("logu",list);
        model.addAttribute("logv",logVehicles);
        model.addAttribute("logw",logWaybill);
        return "WaybillUpdate";
    }

    @RequestMapping("/WUpdate1")//修改方法
    public String WUpdate1(LogWaybill logWaybill){
//        System.out.println(logWaybill.toString());
        if(logWaybill.getLogwreturntime()==""){
            if(logWaybill.getLogwunloadtime()==""){
                if(logWaybill.getLogwarrivetime()==""){
                    if(logWaybill.getLogwloadingtime()!=""){
                        logWaybill.setLogwtype("已装货");
                    }
                }else {
                    logWaybill.setLogwtype("已达到目的地");
                }
            }else {
                logWaybill.setLogwtype("已卸货");
            }
        }else {
            logWaybill.setLogwtype("已返回");
        }

//        System.out.println(logWaybill.toString());
        waybillService.WUpdate(logWaybill);
        return "redirect:WList";
    }
}
