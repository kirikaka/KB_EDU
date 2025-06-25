package org.example.kbspring.security.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.kbspring.security.filter.JwtAuthenticationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.web.filter.CharacterEncodingFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@Slf4j
public class SecurityConfig  extends WebSecurityConfigurerAdapter {
    // 문자셋 필터
    public CharacterEncodingFilter encodingFilter(){
        CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
        encodingFilter.setEncoding("UTF-8");
        encodingFilter.setForceEncoding(true);
        return encodingFilter;
    }

    //JWT 사용시 form login 사용안함
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .antMatchers("/").permitAll()
//                .antMatchers("/user/**").permitAll()
//                .antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
//                .antMatchers("/manager/**").access("hasAnyRole('ROLE_ADMIN', 'ROLE_MEMBER')")
//                .antMatchers("/**").authenticated();
//
//
//        http.addFilterBefore(encodingFilter(), CsrfFilter.class);
//
//        http.formLogin()
//                .loginPage("/user/login")
//                .loginProcessingUrl("/user/login")
//                .defaultSuccessUrl("/user/login-success")
//                .failureUrl("/user/login-failure");
//
//        http.logout()
//                .logoutUrl("/user/logout")
//                .invalidateHttpSession(true)
//                .deleteCookies("remember-me","JSESSIONID")
//                .logoutSuccessUrl("/user/login")
//                .permitAll();
//
//    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .httpBasic().disable()
                .csrf().disable()       //spring 지원 jsp가 아니므로
                .formLogin().disable();

        //내가 세션 정책 바꿀거야. 누군지 구분하기 위해서만 사용할거지 인증인가에서는 세션 사용X
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.addFilterBefore(new JwtAuthenticationFilter(),
                UsernamePasswordAuthenticationFilter.class);

    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}






















