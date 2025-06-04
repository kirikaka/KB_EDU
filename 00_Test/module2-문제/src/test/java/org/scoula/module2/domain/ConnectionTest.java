package org.scoula.module2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.scoula.module2.util.JDBCUtil;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionTest {

    @Test
    @DisplayName("DB 연결 테스트")
    public void testConnection() throws SQLException, ClassNotFoundException {
        try (Connection conn = JDBCUtil.getConnection()) {
            System.out.println("Connected to database.");
        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}
