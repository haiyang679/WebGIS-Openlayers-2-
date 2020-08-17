package com.openlayers.action.entity;

import org.springframework.stereotype.Repository;

//监测站点信息表
@Repository
public class St_sitinfo_b {


    private String ZHANMA;  //站码
    private String zhanming; //站名
    private String DONGJING;  //东经
    private String BEIWEI;  //北纬
    private String HEMING;   //河名
    private String ZHANLEI;  //站类
    private String DISHI;  //地市
    private String FENJU;   //分局
    private String DIZHI;   //地址

    public String getZHANMA() {
        return ZHANMA;
    }

    public void setZHANMA(String ZHANMA) {
        this.ZHANMA = ZHANMA;
    }

    public String getZhanming() {
        return zhanming;
    }

    public void setZhanming(String zhanming) {
        this.zhanming = zhanming;
    }

    public String getDONGJING() {
        return DONGJING;
    }

    public void setDONGJING(String DONGJING) {
        this.DONGJING = DONGJING;
    }

    public String getBEIWEI() {
        return BEIWEI;
    }

    public void setBEIWEI(String BEIWEI) {
        this.BEIWEI = BEIWEI;
    }

    public String getHEMING() {
        return HEMING;
    }

    public void setHEMING(String HEMING) {
        this.HEMING = HEMING;
    }

    public String getZHANLEI() {
        return ZHANLEI;
    }

    public void setZHANLEI(String ZHANLEI) {
        this.ZHANLEI = ZHANLEI;
    }

    public String getDISHI() {
        return DISHI;
    }

    public void setDISHI(String DISHI) {
        this.DISHI = DISHI;
    }

    public String getFENJU() {
        return FENJU;
    }

    public void setFENJU(String FENJU) {
        this.FENJU = FENJU;
    }

    public String getDIZHI() {
        return DIZHI;
    }

    public void setDIZHI(String DIZHI) {
        this.DIZHI = DIZHI;
    }

    public St_sitinfo_b() {
    }

    public St_sitinfo_b(String ZHANMA, String zhanming, String DONGJING, String BEIWEI, String HEMING, String ZHANLEI, String DISHI, String FENJU, String DIZHI) {
        this.ZHANMA = ZHANMA;
        this.zhanming = zhanming;
        this.DONGJING = DONGJING;
        this.BEIWEI = BEIWEI;
        this.HEMING = HEMING;
        this.ZHANLEI = ZHANLEI;
        this.DISHI = DISHI;
        this.FENJU = FENJU;
        this.DIZHI = DIZHI;
    }

    @Override
    public String toString() {
        return "St_sitinfo_b{" +
                "ZHANMA='" + ZHANMA + '\'' +
                ", zhanming='" + zhanming + '\'' +
                ", DONGJING='" + DONGJING + '\'' +
                ", BEIWEI='" + BEIWEI + '\'' +
                ", HEMING='" + HEMING + '\'' +
                ", ZHANLEI='" + ZHANLEI + '\'' +
                ", DISHI='" + DISHI + '\'' +
                ", FENJU='" + FENJU + '\'' +
                ", DIZHI='" + DIZHI + '\'' +
                '}';
    }
}
