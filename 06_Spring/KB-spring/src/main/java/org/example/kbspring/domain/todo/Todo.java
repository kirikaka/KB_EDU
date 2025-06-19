package org.example.kbspring.domain.todo;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

//@Data안하는 이유 : 순환 참조 방지
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "todo")   //schema에 있으면 알아서 찾음
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "todo",nullable = false)
    private String todo;

    @Column(name = "done",nullable = false)
    private Boolean done;



}
