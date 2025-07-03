package org.example.board.mapper;

import org.apache.ibatis.annotations.Select;
import org.example.board.domain.BoardVO;

import java.util.List;

public interface BoardMapper {
    public List<BoardVO> getList();
    public BoardVO get(Long no);
    public void create(BoardVO board);

    public int update(BoardVO board);
    public int delete(Long no);

}
