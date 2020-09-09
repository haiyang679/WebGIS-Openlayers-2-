package com.openlayers.dao;

import com.openlayers.entity.Locations;
import com.openlayers.utils.ConnOracle;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class LocationsDao {

    Connection conn=null;
    Statement st=null;
    ResultSet rs=null;


    List<Locations> locationsList = new ArrayList<Locations>();
    public List<Locations> findAllLocations(){
        try {
            //1、获取连接对象
            conn= ConnOracle.getconn();
            //2、创建statement类对象，用来执行SQL语句！！
            st=conn.createStatement();
            //3、创建sql查询语句
            String sql="select * from locations";
            //4、执行sql语句并且换回一个查询的结果集
            rs=st.executeQuery(sql);
            while (rs.next()){
                //依次获取所需属性
                String lat = rs.getString("lat");
                String lon = rs.getString("lon");
                String city = rs.getString("city");
                int number = rs.getInt("number");
                //将获得的属性封装到实体类中
                Locations locations = new Locations();
                locations.setLat(lat);
                locations.setLon(lon);
                locations.setCity(city);
                locations.setNumber(number);
                locationsList.add(locations);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(locationsList.toString());
        return locationsList;
    }

    public static void main(String[] args) {
        LocationsDao locationsDao = new LocationsDao();
        locationsDao.findAllLocations();
    }
}
