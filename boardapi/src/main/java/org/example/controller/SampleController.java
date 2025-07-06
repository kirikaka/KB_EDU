package org.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.dto.SampleDTO;
import org.example.dto.SampleDTOList;
import org.example.dto.TodoDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.Arrays;

@Controller
@RequestMapping("/sample")
@Slf4j
public class SampleController {

    @RequestMapping("")
    public void basic() {
        log.info("--------------------------basic");
    }

    @RequestMapping(value = "/basic",method = {RequestMethod.GET,RequestMethod.POST})
    public void basicGet() {
        log.info("--------------------------basic get");
    }

    @RequestMapping(value = "/basicOnlyGet")
    public void basicOnlyGet() {
        log.info("--------------------------basic only get");
    }

    @GetMapping("/ex01")
    public String ex01(SampleDTO dto) {
        log.info("-------------------------ex01 +" + dto.toString());
        return "ex01";
    }

    @GetMapping("/ex02")
    public String ex02(@RequestParam("name") String name, @RequestParam("age") int age) {
        log.info("------------------------ex02 -" + name + " " + age);
        return "ex02";

    }

    @GetMapping("/ex03")
    public String ex03(@RequestParam("ids") ArrayList<String> ids ) {
        log.info("------------------------ex03 -" + ids.toString());

        return "ex03";
    }

    @GetMapping("/ex04")
    public String ex04(@RequestParam("ids") String[] ids ) {
        log.info("------------------------ex03 -" + Arrays.toString(ids));

        return "ex04";
    }

    @GetMapping("/ex02Bean")
    public String ex02Bean(SampleDTOList list) {
        log.info("list dtos: " + list);
        return "ex02Bean";
    }

    @GetMapping("/ex05")
    public String ex03(TodoDTO todo) {
        log.info("todo: " + todo);
        return "ex05";
    }

    @GetMapping("/ex06")
    public String ex04(SampleDTO dto,@ModelAttribute("page") int page) {
        log.info("dto: " + dto);
        log.info("page: " + page);
        return "sample/ex06";
    }

    @GetMapping("/ex06-2")
    public String ex06(RedirectAttributes ra) {
        log.info("/ex06........");
        ra.addAttribute("name", "AAA");
        ra.addAttribute("age", 10);
        return "redirect:/sample/ex06-2";
    }

    @GetMapping("/ex07")
    public@ResponseBody SampleDTO ex07() {
        log.info("/ex07........");
        SampleDTO dto = new SampleDTO();
        dto.setAge(10);
        dto.setName("홍길동");
        return dto;
    }
    @GetMapping("/ex08")
    public ResponseEntity<String> ex08() {
        log.info("/ex08..........");
    // {"name": "홍길동"}
        String msg = "{\"name\": \"홍길동\"}";
        HttpHeaders header = new HttpHeaders();
        header.add("Content-Type", "application/json;charset=UTF-8");
        return new ResponseEntity<>(msg, header, HttpStatus.OK);
    }

    @GetMapping("/exUpload")
    public void exUpload() {
        log.info("/exUpload..........");
    }

    @PostMapping("/exUploadPost")
    public void exUploadPost(ArrayList<MultipartFile> files) {
        for(MultipartFile file : files) {
            log.info("----------------------------------");
            log.info("name:" + file.getOriginalFilename()); // 윈도우 OS: 한글 파일명인 경우 깨짐
            log.info("size:" + file.getSize());
        }
    }



}

























