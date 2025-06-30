package org.example.kbspring.controller.oauth;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.kbspring.dto.oauth.KakaoUserInfoDto;
import org.example.kbspring.service.oauth.KakaoOauthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/oauth")
public class OAuthController {
    private final KakaoOauthService kakaoOauthService;
    private KakaoUserInfoDto kakaoUserInfo;

    @GetMapping("/kakao/callback")
    public void kakaoCallback(@RequestParam String code,
                              @RequestParam(required = false) String state,
                              HttpServletResponse response) throws IOException {
        log.info("kakaoCallback   I need your code : " + code);
        KakaoUserInfoDto userInfo=kakaoOauthService.processKakaoLogin(code);
        kakaoUserInfo=userInfo;

        Cookie cookie=new Cookie("jwt", userInfo.getToken());
        cookie.setHttpOnly(true);
        cookie.setPath("/");
        cookie.setMaxAge(3600);

        response.addCookie(cookie);

        String frontendRedirect=(state !=null) ? state : "http://localhost:5173";
        response.sendRedirect(frontendRedirect);


    }

    @GetMapping("/user/me")
    public ResponseEntity<KakaoUserInfoDto> getKakaoUserInfo(){
        return ResponseEntity.ok(kakaoUserInfo);
    }




}






















