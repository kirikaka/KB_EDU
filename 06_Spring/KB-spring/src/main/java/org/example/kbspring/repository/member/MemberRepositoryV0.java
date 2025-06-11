package org.example.kbspring.repository.member;

import org.example.kbspring.domain.member.MemberEntity;

import java.util.ArrayList;
import java.util.List;

public class MemberRepositoryV0 {
    private static MemberRepositoryV0 instance;

    private MemberRepositoryV0(){};

    public static MemberRepositoryV0 getInstance(){
        if(instance==null){
            instance = new MemberRepositoryV0();
        }
        return instance;
    }


    public List<MemberEntity> getMemberList(){
        List<MemberEntity> memberList= new ArrayList<MemberEntity>();

        memberList.add(new MemberEntity(1L,"ronaldo@example.com","Ronaldo","Platinum",300000000000L));
        memberList.add(new MemberEntity(2L,"sjk@example.com","송중기","Platinum",100000000000L));
        memberList.add(new MemberEntity(3L,"xenosign@naver.com","Tetz","Diamond",5000000L));

        return memberList;

    }


}
