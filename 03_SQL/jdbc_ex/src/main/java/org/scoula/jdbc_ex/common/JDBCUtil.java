package org.scoula.jdbc_ex.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class JDBCUtil {
    static Connection conn=null;
    static{
        try{
            Properties p=new Properties();
            p.load(JDBCUtil.class.getResourceAsStream("/application.properties"));
            String driver=p.getProperty("driver");
            String url=p.getProperty("url");
            String id=p.getProperty("id");
            String password=p.getProperty("password");

            Class.forName(driver);
            conn= DriverManager.getConnection(url,id,password);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        return conn;
    }
    public static void close(){
        try {
            if(conn!=null){
                conn.close();
                conn=null;
            }
        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
