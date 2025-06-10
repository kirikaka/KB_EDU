package org.example.kbspring.repository.member;

import org.example.kbspring.domain.member.MemberEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MemberRepositoryV1 {
    public List<MemberEntity> getMeberList(){
        List<MemberEntity> memberList= new ArrayList<MemberEntity>();

        memberList.add(new MemberEntity(1L,"ronaldo@example.com","Ronaldo","Platinum",300000000000L));
        memberList.add(new MemberEntity(2L,"sjk@example.com","송중기","Platinum",100000000000L));
        memberList.add(new MemberEntity(3L,"xenosign@naver.com","Tetz","Diamond",5000000L));

        return memberList;

    }

}
