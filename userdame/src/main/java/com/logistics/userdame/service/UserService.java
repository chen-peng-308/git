package com.logistics.userdame.service;

import com.logistics.userdame.bean.LogUser;
import com.logistics.userdame.uilt.Pager;

import java.util.List;

public interface UserService {
    List<LogUser> UserList();//获取用户列表
    void UserAdd(LogUser logUser);//添加用户
    void UserDelete(Integer id);//删除用户
    void UserUpdate(LogUser logUser);//修改用户
    LogUser User(Integer id);//查找用户
    List<String> UserDistinct();//查询工作岗位
    int PageSize1();//查询数据总数
    List<LogUser> Page1(Pager pager);//查询分页
    LogUser EUser(LogUser logUser);//判断登入
    List<LogUser> WUserList();//获取全部司机
}
