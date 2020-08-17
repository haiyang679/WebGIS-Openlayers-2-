package com.openlayers.action.entity;

import org.springframework.stereotype.Repository;

import java.util.Date;

//雨量信息表
//一个雨量信息属于一个监测站点，一个监测站点包含多个雨量信息
@Repository
public class St_soil_r {

    private String COL001;  //站码
    private Date COL002;    //时间
    private Float COL007;   //雨量
    private St_sitinfo_b st_sitinfo_b;   //监测站点

    public St_soil_r() {
    }

    public St_soil_r(String COL001, Date COL002, Float COL007, St_sitinfo_b st_sitinfo_b) {
        this.COL001 = COL001;
        this.COL002 = COL002;
        this.COL007 = COL007;
        this.st_sitinfo_b = st_sitinfo_b;
    }

    public String getCOL001() {
        return COL001;
    }

    public void setCOL001(String COL001) {
        this.COL001 = COL001;
    }

    public Date getCOL002() {
        return COL002;
    }

    public void setCOL002(Date COL002) {
        this.COL002 = COL002;
    }

    public Float getCOL007() {
        return COL007;
    }

    public void setCOL007(Float COL007) {
        this.COL007 = COL007;
    }

    public St_sitinfo_b getSt_sitinfo_b() {
        return st_sitinfo_b;
    }

    public void setSt_sitinfo_b(St_sitinfo_b st_sitinfo_b) {
        this.st_sitinfo_b = st_sitinfo_b;
    }

    @Override
    public String toString() {
        return "St_soil_r{" +
                "COL001='" + COL001 + '\'' +
                ", COL002=" + COL002 +
                ", COL007=" + COL007 +
                ", st_sitinfo_b=" + st_sitinfo_b +
                '}';
    }
}
