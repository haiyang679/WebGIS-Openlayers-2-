package com.openlayers.action.entity;


import org.springframework.stereotype.Repository;

import javax.print.DocFlavor;
import java.util.Date;

//水库信息表
@Repository
public class St_rsvr_r {

    private String STCD;  //站码
    private String TM;  //时间
    private String RZ;  //水位
    private String INQ;   //流量
    private String OTQ;   //保证/正常
    private String W;   //警戒

    //一个水库对应1个监测站点，一个监测站点有多个水库
    private St_sitinfo_b st_sitinfo_b;

    public St_rsvr_r() {
    }

    public St_rsvr_r(String STCD, String TM, String RZ, String INQ, String OTQ, String w, St_sitinfo_b st_sitinfo_b) {
        this.STCD = STCD;
        this.TM = TM;
        this.RZ = RZ;
        this.INQ = INQ;
        this.OTQ = OTQ;
        W = w;
        this.st_sitinfo_b = st_sitinfo_b;
    }

    public String getSTCD() {
        return STCD;
    }

    public void setSTCD(String STCD) {
        this.STCD = STCD;
    }

    public String getTM() {
        return TM;
    }

    public void setTM(String TM) {
        this.TM = TM;
    }

    public String getRZ() {
        return RZ;
    }

    public void setRZ(String RZ) {
        this.RZ = RZ;
    }

    public String getINQ() {
        return INQ;
    }

    public void setINQ(String INQ) {
        this.INQ = INQ;
    }

    public String getOTQ() {
        return OTQ;
    }

    public void setOTQ(String OTQ) {
        this.OTQ = OTQ;
    }

    public String getW() {
        return W;
    }

    public void setW(String w) {
        W = w;
    }

    public St_sitinfo_b getSt_sitinfo_b() {
        return st_sitinfo_b;
    }

    public void setSt_sitinfo_b(St_sitinfo_b st_sitinfo_b) {
        this.st_sitinfo_b = st_sitinfo_b;
    }

    @Override
    public String toString() {
        return "St_rsvr_r{" +
                "STCD='" + STCD + '\'' +
                ", TM='" + TM + '\'' +
                ", RZ='" + RZ + '\'' +
                ", INQ='" + INQ + '\'' +
                ", OTQ='" + OTQ + '\'' +
                ", W='" + W + '\'' +
                ", st_sitinfo_b=" + st_sitinfo_b +
                '}';
    }
}
