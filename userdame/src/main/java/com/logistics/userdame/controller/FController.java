package com.logistics.userdame.controller;

import com.logistics.userdame.bean.LogExpenditure;
import com.logistics.userdame.bean.LogFinance;
import com.logistics.userdame.service.FinancialService;
import com.logistics.userdame.uilt.Pager;
import com.sun.xml.internal.ws.api.message.HeaderList;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class FController {
    @Resource
    private FinancialService financialService;

    @RequestMapping("EAdd")//添加账单
    public String EAdd(){
        return "ExpenditureAdd";
    }

    @RequestMapping("EAdd1")//添加账单
    public String EAdd1(LogExpenditure logExpenditure){
        System.out.println(logExpenditure.toString());
        financialService.ExpenditureAdd(logExpenditure);
        return "redirect:EList";
    }

    @RequestMapping("EList")//账单列表
    public String EList(Model model, Pager pager){
        pager.page(financialService.EPageSize());//总数据
        pager.data = financialService.EPage(pager);//分页数据
        model.addAttribute("EPage", pager);
        return "ExpenditureList";
    }

    @RequestMapping("EDelete")//删除账单
    public String EDelete(Integer id){
        financialService.ExpenditureDelete(id);
        return "redirect:EList";
    }

    @RequestMapping("EUpdate")//查询修改账单
    public String EUpdate(Integer id,Model model){
        LogExpenditure expenditure= financialService.Expenditure(id);
        model.addAttribute("Expenditure",expenditure);
        return "ExpenditureUpdate";
    }

    @RequestMapping("EUpdate1")//修改账单
    public String EUpdate1(LogExpenditure logExpenditure){
        financialService.ExpenditureUpdate(logExpenditure);
        return "redirect:EList";
    }


    @RequestMapping("logEcharts1")//报表跳转
    public String logEcharts1(){
        return "LogEcharts.html";
    }


    @ResponseBody
    @RequestMapping("/logEcharts")//财务报表
    public List logEcharts(){
        List list=new ArrayList();
        List list1=new ArrayList();
        List list2=new ArrayList();
        List list3=new ArrayList();
        List list4=new ArrayList();
        List list5=new ArrayList();
        List list6=new ArrayList();
        Map map=new HashMap();
        Map map1=new HashMap();
        Map map2=new HashMap();
        list1.add("支出");
        list1.add("收入");
        list1.add("利润");

        List<LogFinance> logFinances=financialService.Finance();

        for (LogFinance logFinance : logFinances) {
            String date = logFinance.getLogftime().substring(5, 7) + "月";
            list2.add(date);

            list3.add(logFinance.getLogfexpenditure());
        }
        for (LogFinance logFinance : logFinances) {

            list4.add(logFinance.getLogfincome());
        }
        for (LogFinance logFinance : logFinances) {

            list5.add(logFinance.getLogfprofit());
        }

        map.put("name","支出");
        map.put("type","bar");
        map.put("data",list3);

        map1.put("name","收入");
        map1.put("type","bar");
        map1.put("data",list4);

        map2.put("name","利润");
        map2.put("type","bar");
        map2.put("data",list5);

        list.add(list1);
        list.add(list2);
        list6.add(map);
        list6.add(map1);
        list6.add(map2);
        list.add(list6);
        return list;
    }

    @RequestMapping("Download")
    public void download(HttpServletResponse httpServletResponse){
        //查询全部数据
        List<LogFinance> logFinances =financialService.Finance();
//创建文本对象
        HSSFWorkbook hssfWorkbook=new HSSFWorkbook();
//创建工作表
        HSSFSheet hssfSheet=hssfWorkbook.createSheet();
//第一行数据
        HSSFRow hssfRow=hssfSheet.createRow(0);
//第一个单元格
        HSSFCell hssfCell=hssfRow.createCell(0);
        hssfCell.setCellValue("财务报表");

//第二行数据
        HSSFRow hssfRow1=hssfSheet.createRow(1);
        HSSFCell hssfCell1=hssfRow1.createCell(0);
        hssfCell1.setCellValue("时间");

        HSSFCell hssfCell2=hssfRow1.createCell(1);
        hssfCell2.setCellValue("支出");

        HSSFCell hssfCell3=hssfRow1.createCell(2);
        hssfCell3.setCellValue("收入");

        HSSFCell hssfCell4=hssfRow1.createCell(3);
        hssfCell4.setCellValue("利润");

//循环加入数据
        for(int i=2;i<logFinances.size()+2;i++){
            LogFinance logFinance=logFinances.get(i-2);

            HSSFRow row = hssfSheet.createRow(i);
            HSSFCell cell0 = row.createCell(0);
            cell0.setCellValue(logFinance.getLogftime());

            HSSFCell cell1 = row.createCell(1);
            cell1.setCellValue(logFinance.getLogfexpenditure());

            HSSFCell cell2 = row.createCell(2);
            cell2.setCellValue(logFinance.getLogfincome());

            HSSFCell cell3 = row.createCell(3);
            cell3.setCellValue(logFinance.getLogfprofit());

//日期转换
//            HSSFCell cell6 = row.createCell(6);
//            if(emp.getBirth()==null){
//                cell6.setCellValue("");
//            }else{
//                SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//                String birth = sf.format(emp.getBirth());
//                cell6.setCellValue(birth);
//            }
        }


//合并单元格
        hssfSheet.addMergedRegion(new CellRangeAddress(0,0,0,3));
        //标题样式
        HSSFCellStyle styletitle = hssfWorkbook.createCellStyle();
        styletitle.setAlignment(HorizontalAlignment.CENTER);
        styletitle.setVerticalAlignment(VerticalAlignment.CENTER);
        HSSFFont fonttitle = hssfWorkbook.createFont();
        fonttitle.setFontHeightInPoints((short)20);
        fonttitle.setBold(true);
        styletitle.setFont(fonttitle);
        hssfCell.setCellStyle(styletitle);

        //行高
        hssfRow.setHeightInPoints((float) 50);
        hssfRow1.setHeightInPoints((float) 20);
        //表头
        HSSFCellStyle style2 = hssfWorkbook.createCellStyle();
        style2.setAlignment(HorizontalAlignment.CENTER);
        style2.setVerticalAlignment(VerticalAlignment.CENTER);
        HSSFFont font2 = hssfWorkbook.createFont();
        font2.setBold(true);
        style2.setFont(font2);
        hssfCell1.setCellStyle(style2);
        hssfCell2.setCellStyle(style2);
        hssfCell3.setCellStyle(style2);
        hssfCell4.setCellStyle(style2);

        //调整部分列宽
        hssfSheet.setColumnWidth(0,(int)35.7*120);




//把数据装入Excel
        //创建Byte文件输出流
        ByteArrayOutputStream byteArrayOutputStream=null;
        //创建byte数组
        byte[] bytes=null;
        byteArrayOutputStream=new ByteArrayOutputStream();
        try {
            //把数据通过Byte流变成byte类型
            hssfWorkbook.write(byteArrayOutputStream);
            //把数据装入Byte数组
            bytes=byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                byteArrayOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


//输出Execl文件
        OutputStream outputStream=null;
        try {
            //通过HttpServletResponse获取输出流
            outputStream=httpServletResponse.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        httpServletResponse.reset();
        httpServletResponse.setHeader("Content-Disposition",
                "attachment; filename=Vlist.xls");//// 要保存的文件名
        httpServletResponse.setContentType("application/octet-stream; charset=utf-8");//设置的输出的编码方式
        try {
            //把byte数据数组通过输出流
            outputStream.write(bytes);
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                //关闭输出流
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
