package org.example.kbspring.security.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.kbspring.security.filter.JwtAuthenticationFilter;
import org.example.kbspring.security.filter.JwtLoginFilter;
import org.example.kbspring.security.jwt.JwtTokenProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.CorsFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@Slf4j
public class SecurityConfig  extends WebSecurityConfigurerAdapter {
    private final JwtTokenProvider jwtTokenProvider;


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
                .cors().and()       // cors 켜주기
                .httpBasic().disable()      //http꺼주세요
                .csrf().disable()       //spring 지원 jsp가 아니므로
                .formLogin().disable();

        //내가 세션 정책 바꿀거야. 누군지 구분하기 위해서만 사용할거지 인증인가에서는 세션 사용X
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/user/**").permitAll()
                .antMatchers("/oauth/**").permitAll()
                .antMatchers("/index-test/**").permitAll()
                .antMatchers("/auth/admin").hasRole("ADMIN")
                .antMatchers("/auth/member").hasAnyRole("ADMIN", "MEMBER")
                .antMatchers("/auth/**").authenticated()    //로그인 한 사용자만 접근할수잇도록
                .antMatchers("/**").authenticated();

        //jwt 로그인 필터와 인증필터를 필터체인에 추가
        http.addFilterBefore(new JwtLoginFilter(authenticationManager(),jwtTokenProvider),
                UsernamePasswordAuthenticationFilter.class);


        http.addFilterBefore(new JwtAuthenticationFilter(jwtTokenProvider),
                UsernamePasswordAuthenticationFilter.class);

    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


    @Bean
    public CorsFilter corsFilter(){
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOriginPattern("*");    //모든 요청 받겠다.
        config.addAllowedHeader("*");           // 헤더에 뭐가있어도 상관 X
        config.addAllowedMethod("*");           // 모든 메서드 허용.
        // config를 모든 주소에 대해 적용
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }




}






















