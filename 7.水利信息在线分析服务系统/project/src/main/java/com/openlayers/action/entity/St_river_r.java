package com.openlayers.action.entity;

import org.springframework.stereotype.Repository;

import java.util.Date;

//河流信息表
//一条河流对应一个监测站点，一个监测站点对应多条河流，将监测站点放入河流中
@Repository
public class St_river_r {

    private String STCD;   //站码
    private String TM;    //时间
    private String RZ;   //水位
    private String OTQ;   //保证/正常
    private St_sitinfo_b st_sitinfo_b;   //监测站点

    public St_river_r() {
    }

    public St_river_r(String STCD, String TM, String RZ, String OTQ, St_sitinfo_b st_sitinfo_b) {
        this.STCD = STCD;
        this.TM = TM;
        this.RZ = RZ;
        this.OTQ = OTQ;
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

    public String getOTQ() {
        return OTQ;
    }

    public void setOTQ(String OTQ) {
        this.OTQ = OTQ;
    }

    public St_sitinfo_b getSt_sitinfo_b() {
        return st_sitinfo_b;
    }

    public void setSt_sitinfo_b(St_sitinfo_b st_sitinfo_b) {
        this.st_sitinfo_b = st_sitinfo_b;
    }

    @Override
    public String toString() {
        return "St_river_r{" +
                "STCD='" + STCD + '\'' +
                ", TM='" + TM + '\'' +
                ", RZ='" + RZ + '\'' +
                ", OTQ='" + OTQ + '\'' +
                ", st_sitinfo_b=" + st_sitinfo_b +
                '}';
    }
}
