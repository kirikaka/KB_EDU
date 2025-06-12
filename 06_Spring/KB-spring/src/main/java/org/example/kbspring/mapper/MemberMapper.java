package org.example.kbspring.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.kbspring.domain.member.MemberEntity;

import java.util.List;

@Mapper
public interface MemberMapper {
    List<MemberEntity>findAll();
    List<MemberEntity>findTwo();
}
