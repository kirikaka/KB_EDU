import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.scoula.db.JDBCUtil;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionTest {

    @Test
    @DisplayName("jdbc_ex에 접속(자동닫기)")
    public void connectionTest() throws SQLException {
        try(Connection conn= JDBCUtil.getConnection()) {
            System.out.println("DB ㅅ연결 성공");
        }


    }
}
