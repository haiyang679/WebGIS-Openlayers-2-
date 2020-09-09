package com.openlayer.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnOracle {

    static String driverClass = "oracle.jdbc.driver.OracleDriver"; //oracle的驱动
    static String url = "jdbc:oracle:thin:@localhost:1521:ORCL"; //连接oracle路径方式 “”ORCL“”是要建立连接的数据库名 1521端口
    static String user = "scuser";//user是数据库的用户名
    static String password = "scuser";//用户登录密码

    //static方法直接点就可以引用了
    public static Connection getconn() {
        Connection conn = null;
        try {
            //首先建立驱动
            Class.forName(driverClass);
            //驱动成功后进行连接
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("连接成功");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn; //返回一个连接
    }

}
