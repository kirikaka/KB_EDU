package org.example.kbspring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;


// Web 설정 담당하는 ServletConfig
@EnableWebMvc
@ComponentScan(basePackages = {"org.example.kbspring.controller"})
public class ServletConfig implements WebMvcConfigurer {
    // web 관련 bean 등록
    // @Controller,@RestController

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
                .addResourceHandler("/resources/**")
                .addResourceLocations("/resources/");
    }

    // jsp view resolver 설정
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry){
        InternalResourceViewResolver bean = new InternalResourceViewResolver();
        bean.setViewClass(JstlView.class);
        bean.setPrefix("/WEB-INF/");
        bean.setSuffix(".jsp");
        registry.viewResolver(bean);
    }
}