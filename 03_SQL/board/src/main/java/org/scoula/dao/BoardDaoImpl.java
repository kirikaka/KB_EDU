package org.scoula.dao;

import org.scoula.bean.BoardDto;
import org.scoula.util.DBUtil;

import java.sql.Connection;
import java.util.List;

public class BoardDaoImpl implements BoardDao {
    private static BoardDao boardDao=new BoardDaoImpl();
    private Connection conn= DBUtil.getConnection();

    @Override
    public void registerArticle(BoardDto boardDto) {

    }

    @Override
    public List<BoardDto> searchListAll() {
        return List.of();
    }

    @Override
    public List<BoardDto> searchListBySubject(String subject) {
        return List.of();
    }

    @Override
    public BoardDto viewArticle(int no) {
        return null;
    }

    @Override
    public void modifyArticle(BoardDto boardDto) {

    }

    @Override
    public void deleteArticle(int no) {

    }
}
