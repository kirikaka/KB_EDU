package org.example.kbspring.controller.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.kbspring.domain.user.User;
import org.example.kbspring.security.service.CustomUserDetailService;
import org.example.kbspring.service.user.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    private final CustomUserDetailService customUserDetailService;

    @GetMapping("/login")
    public String login(Model model){
        return "user/login";
    }

    @GetMapping("/register")
    public String register(Model model){
        return "user/register";
    }

    @PostMapping("/register")
    public String register(User user,Model model){
        userService.save(user);
        return "redirect:/user/login";
    }

    @GetMapping("login-success")
    public String loginSuccess(Model model, Principal principal, Authentication auth){
//        UserDetails userDetails = customUserDetailService.loadUserByUsername(principal.getName());

        log.info("----------------->UserPricipal = ", principal);
        log.info("__________________> User Authentication: {}",auth);

        model.addAttribute("user",principal.getName());
        model.addAttribute("auth",auth.getAuthorities());
        return  "user/login-success";
    }

    @GetMapping("/login-failure")
    public String loginFailed(){
        return  "user/login-failure";
    }


}














