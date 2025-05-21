package org.scoula.jdbc_ex.test;


import org.junit.jupiter.api.*;
import org.scoula.jdbc_ex.common.JDBCUtil;

import java.sql.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CrudTest {
    Connection conn = JDBCUtil.getConnection();

    @AfterAll
    static void tearDown() {
        JDBCUtil.close();
    }

    @Test
    @DisplayName("새로운 User를 등록한다.")
    @Order(1)
    public void insertUser() throws SQLException{
        String sql="insert into users (id,password,name,role) values (?,?,?,?)";
        try(PreparedStatement ps=conn.prepareStatement(sql)){
            ps.setString(1,"scoula");
            ps.setString(2,"scoula3");
            ps.setString(3,"스콜라");
            ps.setString(4,"USER");

            int count=ps.executeUpdate();
            Assertions.assertEquals(count,1);
        }
    }

    @Test
    @DisplayName(" user 목록을 추출한다. ")
    @Order(2)
    public void selectUser() throws SQLException{
        String sql="select * from users";
        try(Statement stmt=conn.createStatement()){
            ResultSet rs=stmt.executeQuery(sql);
            while(rs.next()){
                System.out.println(rs.getString("name"));
            }
        }
    }

    @Test
    @DisplayName("특정 유저 검색")
    @Order(3)
    public void selectUsers() throws SQLException{
        String userid="scoula";
        String sql="select * from users  where id=?";
        try(PreparedStatement stmt=conn.prepareStatement(sql)){
            stmt.setString(1,userid);

            try(ResultSet rs=stmt.executeQuery()){
                if(rs.next()){
                    System.out.println(rs.getString("name"));
                } else{
                    throw new SQLException("scoular not found");
                }

            }
        }
    }
    @Test
    @DisplayName("특정 user 수정")
    @Order(4)
    public void updateUser() throws SQLException{
        String userid="scoula";
        String sql="update users set name=? where id=?";
        try(PreparedStatement ps=conn.prepareStatement(sql)){
            ps.setString(1,"스콜라 수정");
            ps.setString(2,userid);
            int count=ps.executeUpdate();
            Assertions.assertEquals(count,1);
        }

    }

    @Test
    @DisplayName("특정유저 삭제")
    @Order(5)
    public void deleteUser() throws SQLException{
        String userid="scoula";
        String sql="delete from users where id=?";
        try(PreparedStatement ps=conn.prepareStatement(sql)){
            ps.setString(1,userid);
            int count=ps.executeUpdate();
            Assertions.assertEquals(count,1);
        }
    }





}


















