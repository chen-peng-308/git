package com.logistics.userdame.bean;

//车辆
public class LogVehicle {
    private Integer logvid;//id
    private String logvname;//车辆名称
    private String logvplatenumber;//车牌号
    private String logvfilt;//车辆照片
    private String logvload;//车辆载重
    private String logvinspection;//车辆年检
    private String logvlong;//车辆长
    private String logvwide;//车辆宽
    private String logvtall;//车辆高
    private String logvtype;//车辆类型

    public LogVehicle() {
    }

    public LogVehicle(Integer logvid, String logvname, String logvplatenumber, String logvfilt, String logvload, String logvinspection, String logvlong, String logvwide, String logvtall, String logvtype) {
        this.logvid = logvid;
        this.logvname = logvname;
        this.logvplatenumber = logvplatenumber;
        this.logvfilt = logvfilt;
        this.logvload = logvload;
        this.logvinspection = logvinspection;
        this.logvlong = logvlong;
        this.logvwide = logvwide;
        this.logvtall = logvtall;
        this.logvtype = logvtype;
    }

    public int getLogvid() {
        return logvid;
    }

    public void setLogvid(Integer logvid) {
        this.logvid = logvid;
    }

    public String getLogvname() {
        return logvname;
    }

    public void setLogvname(String logvname) {
        this.logvname = logvname;
    }

    public String getLogvplatenumber() {
        return logvplatenumber;
    }

    public void setLogvplatenumber(String logvplatenumber) {
        this.logvplatenumber = logvplatenumber;
    }

    public String getLogvfilt() {
        return logvfilt;
    }

    public void setLogvfilt(String logvfilt) {
        this.logvfilt = logvfilt;
    }

    public String getLogvload() {
        return logvload;
    }

    public void setLogvload(String logvload) {
        this.logvload = logvload;
    }

    public String getLogvinspection() {
        return logvinspection;
    }

    public void setLogvinspection(String logvinspection) {
        this.logvinspection = logvinspection;
    }

    public String getLogvlong() {
        return logvlong;
    }

    public void setLogvlong(String logvlong) {
        this.logvlong = logvlong;
    }

    public String getLogvwide() {
        return logvwide;
    }

    public void setLogvwide(String logvwide) {
        this.logvwide = logvwide;
    }

    public String getLogvtall() {
        return logvtall;
    }

    public void setLogvtall(String logvtall) {
        this.logvtall = logvtall;
    }

    public String getLogvtype() {
        return logvtype;
    }

    public void setLogvtype(String logvtype) {
        this.logvtype = logvtype;
    }

    @Override
    public String toString() {
        return "LogVehicle{" +
                "logvid=" + logvid +
                ", logvname='" + logvname + '\'' +
                ", logvplatenumber='" + logvplatenumber + '\'' +
                ", logvfilt='" + logvfilt + '\'' +
                ", logvload='" + logvload + '\'' +
                ", logvinspection='" + logvinspection + '\'' +
                ", logvlong='" + logvlong + '\'' +
                ", logvwide='" + logvwide + '\'' +
                ", logvtall='" + logvtall + '\'' +
                ", logvtype='" + logvtype + '\'' +
                '}';
    }
}
