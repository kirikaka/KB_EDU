package org.scoula.jdbc_ex.dao;

import org.junit.jupiter.api.*;
import org.scoula.jdbc_ex.common.JDBCUtil;
import org.scoula.jdbc_ex.domain.UserVO;

import java.sql.SQLException;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class UserDaoTest {
    UserDao dao = new UserDaoImpl();

    @AfterAll
    static void tearDown() {
        JDBCUtil.close();
    }

    @Test
    @DisplayName("User 등록")
    @Order(1)
    void create() throws SQLException {
        UserVO user=new UserVO("ssamz3","ssamz123","쌤즈","ADMIN");
        int count= dao.create(user);
        Assertions.assertEquals(count,1);

    }

    @Test
    @DisplayName("유저 수정")
    @Order(2)
    void update() throws SQLException {
        UserVO user=dao.get("ssamz3").orElseThrow(NoSuchElementException::new);
        user.setName("쌤즈3");
        int count= dao.update(user);
        Assertions.assertEquals(count,1);

    }

    @Test
    @DisplayName("유저 목록 조회")
    @Order(3)
    void getList() throws SQLException  {
        List<UserVO> list=dao.getList();
        for(UserVO user:list){
            System.out.println(user);
        }
    }

    @Test
    @DisplayName("특정 유저 추출")
    @Order(4)
    void get() throws SQLException {
        UserVO user=dao.get("ssamz3").orElseThrow(NoSuchElementException::new);
        Assertions.assertNotNull(user);
    }
    @Test
    @DisplayName("유저 삭제")
    @Order(5)
    void delete() throws SQLException  {
        int  count= dao.delete("ssamz3");
        Assertions.assertEquals(count,1);
    }
}



















