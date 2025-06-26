package org.example.kbspring.security.filter;

import lombok.RequiredArgsConstructor;
import org.example.kbspring.security.jwt.JwtTokenProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    private final JwtTokenProvider jwtTokenProvider;




    // 이필터가 내부에서 어떤 작업을 할지.
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String header=request.getHeader("Authorization");
        System.out.println("+++++++++++++++++ JWTAuthenticationFilter 확인용 +++++++++++++++++");

        //JWT Token앞에 'Bearer ' 붙어있다. = 무언가를 이동시켜주는 Bearer
        if (header != null && header.startsWith("Bearer ")){
            String token=header.substring(7);
            if(jwtTokenProvider.validateToken(token)){
                Authentication auth = jwtTokenProvider.getAuthentication(token);

                // SecurityContextholder에서 context가져와서 auth를 등록시켜준다.
                SecurityContextHolder.getContext().setAuthentication(auth);
            }


        }

        // 뒤에 남아있는 필터 작업을 이어가기
        filterChain.doFilter(request,response);


    }
}
