package com.openlayers.action.entity;

import org.springframework.stereotype.Repository;

//台风基本信息表
@Repository
public class Wind_basicInfo {

    private int WINDID;   //台风编号
    private String WINDNAME;    //台风中文名称
    private String WINDEND;   //台风英文名称

    public Wind_basicInfo() {
    }

    public Wind_basicInfo(int WINDID, String WINDNAME, String WINDEND) {
        this.WINDID = WINDID;
        this.WINDNAME = WINDNAME;
        this.WINDEND = WINDEND;
    }

    public int getWINDID() {
        return WINDID;
    }

    public void setWINDID(int WINDID) {
        this.WINDID = WINDID;
    }

    public String getWINDNAME() {
        return WINDNAME;
    }

    public void setWINDNAME(String WINDNAME) {
        this.WINDNAME = WINDNAME;
    }

    public String getWINDEND() {
        return WINDEND;
    }

    public void setWINDEND(String WINDEND) {
        this.WINDEND = WINDEND;
    }

    @Override
    public String toString() {
        return "Wind_basicInfo{" +
                "WINDID=" + WINDID +
                ", WINDNAME='" + WINDNAME + '\'' +
                ", WINDEND='" + WINDEND + '\'' +
                '}';
    }
}
