package org.example.security.account.mapper;

import org.example.security.account.domain.MemberVO;

public interface UserDetailsMapper {
    public MemberVO get(String username);
}
