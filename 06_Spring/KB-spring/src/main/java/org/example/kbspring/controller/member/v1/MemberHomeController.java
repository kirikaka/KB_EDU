package org.example.kbspring.controller.member.v1;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class MemberHomeController {
    @GetMapping("/member")
    public String member(){
        log.info("------------->member");
        return "member/index";
    }
}
