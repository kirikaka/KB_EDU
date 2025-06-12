package org.example.kbspring.service.memeber;

import org.example.kbspring.domain.member.MemberEntity;
import org.example.kbspring.dto.member.MemberDto;
import org.example.kbspring.repository.member.v1.MemberRepositoryV0;

import java.util.ArrayList;
import java.util.List;

public class MemberServiceV0 {
    private static MemberServiceV0 instance;
    private final MemberRepositoryV0 memberRepository;

    public MemberServiceV0(){
        this.memberRepository=MemberRepositoryV0.getInstance();
    }

    public static MemberServiceV0 getInstance(){
        if(instance==null){
            instance=new MemberServiceV0();

        }
        return instance;
    }

    public List<MemberDto> getMemberList(){
        List<MemberEntity> entityList =  memberRepository.getMemberList();
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
