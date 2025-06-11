package org.example.kbspring.controller.member.v1;


import lombok.extern.slf4j.Slf4j;
import org.example.kbspring.service.memeber.MemberServiceV1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Slf4j
public class MemberAddControllerV1 {
    private final MemberServiceV1 memberService;

    @Autowired
    public MemberAddControllerV1(MemberServiceV1 memberService) {
        log.info("MemberAddControllerV1 constructor");
        this.memberService = memberService;
    }

//    @PostMapping("/member/add")
//    public String addMember(HttpServletRequest req) {
//
//        String name = req.getParameter("name");
//        String email = req.getParameter("email");
//
//        log.info("Request About Addition Member name={}, email={}", name, email);
//        memberService.addMember(name,email);
//
//        return "redirect:/member/list";
//    }


    // name이라고 들어올 매개변수를 뽑는것.
    @PostMapping("/member/add")
    public String addMember(@RequestParam("name") String name,
                            @RequestParam("email") String email)  {

        log.info("Request About Addition Member name={}, email={}", name, email);
        memberService.addMember(name,email);

        return "redirect:/member/list";
    }

    @GetMapping("/member/add")
    public String addMemberPage(){
        log.info("Request About Addition Member page");
        return "member/add";
    }

}
