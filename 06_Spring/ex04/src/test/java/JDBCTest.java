import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.fail;

@Log4j2
public class JDBCTest {
    @BeforeAll
    public static void setUp(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("JDBC 드라이버 연결이 된다.")
    public void testConnection() throws SQLException {
        String url="jdbc:mysql://localhost:3306/scoula_db";
        try(Connection con= DriverManager.getConnection(url,"scoula","1234");){
            log.info(String.valueOf(con));
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }
}
