package com.openlayer.dao;


import com.openlayer.entity.ColaMarket;
import com.openlayer.util.ConnOracle;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Component
public class ColaDao {


    public List<ColaMarket> findAll(){
        Connection conn=null;
        Statement st=null;
        ResultSet rs=null;
        //用来存放需要返回的ColaMarkets数组
        List<ColaMarket> colaMarkets = new ArrayList<>();

        try {
            //1、获取连接对象
            conn= ConnOracle.getconn();
            //2、创建statement类对象，用来执行SQL语句！！
            st=conn.createStatement();
            //3、创建sql查询语句
            String sql="select MK_ID,NAME,sdo_geometry.get_wkt(shape) shape from COLA_MARKETS_CS";
            //4、执行sql语句并且换回一个查询的结果集
            rs=st.executeQuery(sql);
            while(rs.next()) {  //循环遍历结果集

                int mk_id=rs.getInt("MK_ID");
                String name = rs.getString("NAME");
                String shape = rs.getString("SHAPE");
                shape = shape.substring(10,53);
                String[] split1 = shape.split(",");
                List<List<Double>> lonlatList = new ArrayList<List<Double>>();
                for (String split2:split1
                     ) {
                    //System.out.println(split2);
                    //System.out.println("---------------");
                    String[] splitEnd = split2.split(" ");

                    //用来存放坐标的数组
                    List<Double> lonlat = new ArrayList<Double>();
                    for (String s: splitEnd
                         ) {

                        if (!s.equals("")) {
                            lonlat.add(Double.parseDouble(s));
                            //System.out.println(lonlat.toString());
                        }
                    }
                    lonlatList.add(lonlat);
                }
                //System.out.println(lonlatList.toString());

                //System.out.println("----------------");
                ColaMarket colaMarket = new ColaMarket();
                colaMarket.setMk_id(mk_id);
                colaMarket.setName(name);
                colaMarket.setLonlatList(lonlatList);
                colaMarkets.add(colaMarket);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return colaMarkets;
    }

    public static void main(String[] args) {
        ColaDao colaDao = new ColaDao();
        List<ColaMarket> all = colaDao.findAll();
        for (ColaMarket c: all
             ) {
            System.out.println(c);
        }
    }


}
