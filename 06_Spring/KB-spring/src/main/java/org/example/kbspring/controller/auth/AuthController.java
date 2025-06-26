package org.example.kbspring.controller.auth;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {
    @GetMapping("/admin")
    public ResponseEntity<String> admin(){
        System.out.println("++++++++=+++++++++++++++++++++++=+++++++++++++++++++++++=+++++++++++++++admin");
        return ResponseEntity.ok("해당 문자열은 ADMIN만 확인 가능합니다");
    }

    @GetMapping("/member")
    public ResponseEntity<String> member(){
        return ResponseEntity.ok("해당 문자열은 MEMBER만 확인 가능합니다");
    }

    @GetMapping("/normal")
    public ResponseEntity<String> normal(){
        return ResponseEntity.ok("해당 문자열은 normal만 확인 가능합니다");
    }

}
