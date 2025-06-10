package org.example.kbspring.domain.member;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //lombok이 자동으로 getter,setter,toString,hashcode 등 생성 해준다.
@AllArgsConstructor // 모든 필드값을 받는 생성자가 필요하다.
@NoArgsConstructor  // 아무것도 없이 빈 객체를 만드는 생성자가 필요
public class MemberEntity {
    private Long id;
    private String email;
    private String name;
    private String grade;
    private Long asset;
}
