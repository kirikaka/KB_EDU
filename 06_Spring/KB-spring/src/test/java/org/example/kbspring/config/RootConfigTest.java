package org.example.kbspring.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

@Configuration
@SpringJUnitConfig
@ContextConfiguration(classes = RootConfig.class)
@Slf4j
@PropertySource("classpath:application.properties")
class RootConfigTest {

    @Test
    void dataSource() {
    }

    @Autowired
    private SqlSessionFactory  sqlSessionFactory;


//    @Test
//    void sqlSessionFactory() {
//        try(SqlSession sqlSession = sqlSessionFactory.openSession(); Connection conn = sqlSession.getConnection()) {
//            log.info("SqlSession begin :{}", sqlSession);
//            log.info("Connection : {}", conn);
//        } catch (SQLException e) {
//            fail(e.getMessage());
//        }
//    }

    @Test
    void transactionManager() {
    }
}