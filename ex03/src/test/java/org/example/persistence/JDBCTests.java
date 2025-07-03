package org.example.persistence;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCTests {
    private static final Logger log = LoggerFactory.getLogger(JDBCTests.class);

    @BeforeAll
    public static void setUp(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("JDBC 드라이버 연결이 된다.")
    public void testConnection(){
        String url = "jdbc:mysql://localhost:3306/scoula_db";
        try(Connection connection = DriverManager.getConnection(url,"root","4880");) {
            log.info(String.valueOf(connection));
        } catch (SQLException e) {

            throw new RuntimeException(e);
        }
    }

}
