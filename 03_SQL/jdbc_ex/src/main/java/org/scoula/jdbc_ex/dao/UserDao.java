package org.scoula.jdbc_ex.dao;

//Data Access Object


import org.scoula.jdbc_ex.domain.UserVO;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface UserDao {
    // 등록
    int create(UserVO user) throws SQLException;
    // 수정
    int update(UserVO user) throws SQLException;
    // 삭제
    int delete(String id) throws SQLException;
    //회원 목록 조회
    List<UserVO> getList() throws SQLException;
    // 회원 정보 조회
    Optional<UserVO> get(String id) throws SQLException;
}
