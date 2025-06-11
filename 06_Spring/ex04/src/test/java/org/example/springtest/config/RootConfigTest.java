package org.example.springtest.config;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;


@Slf4j
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {RootConfig.class})
class RootConfigTest {
    @Autowired
    private DataSource dataSource;


    @Test
    @DisplayName("Datasource 연결 성공")
    void dataSource() throws SQLException{
        try(Connection con = dataSource.getConnection()){
            log.info("Datasource 준비완료");
            log.info(con.toString());
        }
    }
}