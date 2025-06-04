package org.scoula.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DBUtil {
    private static Connection conn ;
    static{
        try{
            Properties prop = new Properties();
            prop.load(DBUtil.class.getResourceAsStream("/application.properties"));
            String driver = prop.getProperty("driver");
            String url = prop.getProperty("url");
            String user = prop.getProperty("user");
            String password = prop.getProperty("password");

            Class.forName(driver);
            conn = DriverManager.getConnection(url,user,password);



        }catch (Exception e){
            e.printStackTrace();
        }

    }
    public static Connection getConnection(){
        return conn;
    }

    public static void close(AutoCloseable... closeables){
        for(AutoCloseable c:closeables){
            if(c!=null){
                try{
                    c.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
