package list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;

public class ListBasic1 {



    // ArrayList
    // LinkedList : 메모리 많이 차지한다. Spring에서 사용하기에는 효율 안좋음
    // Vector
    public static void main(String[] args) {
        Member[] memberArray = new Member[3];
        memberArray[0] = new Member("testID1", "김길동", 23, 60000.212);
        memberArray[1] = new Member("testID2", "홍길동", 32, 53123.233);
        memberArray[2] = new Member("testID3", "박길동", 25, 41212.322);
        //memberArray[3] = new Member("testID4", "박길동", 25, 41212.322);

        // 배열의 단점
        // 1. 배열의 크기를 지정해야하고, 크기보다 커지면 새로운 배열을 생성하고 복사 필요
        // 2. 중간에 데이터 삽입/삭제가 어렵다. -> 반드시 빈데이터를 메꿔야한다!
        // 3. 복사도 어렵고, 사용자 실수가 많았다.
        // 결론 : 프로그래머라면 누구든 고통 받았다.

        // How to use List
        // 1. 초기화 문법
        List<String> strList=new ArrayList<String>();   //1.5 문법 type 생략X
        List<Integer> intList= new ArrayList<>();       //숫자 리스트, 정석 버전
        ArrayList<Member> memberList=new ArrayList<>(); //
        LinkedList<Member> memberLinkedList=new LinkedList<>();
        //LinkedList는 LinkedList로 선언하는 것이 유리함.

        // 권장 패턴
        List<Member> list=new ArrayList<>();

        //2. 인자를 넣고 생성하는 법, 배열에서 List로 전환하는 법
        // 1) Arrays.asList()
        List<String> strList2= Arrays.asList("dsaf","dfdf","123123");  //immutable
        List<String> strList3= List.of("dsaf","dfdf","123123");


        // 수정 가능한 컬렉션으로 선언하는 방법.
        List<String> strList4=new ArrayList<>(List.of("dsaf","dfdf","123123")); //mutable
        List<Member> mList1= new ArrayList<>(Arrays.asList(memberArray));
        List<Member> mList2= new ArrayList<>(List.of(memberArray));

        mList1.add(new Member("test7","박길동",31,132374));

        System.out.println(mList1);
        System.out.println(mList2);


        // 2) 고전적인 알고리즘 활용 방법
        List<Member> mList3 = new ArrayList<>();
        // Advanced for loop
        for(Member m : memberArray){
            mList3.add(m); // 그냥 add
        }
        System.out.println("mList3 : " + mList3 + "\n");

        // 3) 고전적인 알고리즘 활용 방법
        // index for loop
        List<Member> mList4 = new ArrayList<>();
        for(int i = 0; i < memberArray.length; i++){
        //mList4.add(memberArray[i]); // 그냥해도 된다.
            mList4.add(i, memberArray[i]); // index를 포함한 add
        }
        System.out.println("mList4 : " + mList4 + "\n");
        System.out.println("------------------------------------------");

        // How to Print List
        // List는 toString으로 객체 정보 확인가능
        System.out.println(mList4);
        System.out.println("============================================================");
        System.out.println(mList4.toString().replace("},", "}\n"));
        System.out.println("============================================================");

        // 순회하는 법
        for( Member m : mList4){
            System.out.println(m);
        }
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++");

        for(int i=0;i<mList4.size();i++){
            System.out.println(mList4.get(i));
        }
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++");


        //Stream 문법
        // 1) 익명 클래스로 Consumer를 생성하여 순회하는 방법
        mList4.forEach(new Consumer<Member>() {
            @Override
            public void accept(Member member) {
                System.out.println(member.toString());
            }
        });
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++");

        mList4.forEach( (Member m) -> {
            System.out.println(m.toString());
        });
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++");


        mList4.stream().forEach(System.out::println);
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++");



    }
}

































