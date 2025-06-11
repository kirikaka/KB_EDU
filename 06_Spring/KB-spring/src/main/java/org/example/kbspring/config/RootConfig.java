package org.example.kbspring.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "org.example.kbspring")
public class RootConfig {
    // 어플리케이션 전역에 필요한 Bean은 RootConfig에서 등록
    // @Service, @Repository, @Component


}
