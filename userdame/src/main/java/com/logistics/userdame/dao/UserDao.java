package com.logistics.userdame.dao;

import com.logistics.userdame.bean.LogUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resources;
import java.util.List;

@Repository
public interface UserDao {
    List<LogUser> getUserList();//获取用户列表
    void setUserAdd(LogUser logUser);//添加用户
    void setUserDelete(Integer id);//删除用户
    LogUser getUser(Integer id);//查找用户
    void setUserUpdate(LogUser logUser);//修改用户
    List<String> getUserDistinct();//查询工作岗位
    int getPageSize();//查询数据数量
    List<LogUser> getPage(@Param("page") int page, @Param("pageSize") int pageSize);//分页查询
    LogUser getEUser(@Param("loguaccount") String loguaccount,@Param("logupassword") String logupassword);//判断登入
    List<LogUser> getWList(@Param("position")String position);//获取全部司机
}
