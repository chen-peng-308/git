package com.logistics.userdame.service;

import com.logistics.userdame.bean.LogExpenditure;
import com.logistics.userdame.bean.LogFinance;
import com.logistics.userdame.bean.LogVehicle;
import com.logistics.userdame.uilt.Pager;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FinancialService {
    int EPageSize();//查询数据数量
    List<LogExpenditure> EPage(Pager pager);//分页查询
    void ExpenditureAdd(LogExpenditure logExpenditure);//添加支出账单
    void ExpenditureDelete(Integer eid);//删除账单
    LogExpenditure Expenditure(Integer eid);//查找账单
    void ExpenditureUpdate(LogExpenditure logExpenditure);//修改账单
    int DateFinance(String date);//查询每月的金额
    void LogFinanceAdd(LogFinance logFinance);//添加报表数据
    List<LogFinance> Finance();//查询报表数据
}
