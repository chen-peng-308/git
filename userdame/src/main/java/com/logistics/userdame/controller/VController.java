package com.logistics.userdame.controller;


import com.logistics.userdame.bean.LogUser;
import com.logistics.userdame.bean.LogVehicle;
import com.logistics.userdame.service.VehicleService;
import com.logistics.userdame.uilt.BsUilt;
import com.logistics.userdame.uilt.Contants;
import com.logistics.userdame.uilt.Pager;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

//车辆模块
@Controller
public class VController {
    @Resource
    private VehicleService vehicleService;


    @RequestMapping("/VList")//获取车辆列表
    public String VList(Model model, Pager pager) {
        pager.page(vehicleService.VPageSize1());//总数据
        pager.data = vehicleService.VPage1(pager);//分页数据
        model.addAttribute("Vlist", pager);
        return "VehicleList";
    }

    @RequestMapping("/VAdd")//添加车辆
    public String VAdd(Model model) {
//        List<String> Category = vehicleService.VehicleCategory();//获取车辆类型
//        model.addAttribute("VCategory", Category);
        return "VehicleAdd";
    }

    @RequestMapping("/VAdd1")//添加车辆
    public String VAdd1(LogVehicle logVehicle, MultipartFile logvfilt1) {
        logVehicle.setLogvfilt(BsUilt.setFlit(logvfilt1, Contants.url1));
        vehicleService.VehicleAdd(logVehicle);
        return "redirect:VList";
    }

    @RequestMapping("/VDelete")//删除车辆
    public String VDelete(Integer id) {
        vehicleService.VehicleDelete(id);
        return "redirect:VList";
    }

    @RequestMapping("/VUpdate")//修改获取车辆信息
    public String VUpdate(Integer id, Model model) {
//        List<String> Category = vehicleService.VehicleCategory();//获取汽车类型
        LogVehicle logVehicle = vehicleService.Vehicle(id);
        model.addAttribute("logv", logVehicle);
//        model.addAttribute("VCategory", Category);
        return "VehicleUpdate";
    }

    @RequestMapping("/VUpdate1")//修改车辆信息
    public String VUpdate1(LogVehicle logVehicle, MultipartFile logvfilt1) {
        if (!logvfilt1.isEmpty()) {
            logVehicle.setLogvfilt(BsUilt.setFlit(logvfilt1, Contants.url1));
        }
        vehicleService.VehicleUpdate(logVehicle);
        return "redirect:VList";
    }

    @RequestMapping("BatchV")
    public String BatchV(MultipartFile file1){
//创建临时file对象
        File file= null;
        try {
            file = File.createTempFile("tmp", null);
            //把MultipartFile对象转换成java.io.FileUI对象
            file1.transferTo(file);
            InputStream inputStream = new FileInputStream(file);
            HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
            HSSFSheet sheet = workbook.getSheetAt(0);
            //循环行()
            for (int i=1;i<sheet.getLastRowNum();i++){
                HSSFRow row = sheet.getRow(i);
                LogVehicle logVehicle = new LogVehicle();


//通过setCellType将单元格类型设置为字符串，然后通过getRichStringCellValue读取该单元格数据，然后将读取到的字符串转换为响应的数字类型，比如BigDecimal，int等


                logVehicle.setLogvname(row.getCell(0).getStringCellValue());

//                row.getCell(1).setCellType(Cell.CELL_TYPE_STRING);
                logVehicle.setLogvplatenumber(row.getCell(1).getStringCellValue());

//                row.getCell(2).setCellType(Cell.CELL_TYPE_STRING);
                logVehicle.setLogvfilt(row.getCell(2).getStringCellValue());

                logVehicle.setLogvload(row.getCell(3).getStringCellValue());

                row.getCell(4).setCellType(Cell.CELL_TYPE_STRING);
                logVehicle.setLogvinspection(row.getCell(4).getStringCellValue());

                logVehicle.setLogvlong(row.getCell(5).getStringCellValue());

                logVehicle.setLogvwide(row.getCell(6).getStringCellValue());
                logVehicle.setLogvtall(row.getCell(7).getStringCellValue());
                logVehicle.setLogvtype(row.getCell(8).getStringCellValue());



                //一行数据做一次添加
                vehicleService.VehicleAdd(logVehicle);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "redirect:VList";
    }
}
