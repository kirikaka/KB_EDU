package org.example.kbspring.controller.post.v3;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.kbspring.dto.post.PostDto;
import org.example.kbspring.dto.weather.WeatherDto;
import org.example.kbspring.service.post.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Api(tags = "게시판 REST Controller")
@RestController
@RequiredArgsConstructor
@Slf4j
@CrossOrigin(origins = "*")
@RequestMapping("/post/v3")
public class RestPostControllerV3 {
    private final PostService postService;

    /**
     * 나는 직쏘다
     * @param request
     * @param model
     * @return
     */

    @ApiOperation(value = "전체 게시글 조회",notes = "전체 게시글 조회 API")
    @GetMapping("/list")
    public ResponseEntity<List<PostDto>> list(HttpServletRequest request, Model model){
        log.info("-----------------> Post List Calling",request.getRequestURI());
        List<PostDto>list=postService.findAll();

        return ResponseEntity.ok(list);
    }

    @GetMapping(value = "/test",produces = "text/plain;charset=UTF-8")
    public ResponseEntity<String> test(){


        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not Found Test");
    }


    @ApiOperation(value = "게시글 삭제",notes = "게시글 삭제 API")
    @PostMapping(value = "/delete",produces = "text/plain;charset=UTF-8")
    public ResponseEntity<String> delete(
            @ApiParam(value = "게시글 ID",required = true,example = "1")
            @RequestParam("id") int id){

        try{
            int affectedRows=postService.delete(id);

            if(affectedRows==0){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("삭제 대상을 찾을 수 없습니다.");
            }
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("서버 내부 오류");
        }


    }

    @GetMapping("/new")
    public String newPage(Model model){
        log.info("=================> New Post Calling","/post/v1/new");
        return "post/v1/post-new";
    }

//    @PostMapping("/new")
//    public String save(@RequestParam("title")  String title, @RequestParam("content") String content){
//        log.info("===========> new Post Update Calling","/post/v1/save");
//        log.info("title,content : "+title+" "+content);
//        postService.save(title,content);
//        return "redirect:/post/v1/list";
//    }

    @PostMapping("new")
    public ResponseEntity<String> addPost(@RequestBody PostDto postDto){
        log.info("PostDTo : {}",postDto);
        log.info("제목이 어디 나오는겨",postDto.getTitle());

        return ResponseEntity.ok("게시글 추가 요청");
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
