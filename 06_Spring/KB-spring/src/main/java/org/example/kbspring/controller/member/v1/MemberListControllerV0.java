package org.example.kbspring.controller.member.v1;

import org.example.kbspring.dto.member.MemberDto;
import org.example.kbspring.service.memeber.MemberServiceV0;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MemberListControllerV0 {
    private final MemberServiceV0 memberService= MemberServiceV0.getInstance();

    @GetMapping("/member/v0/list")
    public String memberList(Model model){

        List<MemberDto> memberList=memberService.getMemberList();
        model.addAttribute("memberList",memberList);

        return "member/list";
    }

}
