package org.scoula.dao;

import org.scoula.bean.BoardDto;

import java.sql.SQLException;
import java.util.List;

public interface BoardDao {
    void registerArticle(BoardDto boardDto);
    List<BoardDto> searchListAll();
    List<BoardDto> searchListBySubject(String subject);
    BoardDto viewArticle(int no);
    void modifyArticle(BoardDto boardDto);
    void deleteArticle(int no);
}
