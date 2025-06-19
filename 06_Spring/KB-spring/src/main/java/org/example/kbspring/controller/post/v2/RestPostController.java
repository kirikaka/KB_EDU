package org.example.kbspring.controller.post.v2;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.kbspring.dto.post.PostDto;
import org.example.kbspring.service.post.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@CrossOrigin(origins = "*")
@RequestMapping("/post/v2")
public class RestPostController {
    private final PostService postService;

    @GetMapping("/list")
    public List<PostDto> list(HttpServletRequest request,Model model){
        log.info("-----------------> Post List Calling",request.getRequestURI());

        return postService.findAll();
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("id") int id){
        log.info("---================>삭제기능 호출","/post/v1/delete");
        int affectedRows=postService.delete(id);
        log.info("삭제된 개수 : "+affectedRows);
        if(affectedRows==0){
            log.error("삭제 실패");
        }
        return "redirect:/post/v1/list";

    }

    @GetMapping("/new")
    public String newPage(Model model){
        log.info("=================> New Post Calling","/post/v1/new");
        return "post/v1/post-new";
    }

    @PostMapping("/new")
    public String save(@RequestParam("title")  String title, @RequestParam("content") String content){
        log.info("===========> new Post Update Calling","/post/v1/save");
        log.info("title,content : "+title+" "+content);
        postService.save(title,content);
        return "redirect:/post/v1/list";
    }

    @GetMapping("/search")
    public List<PostDto> postSearch(@RequestParam("title") String title,
                             @RequestParam("content") String content,
                             HttpServletRequest request){
        log.info("---------------> Post Search Calling",request.getRequestURI());

        return postService.findByCond(title,content);
    }


    @GetMapping("/compare")
    public String compare(Model model){
        log.info("---------------> Post Compare Calling","/post/v1/compare");
        int count=10000;
        postService.resetAndGeneratePosts(count);
        long mySqlTime= postService.testMysqlReadTime(count);
        long myRedisTime= postService.testRedisReadTime(count);

        model.addAttribute("count",count);
        model.addAttribute("mysqlTime",mySqlTime);
        model.addAttribute("redisTime",myRedisTime);

        return "post/v1/compare";



    }








}
