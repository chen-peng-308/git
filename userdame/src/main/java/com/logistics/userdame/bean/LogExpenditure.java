package com.logistics.userdame.bean;

public class LogExpenditure {//支出管理
    private Integer logeid;//支出账单id
    private Integer logemoney;//支出数量
    private String logetime;//支出时间
    private String logetype;//支出类型
    private String logecontent;//详细原因

    public LogExpenditure(Integer logeid, Integer logemoney, String logetime, String logetype, String logecontent) {
        this.logeid = logeid;
        this.logemoney = logemoney;
        this.logetime = logetime;
        this.logetype = logetype;
        this.logecontent = logecontent;
    }

    public Integer getLogeid() {
        return logeid;
    }

    public void setLogeid(Integer logeid) {
        this.logeid = logeid;
    }

    public Integer getLogemoney() {
        return logemoney;
    }

    public void setLogemoney(Integer logemoney) {
        this.logemoney = logemoney;
    }

    public String getLogetime() {
        return logetime;
    }

    public void setLogetime(String logetime) {
        this.logetime = logetime;
    }

    public String getLogetype() {
        return logetype;
    }

    public void setLogetype(String logetype) {
        this.logetype = logetype;
    }

    public String getLogecontent() {
        return logecontent;
    }

    public void setLogecontent(String logecontent) {
        this.logecontent = logecontent;
    }

    @Override
    public String toString() {
        return "LogExpenditure{" +
                "logeid=" + logeid +
                ", logemoney=" + logemoney +
                ", logetime='" + logetime + '\'' +
                ", logetype='" + logetype + '\'' +
                ", logecontent='" + logecontent + '\'' +
                '}';
    }
}
