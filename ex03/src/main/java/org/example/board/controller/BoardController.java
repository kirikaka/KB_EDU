package org.example.board.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.example.board.domain.BoardAttachmentVO;
import org.example.board.dto.BoardDTO;
import org.example.board.service.BoardService;
import org.example.board.service.BoardServiceImpl;
import org.example.common.util.UploadFiles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
@Slf4j
public class BoardController {
    final private BoardService service;

    @GetMapping("/list")
    public void list(Model model) {
        log.info("list");
        model.addAttribute("list",service.getList());
    }

    @GetMapping("/create")
    public void create(Model model) {
        log.info("create");
    }

    @PostMapping("/create")
    public String create(BoardDTO board){
        log.info("create"+board);
        service.create(board);
        return "redirect:/board/list";
    }
    @GetMapping({"/get","/update"})
    public void get(@RequestParam("no") Long no, Model model) {
        log.info("get or update");
        model.addAttribute("board",service.get(no));
    }

    @PostMapping("/update")
    public String update(BoardDTO board){
        log.info("update");
        service.update(board);
        return "redirect:/board/list";
    }

    @PostMapping("delete")
    public String delete(@RequestParam("no") Long no){
        log.info("delete");
        service.delete(no);
        return "redirect:/board/list";

    }

    @GetMapping("/download/{no}")
    @ResponseBody
    public void download(@PathVariable("no") Long no, HttpServletResponse response) throws Exception {
        BoardAttachmentVO attach=service.getAttachment(no);
        File file=new File(attach.getPath());
        UploadFiles.download(response,file,attach.getFilename());
    }


}
