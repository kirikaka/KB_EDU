package org.example.board.mapper;

import lombok.extern.slf4j.Slf4j;
import org.example.board.domain.BoardVO;
import org.example.config.RootConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {RootConfig.class})
@Slf4j
class BoardMapperTest {

    @Autowired
    private BoardMapper boardMapper;


    @Test
    void getList() {
        for(BoardVO board : boardMapper.getList()){
            log.info("board:{}",board);
        }
    }

    @Test
    @DisplayName("BoardMapper의 게시글 읽기")
    public void get() {
        BoardVO board = boardMapper.get(1L);
        log.info("board:{}",board);
    }


    @Test
    public void create() {
        BoardVO board = new BoardVO();
        board.setTitle("새로 작성글");
        board.setContent("새로 작성하는 내용");
        board.setWriter("user0");

        boardMapper.create(board);
        log.info("board:{}",board);

    }

    @Test
    public void update() {
        BoardVO board = new BoardVO();
        board.setNo(5L);
        board.setTitle("수정된 제목");
        board.setContent("수정된 내용");
        board.setWriter("user00");
        int count = boardMapper.update(board);
        log.info("update count ",count);
    }

    @Test
    @DisplayName("BoardMapper의 글 삭제")
    public void delete() {
        log.info("DELETE COUNT: " + boardMapper.delete(3L));
    }






}