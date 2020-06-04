package com.logistics.userdame.bean;


//员工
public class LogUser {
    private Integer loguid;
    private String loguname;
    private String loguaccount;
    private String logupassword;
    private String loguposition;
    private String loguidentity;
    private String logufilt;

    public LogUser(Integer loguid, String loguname, String loguaccount, String logupassword, String loguposition, String loguidentity, String logufilt) {
        this.loguid = loguid;
        this.loguname = loguname;
        this.loguaccount = loguaccount;
        this.logupassword = logupassword;
        this.loguposition = loguposition;
        this.loguidentity = loguidentity;
        this.logufilt = logufilt;
    }

    public int getLoguid() {
        return loguid;
    }

    public void setLoguid(Integer loguid) {
        this.loguid = loguid;
    }

    public String getLoguname() {
        return loguname;
    }

    public void setLoguname(String loguname) {
        this.loguname = loguname;
    }

    public String getLoguaccount() {
        return loguaccount;
    }

    public void setLoguaccount(String loguaccount) {
        this.loguaccount = loguaccount;
    }

    public String getLogupassword() {
        return logupassword;
    }

    public void setLogupassword(String logupassword) {
        this.logupassword = logupassword;
    }

    public String getLoguposition() {
        return loguposition;
    }

    public void setLoguposition(String loguposition) {
        this.loguposition = loguposition;
    }

    public String getLoguidentity() {
        return loguidentity;
    }

    public void setLoguidentity(String loguidentity) {
        this.loguidentity = loguidentity;
    }

    public String getLogufilt() {
        return logufilt;
    }

    public void setLogufilt(String logufilt) {
        this.logufilt = logufilt;
    }

    @Override
    public String toString() {
        return "LogUser{" +
                "loguid=" + loguid +
                ", loguname='" + loguname + '\'' +
                ", loguaccount='" + loguaccount + '\'' +
                ", logupassword='" + logupassword + '\'' +
                ", loguposition='" + loguposition + '\'' +
                ", loguidentity='" + loguidentity + '\'' +
                ", logufilt='" + logufilt + '\'' +
                '}';
    }
}
