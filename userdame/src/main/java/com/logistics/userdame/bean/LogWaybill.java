package com.logistics.userdame.bean;

public class LogWaybill {
    private Integer logwid;//运单id
    private String logwphone;//客户电话
    private String logwname;//客户姓名
    private String logwcargotype;//货物类型
    private String logwweight;//重量
    private String logwvolume;//体积
    private String logworigin;//起始地
    private String logwdestination;//目的地
    private Integer logwvehicle;//车辆ID
    private Float logwprice;//运费
    private String logwdriver;//司机
    private String logwordertime;//下单时间
    private String logwpaytime;//支付时间
    private String logwpayway;//支付方式
    private String logwloadingtime;//装货时间
    private String logwarrivetime;//达到时间
    private String logwunloadtime;//卸货时间
    private String logwreturntime;//返回时间
    private String logwtype;//状态




    public LogWaybill(Integer logwid, String logwphone, String logwname, String logwcargotype, String logwweight, String logwvolume, String logworigin, String logwdestination, Integer logwvehicle, Float logwprice, String logwdriver, String logwordertime, String logwpaytime, String logwpayway, String logwloadingtime, String logwarrivetime, String logwunloadtime, String logwreturntime, String logwtype) {
        this.logwid = logwid;
        this.logwphone = logwphone;
        this.logwname = logwname;
        this.logwcargotype = logwcargotype;
        this.logwweight = logwweight;
        this.logwvolume = logwvolume;
        this.logworigin = logworigin;
        this.logwdestination = logwdestination;
        this.logwvehicle = logwvehicle;
        this.logwprice = logwprice;
        this.logwdriver = logwdriver;
        this.logwordertime = logwordertime;
        this.logwpaytime = logwpaytime;
        this.logwpayway = logwpayway;
        this.logwloadingtime = logwloadingtime;
        this.logwarrivetime = logwarrivetime;
        this.logwunloadtime = logwunloadtime;
        this.logwreturntime = logwreturntime;
        this.logwtype = logwtype;
    }


    @Override
    public String toString() {
        return "LogWaybill{" +
                "logwid=" + logwid +
                ", logwphone='" + logwphone + '\'' +
                ", logwname='" + logwname + '\'' +
                ", logwcargotype='" + logwcargotype + '\'' +
                ", logwweight='" + logwweight + '\'' +
                ", logwvolume='" + logwvolume + '\'' +
                ", logworigin='" + logworigin + '\'' +
                ", logwdestination='" + logwdestination + '\'' +
                ", logwvehicle=" + logwvehicle +
                ", logwprice=" + logwprice +
                ", logwdriver='" + logwdriver + '\'' +
                ", logwordertime='" + logwordertime + '\'' +
                ", logwpaytime='" + logwpaytime + '\'' +
                ", logwpayway='" + logwpayway + '\'' +
                ", logwloadingtime='" + logwloadingtime + '\'' +
                ", logwarrivetime='" + logwarrivetime + '\'' +
                ", logwunloadtime='" + logwunloadtime + '\'' +
                ", logwreturntime='" + logwreturntime + '\'' +
                ", logwtype='" + logwtype + '\'' +
                '}';
    }


    public Integer getLogwid() {
        return logwid;
    }

    public void setLogwid(Integer logwid) {
        this.logwid = logwid;
    }

    public String getLogwphone() {
        return logwphone;
    }

    public void setLogwphone(String logwphone) {
        this.logwphone = logwphone;
    }

    public String getLogwname() {
        return logwname;
    }

    public void setLogwname(String logwname) {
        this.logwname = logwname;
    }

    public String getLogwcargotype() {
        return logwcargotype;
    }

    public void setLogwcargotype(String logwcargotype) {
        this.logwcargotype = logwcargotype;
    }

    public String getLogwweight() {
        return logwweight;
    }

    public void setLogwweight(String logwweight) {
        this.logwweight = logwweight;
    }

    public String getLogwvolume() {
        return logwvolume;
    }

    public void setLogwvolume(String logwvolume) {
        this.logwvolume = logwvolume;
    }

    public String getLogworigin() {
        return logworigin;
    }

    public void setLogworigin(String logworigin) {
        this.logworigin = logworigin;
    }

    public String getLogwdestination() {
        return logwdestination;
    }

    public void setLogwdestination(String logwdestination) {
        this.logwdestination = logwdestination;
    }

    public Integer getLogwvehicle() {
        return logwvehicle;
    }

    public void setLogwvehicle(Integer logwvehicle) {
        this.logwvehicle = logwvehicle;
    }

    public Float getLogwprice() {
        return logwprice;
    }

    public void setLogwprice(Float logwprice) {
        this.logwprice = logwprice;
    }

    public String getLogwdriver() {
        return logwdriver;
    }

    public void setLogwdriver(String logwdriver) {
        this.logwdriver = logwdriver;
    }

    public String getLogwordertime() {
        return logwordertime;
    }

    public void setLogwordertime(String logwordertime) {
        this.logwordertime = logwordertime;
    }

    public String getLogwpaytime() {
        return logwpaytime;
    }

    public void setLogwpaytime(String logwpaytime) {
        this.logwpaytime = logwpaytime;
    }

    public String getLogwpayway() {
        return logwpayway;
    }

    public void setLogwpayway(String logwpayway) {
        this.logwpayway = logwpayway;
    }

    public String getLogwloadingtime() {
        return logwloadingtime;
    }

    public void setLogwloadingtime(String logwloadingtime) {
        this.logwloadingtime = logwloadingtime;
    }

    public String getLogwarrivetime() {
        return logwarrivetime;
    }

    public void setLogwarrivetime(String logwarrivetime) {
        this.logwarrivetime = logwarrivetime;
    }

    public String getLogwunloadtime() {
        return logwunloadtime;
    }

    public void setLogwunloadtime(String logwunloadtime) {
        this.logwunloadtime = logwunloadtime;
    }

    public String getLogwreturntime() {
        return logwreturntime;
    }

    public void setLogwreturntime(String logwreturntime) {
        this.logwreturntime = logwreturntime;
    }

    public String getLogwtype() {
        return logwtype;
    }

    public void setLogwtype(String logwtype) {
        this.logwtype = logwtype;
    }
}
