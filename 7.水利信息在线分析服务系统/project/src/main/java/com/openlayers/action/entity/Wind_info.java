package com.openlayers.action.entity;

import org.springframework.stereotype.Repository;

import java.util.Date;

//台风详细信息表
@Repository
public class Wind_info {

    private int WINDID;   //台风编号
    private String TM;     //时间
    private float JINDU;    //经度
    private float WEIDU;     //纬度
    private String WINDSTRONG;   //风力
    private String WINDSPEED;    //风速
    private String QIYA;    //气压
    private String MOVESPEED;    //移动风速
    private String MOVEDIRECT;    //风向
    private int SEVRADIUS;     //半径
    private int TENRADIUS;    //半径


    public Wind_info() {
    }

    public Wind_info(int WINDID, String TM, float JINDU, float WEIDU, String WINDSTRONG, String WINDSPEED, String QIYA, String MOVESPEED, String MOVEDIRECT, int SEVRADIUS, int TENRADIUS) {
        this.WINDID = WINDID;
        this.TM = TM;
        this.JINDU = JINDU;
        this.WEIDU = WEIDU;
        this.WINDSTRONG = WINDSTRONG;
        this.WINDSPEED = WINDSPEED;
        this.QIYA = QIYA;
        this.MOVESPEED = MOVESPEED;
        this.MOVEDIRECT = MOVEDIRECT;
        this.SEVRADIUS = SEVRADIUS;
        this.TENRADIUS = TENRADIUS;
    }

    public int getWINDID() {
        return WINDID;
    }

    public void setWINDID(int WINDID) {
        this.WINDID = WINDID;
    }

    public String getTM() {
        return TM;
    }

    public void setTM(String TM) {
        this.TM = TM;
    }

    public float getJINDU() {
        return JINDU;
    }

    public void setJINDU(float JINDU) {
        this.JINDU = JINDU;
    }

    public float getWEIDU() {
        return WEIDU;
    }

    public void setWEIDU(float WEIDU) {
        this.WEIDU = WEIDU;
    }

    public String getWINDSTRONG() {
        return WINDSTRONG;
    }

    public void setWINDSTRONG(String WINDSTRONG) {
        this.WINDSTRONG = WINDSTRONG;
    }

    public String getWINDSPEED() {
        return WINDSPEED;
    }

    public void setWINDSPEED(String WINDSPEED) {
        this.WINDSPEED = WINDSPEED;
    }

    public String getQIYA() {
        return QIYA;
    }

    public void setQIYA(String QIYA) {
        this.QIYA = QIYA;
    }

    public String getMOVESPEED() {
        return MOVESPEED;
    }

    public void setMOVESPEED(String MOVESPEED) {
        this.MOVESPEED = MOVESPEED;
    }

    public String getMOVEDIRECT() {
        return MOVEDIRECT;
    }

    public void setMOVEDIRECT(String MOVEDIRECT) {
        this.MOVEDIRECT = MOVEDIRECT;
    }

    public int getSEVRADIUS() {
        return SEVRADIUS;
    }

    public void setSEVRADIUS(int SEVRADIUS) {
        this.SEVRADIUS = SEVRADIUS;
    }

    public int getTENRADIUS() {
        return TENRADIUS;
    }

    public void setTENRADIUS(int TENRADIUS) {
        this.TENRADIUS = TENRADIUS;
    }

    @Override
    public String toString() {
        return "Wind_info{" +
                "WINDID=" + WINDID +
                ", TM='" + TM + '\'' +
                ", JINDU=" + JINDU +
                ", WEIDU=" + WEIDU +
                ", WINDSTRONG='" + WINDSTRONG + '\'' +
                ", WINDSPEED='" + WINDSPEED + '\'' +
                ", QIYA='" + QIYA + '\'' +
                ", MOVESPEED='" + MOVESPEED + '\'' +
                ", MOVEDIRECT='" + MOVEDIRECT + '\'' +
                ", SEVRADIUS=" + SEVRADIUS +
                ", TENRADIUS=" + TENRADIUS +
                '}';
    }
}
