package org.example.kbspring.dto.oauth;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class KakaoUserInfoDto {
    private Long kakaoId;
    private String email;
    private String nickname;
    private String profileImageUrl;
    private String token;
}
