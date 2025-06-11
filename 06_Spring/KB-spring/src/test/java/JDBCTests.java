import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;

@Slf4j
public class JDBCTests {
    @BeforeAll
    public static void setup() {
        try {
            // mysql이랑 Java 통신
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("JDBC 드라이버 연결이 된다")
    public void testConnection() {
        String url = "jdbc:mysql://localhost:3306/tetzdb";
        try(Connection conn = DriverManager.getConnection(url, "root", "1234")) {
            log.info("conn = {}", conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}