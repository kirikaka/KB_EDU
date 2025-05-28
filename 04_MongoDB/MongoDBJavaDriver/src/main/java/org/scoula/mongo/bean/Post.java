package org.scoula.mongo.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data // @Getter, @Setter, @ToString, @EqualsAndHashCode 포함
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    private int id;
    private String title;
    private String content;
    private Date createdAt = new Date(); // 생성 시 자동 설정
    // Post 클래스에 추가
    public Post(int id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createdAt = new Date();
    }

}
