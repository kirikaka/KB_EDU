import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.scoula.util.DBUtil;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionTest {

    @Test
    @DisplayName("DB 자동연결")
    public void testConnection() throws SQLException, ClassNotFoundException {
        try(Connection conn= DBUtil.getConnection()){
            System.out.println("DB 성공");
        }
    }
}
