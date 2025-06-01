import org.example.database.JDBCUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionTest {
    @Test
    @DisplayName("jdbc_ex 데이터 베이스에 접속")
    public void testConnection() throws SQLException, ClassNotFoundException{
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3307/jdbc_ex";
        String id="scoula";
        String password="1234";
        Connection conn = DriverManager.getConnection(url,id,password);
        System.out.println("DB 연결 성공");
        conn.close();
    }

    @Test
    @DisplayName("jdbc_ex에 접속(자동닫기)")
    public void connectionTest() throws SQLException {
        try(Connection conn= JDBCUtil.getConnection()) {
            System.out.println("DB ㅅ연결 성공");
        }

    }

}
