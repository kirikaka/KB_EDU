package org.example.board.service;

import lombok.extern.slf4j.Slf4j;
import org.example.board.dto.BoardDTO;
import org.example.board.mapper.BoardMapper;
import org.example.config.RootConfig;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {RootConfig.class})
@Slf4j
class BoardServiceImplTest {

    @Autowired
    private BoardService service;
    @Autowired
    private BoardMapper boardMapper;

    @Test
    public void getList() {
        for(BoardDTO board : service.getList()) {
            log.info(board.toString());
        }
    }

    @Test
    void get() {
    }

    @Test
    void create() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }
}