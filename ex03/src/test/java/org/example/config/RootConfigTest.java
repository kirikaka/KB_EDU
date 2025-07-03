package org.example.config;


import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {RootConfig.class})
@Slf4j
class RootConfigTest {

    @Autowired
    private DataSource dataSource;

    @Test
    @DisplayName("DataSource 연결이 된다.")
    void dataSource() throws SQLException {
        try(Connection con=dataSource.getConnection()){
            log.info("데이터 소스 준비완료");
            log.info(String.valueOf(con));
        }

    }

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Test
    public void testSqlSessionFactory() throws SQLException {
        try(
                SqlSession sqlSession = sqlSessionFactory.openSession();
                Connection conn = sqlSession.getConnection();)
        {
            log.info(String.valueOf(sqlSession));
            log.info(String.valueOf(conn));
        } catch (Exception e) {
            log.info(e.getMessage());
            throw new RuntimeException(e);
        }

    }
}

























