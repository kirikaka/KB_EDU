package org.example.kbspring.controller.member;

import lombok.extern.slf4j.Slf4j;
import org.example.kbspring.domain.member.MemberEntity;
import org.example.kbspring.dto.member.MemberDto;
import org.example.kbspring.repository.member.MemberRepositoryV1;
import org.example.kbspring.service.memeber.MemberServiceV1;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.List;

@Controller
@Slf4j
public class MemberListControllerV1 {
    private final MemberServiceV1 memberService;

    public MemberListControllerV1(MemberServiceV1 memberService) {
        this.memberService = memberService;
    }


    @GetMapping("/member/list")
    public String memberList(Model model){


        List<MemberDto>memberList=memberService.getMemberList();
        model.addAttribute("memberList",memberList);

        return "member/list";
    }
}
