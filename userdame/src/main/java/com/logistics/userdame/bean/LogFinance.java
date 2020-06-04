package com.logistics.userdame.bean;

public class LogFinance {//财务报表
    private int logfid;//财务报表id
    private String logftime;//财务报表时间
    private int logfexpenditure;//财务支出
    private int logfincome;//财务收入
    private int logfprofit;//利润


    public LogFinance() {
    }

    public LogFinance(int logfid, String logftime, int logfexpenditure, int logfincome, int logfprofit) {
        this.logfid = logfid;
        this.logftime = logftime;
        this.logfexpenditure = logfexpenditure;
        this.logfincome = logfincome;
        this.logfprofit = logfprofit;
    }

    public int getLogfid() {
        return logfid;
    }

    public void setLogfid(int logfid) {
        this.logfid = logfid;
    }

    public String getLogftime() {
        return logftime;
    }

    public void setLogftime(String logftime) {
        this.logftime = logftime;
    }

    public int getLogfexpenditure() {
        return logfexpenditure;
    }

    public void setLogfexpenditure(int logfexpenditure) {
        this.logfexpenditure = logfexpenditure;
    }

    public int getLogfincome() {
        return logfincome;
    }

    public void setLogfincome(int logfincome) {
        this.logfincome = logfincome;
    }

    public int getLogfprofit() {
        return logfprofit;
    }

    public void setLogfprofit(int logfprofit) {
        this.logfprofit = logfprofit;
    }

    @Override
    public String toString() {
        return "LogFinance{" +
                "logfid=" + logfid +
                ", logftime='" + logftime + '\'' +
                ", logfexpenditure=" + logfexpenditure +
                ", logfincome=" + logfincome +
                ", logfprofit=" + logfprofit +
                '}';
    }
}
