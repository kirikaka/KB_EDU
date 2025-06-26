package org.example.kbspring.security.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.example.kbspring.dto.user.LoginRequestDto;
import org.example.kbspring.security.jwt.JwtTokenProvider;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;


public class JwtLoginFilter extends UsernamePasswordAuthenticationFilter {
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;

    public JwtLoginFilter(AuthenticationManager authenticationManager, JwtTokenProvider jwtTokenProvider) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
        // /auth/login으로 post 요청을 보내면 jwt 로그인으로 간주하겠다.
        setFilterProcessesUrl("/auth/login");

    }

    // spring security에 회원 로그인 요청이 들어오면 자동으로 호출 된다.
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        try{
            ObjectMapper mapper = new ObjectMapper();
            LoginRequestDto loginRequest = mapper.readValue(request.getInputStream(), LoginRequestDto.class);

            UsernamePasswordAuthenticationToken authToken=new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),loginRequest.getPassword());

            return authenticationManager.authenticate(authToken);

        } catch (IOException e){
            throw new AuthenticationServiceException("로그인 요청 실패");
        }
    }

    // attemptAuthentication가 성공되면 자동으로 호출 되는 메서드
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        String role=authResult.getAuthorities().iterator().next().getAuthority();
        String token=jwtTokenProvider.generateToken(authResult.getName(), Arrays.asList(role));

        response.setHeader("Access-Control-Expose-Headers", "Authorization");
        response.setHeader("Authorization", "Bearer " + token);
        response.setContentType("application/json");

        String responseBody=String.format("{\"token\":\"%s\",\"role\":\"%s\"}", token, role);

        response.getWriter().write(responseBody);


    }
}


































