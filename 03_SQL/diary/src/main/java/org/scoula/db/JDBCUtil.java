package org.scoula.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class JDBCUtil {
    static Connection conn;
    static{
        try{
            Properties prop = new Properties();
            prop.load(JDBCUtil.class.getResourceAsStream("/application.properties"));
            String driver = prop.getProperty("driver");
            String url = prop.getProperty("DB_URL");
            String user = prop.getProperty("DB_USER");
            String password = prop.getProperty("PASSWORD");
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, password);
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    public static Connection getConnection(){
        return conn;
    }
    public static void closeConnection(){
        try{
            if(conn != null){
                conn.close();
                conn = null;
            }

        } catch(Exception e){
            e.printStackTrace();
        }
    }

}
