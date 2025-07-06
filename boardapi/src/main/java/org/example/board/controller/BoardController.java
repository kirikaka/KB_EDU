package org.example.board.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.board.domain.BoardVO;
import org.example.board.dto.BoardDTO;
import org.example.board.service.BoardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/board")
@RequiredArgsConstructor
@Slf4j
public class BoardController {
    private final BoardService boardService;

    @GetMapping("")
    public ResponseEntity<List<BoardDTO>> getList(){
        return ResponseEntity.ok(boardService.getList());
    }

    @GetMapping("/{no}")
    public ResponseEntity<BoardDTO> get(@PathVariable Long no) {
        return ResponseEntity.ok(boardService.get(no));
    }
    @PostMapping("")
    public ResponseEntity<BoardDTO> create(@RequestBody BoardDTO board) {
        return ResponseEntity.ok(boardService.create(board));
    }

    @PutMapping("/{no}")
    public ResponseEntity<BoardDTO> update(@PathVariable Long no, @RequestBody BoardDTO board) {
        return ResponseEntity.ok(boardService.update(board));
    }

    @DeleteMapping("/{no}")
    public ResponseEntity<BoardDTO> delete(@PathVariable Long no) {
        return ResponseEntity.ok(boardService.delete(no));
    }
}
