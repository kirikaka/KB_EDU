package org.example.kbspring.controller.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.kbspring.domain.user.User;
import org.example.kbspring.service.user.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

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

}
