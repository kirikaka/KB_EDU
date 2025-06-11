package org.example.kbspring.service.memeber;

import lombok.extern.slf4j.Slf4j;
import org.example.kbspring.domain.member.MemberEntity;
import org.example.kbspring.dto.member.MemberDto;
import org.example.kbspring.repository.member.MemberRepositoryV1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class MemberServiceV1 {
    private final MemberRepositoryV1 memberRepository;

    // 의존성 자동 주입.
    @Autowired
    public MemberServiceV1 (MemberRepositoryV1 memberRepository){
        this.memberRepository = memberRepository;
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

    public void addMember(String name,String email){
        log.info("Add member name: {}, email: {}", name, email);
        MemberEntity member =new MemberEntity();
        member.setName(name);
        member.setEmail(email);

        member.setGrade("아이언");
        member.setAsset(10000000L);

        memberRepository.save(member);

    }


}
