package com.logistics.userdame.controller;

import com.logistics.userdame.bean.LogUser;
import com.logistics.userdame.service.UserService;
import com.logistics.userdame.uilt.BsUilt;
import com.logistics.userdame.uilt.Contants;
import com.logistics.userdame.uilt.Pager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//用户模块


@Controller
public class UController {
    @Resource
    private UserService userService;

//    @RequestMapping("index")//测试模板
//    public String CS() {
//        return "index";
//    }

    //界面进入
    @RequestMapping("/index")
    public String Uindex(){
        return "index1";
    }

    //登入方法
    @ResponseBody
    @RequestMapping("/Enter")
    public Boolean Enter(HttpSession session, LogUser logUser){
        LogUser logUser1=userService.EUser(logUser);
        if (logUser1!=null){
            session.setAttribute("logUser",logUser1);
            return true;
        }
        return false;
    }

//   注销方法
    @RequestMapping("Cancel")
    public String Cancel(HttpSession httpSession){
        httpSession.removeAttribute("logUser");
        return "redirect:index";
    }


    @RequestMapping("/Ulist")//获取用户列表
    public String UList(Model model, Pager pager) {
        pager.page(userService.PageSize1());//总数据
        pager.data = userService.Page1(pager);//分页数据
//        List<LogUser> logUsers= userService.UserList();
        model.addAttribute("list", pager);
        return "UserList";
    }

    @RequestMapping("/Uadd")//添加用户
    public String UAdd(Model model) {
//        List<String> distinct = userService.UserDistinct();//获取全部职业
//        model.addAttribute("Distinct", distinct);
        return "UserAdd";
    }

    @RequestMapping("/Uadd1")//添加用户
    public String UAdd1(LogUser logUser, MultipartFile logufilt1) {
        logUser.setLogufilt(BsUilt.setFlit(logufilt1, Contants.url));
        userService.UserAdd(logUser);
        return "redirect:Ulist";
    }

    @RequestMapping("/Udelete")//删除用户
    public String Udelete(Integer id) {
        userService.UserDelete(id);
        return "redirect:Ulist";
    }

    @RequestMapping("/UUpdate")
    public String UUpdate(Integer id, Model model) {
//        List<String> distinct = userService.UserDistinct();//获取全部职业
        LogUser logUser = userService.User(id);
        model.addAttribute("log", logUser);
//        model.addAttribute("Distinct", distinct);
        return "UserUpdate";
    }

    @RequestMapping("/UUpdate1")
    public String UUpdate1(LogUser logUser, MultipartFile logufilt1) {
        if (!logufilt1.isEmpty()) {
            logUser.setLogufilt(BsUilt.setFlit(logufilt1, Contants.url));
        }
        userService.UserUpdate(logUser);
        return "redirect:Ulist";
    }

    @ResponseBody
    @RequestMapping("JsonAdd")
    public boolean JsonAdd(HashMap data){
        System.out.println(data);
        System.out.println("进去");
        System.out.println(data.get("loguname"));
//        MultipartFile file= (MultipartFile) data.get("logufilt1");
        return true;
    }
}