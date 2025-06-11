package org.example.kbspring.repository.member;

import lombok.extern.slf4j.Slf4j;
import org.example.kbspring.domain.member.MemberEntity;
import org.example.kbspring.service.memeber.MemberServiceV1;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Slf4j
public class MemberRepositoryV1 {

    private final List<MemberEntity>memberList=new ArrayList<>();

    public MemberRepositoryV1() {
        log.info("MemberRepositoryV1 constructor");


        memberList.add(new MemberEntity(1L,"ronaldo@example.com","Ronaldo","Platinum",300000000000L));
        memberList.add(new MemberEntity(2L,"sjk@example.com","송중기","Platinum",100000000000L));
        memberList.add(new MemberEntity(3L,"xenosign@naver.com","Tetz","Diamond",5000000L));

    }


    public List<MemberEntity> getMemberList(){
        return memberList;

    }
    public void save(MemberEntity member){
        log.info("save member name: {}, email: {}", member.getName(), member.getEmail());
        member.setId((long)(memberList.size()+1));
        memberList.add(member);
    }

}
