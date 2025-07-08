package org.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.security.account.domain.CustomUser;
import org.example.security.account.domain.MemberVO;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Slf4j
@Controller
@RequestMapping("/security")
public class SecurityController {
    @GetMapping("/all")
    public void doAll(){
        log.info("All of Security controller is called");

    }

//    @GetMapping("/member")
//    public void doMember(Principal principal){
//        log.info("Username is "+principal.getName());
//        log.info("Domember Security controller is called");
//    }

//    @GetMapping("/member")
//    public void doMember(Authentication authentication){
//        User user=(User)authentication.getPrincipal();
////        log.info("Username is "+principal.getName());
//        log.info("Domember Security controller is called");
//    }

    @GetMapping("/member")
    public void doMember(@AuthenticationPrincipal CustomUser customUser){
        MemberVO memberVO=customUser.getMember();
        log.info("Custom User is called : "+memberVO);
    }

    @GetMapping("/admin")
    public void doAdmin(){
        log.info("do Admin Security controller is called");
    }

    @GetMapping("/login")
    public void login(){
        log.info("Login Security controller is called");
    }

    @GetMapping("/logout")
    public void logout(){
        log.info("Logout Security controller is called");
    }
}

