package org.example.kbspring.security.filter;

import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String header=request.getHeader("Authorization");

        //JWT Token앞에 'Bearer ' 붙어있다. = 무언가를 이동시켜주는 Bearer
        if (header == null || !header.startsWith("Bearer ")){
            String token=header.substring(7);
            //250626 채울 예정

        }

        filterChain.doFilter(request,response);


    }
}
