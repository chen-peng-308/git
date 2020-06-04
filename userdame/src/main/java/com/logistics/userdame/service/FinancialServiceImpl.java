package com.logistics.userdame.service;

import com.logistics.userdame.bean.LogExpenditure;
import com.logistics.userdame.bean.LogFinance;
import com.logistics.userdame.dao.FinancialDao;
import com.logistics.userdame.uilt.Pager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Service
@Transactional
public class FinancialServiceImpl implements FinancialService {
    @Resource
    private FinancialDao financialDao;

    @Override
    public int EPageSize() {
        return financialDao.getEPageSize();
    }

    @Override
    public List<LogExpenditure> EPage(Pager pager) {
        int i=(pager.getCurrPage()-1)*pager.pageSize;
        return financialDao.getEPage(i,pager.pageSize);
    }

    @Override
    public void ExpenditureAdd(LogExpenditure logExpenditure) {
        financialDao.setExpenditureAdd(logExpenditure);
    }

    @Override
    public void ExpenditureDelete(Integer eid) {
        financialDao.setExpenditureDelete(eid);
    }

    @Override
    public LogExpenditure Expenditure(Integer eid) {
        return financialDao.getExpenditure(eid);
    }

    @Override
    public void ExpenditureUpdate(LogExpenditure logExpenditure) {
        financialDao.setExpenditureUpdate(logExpenditure);
    }

    @Override
    public int DateFinance(String date) {
        String date1="%"+date+"%";
        int i=financialDao.setDateFinance(date1);
        return i;
    }

    @Override
    public void LogFinanceAdd(LogFinance logFinance) {
        financialDao.setLogFinanceAdd(logFinance);
    }

    @Override
    public List<LogFinance> Finance() {
        return financialDao.getFinance();
    }
}
