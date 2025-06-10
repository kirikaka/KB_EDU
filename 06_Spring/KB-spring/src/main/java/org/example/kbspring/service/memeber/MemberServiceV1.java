package org.example.kbspring.service.memeber;

import org.example.kbspring.domain.member.MemberEntity;
import org.example.kbspring.dto.member.MemberDto;
import org.example.kbspring.repository.member.MemberRepositoryV1;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MemberServiceV1 {
    private final MemberRepositoryV1 memberRepository;

    public MemberServiceV1 (MemberRepositoryV1 memberRepository){
        this.memberRepository = memberRepository;
    }

    public List<MemberDto> getMemberList(){
        List<MemberEntity> entityList =  memberRepository.getMeberList();
        List<MemberDto> dtoList=new ArrayList<MemberDto>();
        for(MemberEntity memberEntity:entityList){
            MemberDto dto=new MemberDto();
            dto.setName(memberEntity.getName());
            dto.setEmail(memberEntity.getEmail());
            dtoList.add(dto);

        }
        return dtoList;

    }
}
