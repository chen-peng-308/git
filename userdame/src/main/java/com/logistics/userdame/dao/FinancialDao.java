package com.logistics.userdame.dao;

import com.logistics.userdame.bean.LogExpenditure;
import com.logistics.userdame.bean.LogFinance;
import com.logistics.userdame.bean.LogVehicle;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public interface FinancialDao {
    int getEPageSize();//查询数据数量
    List<LogExpenditure> getEPage(@Param("page") int page, @Param("pageSize") int pageSize);//分页查询
    void setExpenditureAdd(LogExpenditure logExpenditure);//添加支出账单
    void setExpenditureDelete(Integer eid);//删除账单
    LogExpenditure getExpenditure(Integer eid);//查找账单
    void setExpenditureUpdate(LogExpenditure logExpenditure);//修改账单
    int setDateFinance(String date);//查询每月的金额
    void setLogFinanceAdd(LogFinance logFinance);//添加报表数据
    List<LogFinance> getFinance();//查询报表数据
}
