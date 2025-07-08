package org.example.security.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.security.account.domain.CustomUser;
import org.example.security.account.domain.MemberVO;
import org.example.security.account.mapper.UserDetailsMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class CustomUserDetailsService  implements UserDetailsService {
    private final UserDetailsMapper mapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        MemberVO vo=mapper.get(username);
        if(vo==null){
            throw new UsernameNotFoundException(username+"은 없은 id");


        }
        return new CustomUser(vo);

    }
}
