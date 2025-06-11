package org.example.kbspring.controller.member.v2;

import lombok.extern.slf4j.Slf4j;
import org.example.kbspring.dto.member.MemberDto;
import org.example.kbspring.service.memeber.MemberServiceV1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/member/v2")
public class MemberControllerV2 {
    private final MemberServiceV1 memberService;

    @Autowired
    public MemberControllerV2(MemberServiceV1 memberService) {
        this.memberService = memberService;
    }

    @GetMapping("")
    public String member(){
        log.info("------------->member");
        return "member/index";
    }

    @GetMapping("/list")
    public String memberList(Model model){


        List<MemberDto> memberList=memberService.getMemberList();
        model.addAttribute("memberList",memberList);

        return "member/list";
    }

    @PostMapping("/add")
    public String addMember(@RequestParam("name") String name,
                            @RequestParam("email") String email)  {

        log.info("Request About Addition Member name={}, email={}", name, email);
        memberService.addMember(name,email);

        return "redirect:/member/list";
    }

    @GetMapping("/add")
    public String addMemberPage(){
        log.info("Request About Addition Member page");
        return "member/add";
    }


}
