package com.logistics.userdame.service;

import com.logistics.userdame.bean.LogUser;
import com.logistics.userdame.dao.UserDao;
import com.logistics.userdame.uilt.Pager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sun.rmi.runtime.Log;

import javax.annotation.Resource;
import java.util.List;
@Service
@Transactional
public class UserServiceImpl implements UserService {
        @Resource
        private UserDao userDao;

        @Override
        public List<LogUser> UserList() {
            List<LogUser> logUsers=userDao.getUserList();
            return logUsers;
        }

        @Override
        public void UserAdd(LogUser logUser) {
            userDao.setUserAdd(logUser);
        }

        @Override
        public void UserDelete(Integer id) {
            userDao.setUserDelete(id);
        }

        @Override
        public void UserUpdate(LogUser logUser) {
            userDao.setUserUpdate(logUser);
        }

        @Override
        public LogUser User(Integer id) {
            return userDao.getUser(id);
        }

        @Override
        public List<String> UserDistinct() {
            return userDao.getUserDistinct();
        }

        @Override
        public int PageSize1() {
            return userDao.getPageSize();
        }

        @Override
        public List<LogUser> Page1(Pager pager) {
            int i=(pager.getCurrPage()-1)*pager.pageSize;
            return userDao.getPage(i,pager.pageSize);
        }

        @Override
        public LogUser EUser(LogUser logUser) {
            String loguaccount=logUser.getLoguaccount();
            String logupassword=logUser.getLogupassword();
            LogUser logUser1=userDao.getEUser(loguaccount,logupassword);
            return logUser1;
        }

    @Override
    public List<LogUser> WUserList() {
        return userDao.getWList("司机");
    }

}
