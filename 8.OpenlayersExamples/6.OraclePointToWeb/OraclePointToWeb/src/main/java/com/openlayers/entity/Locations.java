package com.openlayers.entity;


import org.springframework.stereotype.Component;

//位置的实体类    oracle中未使用空间存储，直接存储lat,lon字符串
@Component
public class Locations {

    private String lat;
    private String lon;
    private String city;
    private int number;

    public Locations() {
    }

    public Locations(String lat, String lon, String city, int number) {
        this.lat = lat;
        this.lon = lon;
        this.city = city;
        this.number = number;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "locations{" +
                "lat='" + lat + '\'' +
                ", lon='" + lon + '\'' +
                ", city='" + city + '\'' +
                ", number=" + number +
                '}';
    }
}
