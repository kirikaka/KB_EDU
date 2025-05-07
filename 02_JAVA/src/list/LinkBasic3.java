package list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LinkBasic3 {
    public static void main(String[] args) {
        // 기본형 / 커스텀 정렬 방법 정리 ★★★★★
        // -> 코테 풀때 매우 중요함으로 아래 문법중 외울 문법을 정해서 반드시 외울것!!!! ★★★★★

        //  1. 컬렉션 기본형 정렬 (String, Integer, Double ...)
        // - Collections.sort or List.sort를 활용하여 정렬 가능
        // - 기본적으로 오름차순으로 정렬할수 있고, 내림차순 정렬시 몇가지 방법이 존재!
        //   -> 내림차순 필요시 Collections.reverse 활용

        List<Integer> intList = new ArrayList<>(List.of(4,3,2,1,5));
        //오름차순
        Collections.sort(intList);
        System.out.println(intList);
        intList.sort(Integer::compareTo);
        System.out.println(intList);
        intList.sort(Comparator.naturalOrder());
        System.out.println(intList);

        //내림차순
        // 시간 상 약간 손해. 배열 생성 후 복사하는 시간 만큼
        Collections.reverse(intList);
        System.out.println(intList);

        //내림차순 권장 방법
        intList.sort(Comparator.reverseOrder());
        System.out.println(intList);

        //문자열 정렬
        List<String> strList=new ArrayList<>(List.of("홍길동","박길동","김길동","홍길순"));

        //오름차순
        Collections.sort(strList);
        System.out.println(strList);
        strList.sort(String::compareTo);
        System.out.println(strList);
        strList.sort(Comparator.naturalOrder());
        System.out.println(strList);
        //내림차순

        Collections.reverse(strList);
        System.out.println(strList);
        strList.sort(Comparator.reverseOrder());
        System.out.println(strList);


        //2. 객체 커스텀 정렬
        // - 기본형이 아닌 경우 Comparator, Comparable을 통해 정렬할수 있다.
        // - Java8 이후 lambda 문법을 통해 간략화(?) 되었다.
        List<Member> list = new ArrayList<>();
        list.add(new Member("TestID3", "홍길동3", 44, 11110.1));
        list.add(new Member("TestID4", "홍길동", 21, 143.1));
        list.add(new Member("TestID2", "홍길동2", 22, 100.1));
        list.add(new Member("TestID5", "최길동", 32, 4400.1));
        list.add(new Member("TestID6", "홍길동", 25, 10550.1));
        list.add(new Member("TestID7", "홍길순", 21, 10550.1));
        list.add(new Member("TestID8", "홍길동", 25, 20550.1));
        list.add(new Member("TestID1", "김길동", 25, 10550.1));

        System.out.println("\n정렬 이전!");
        list.forEach(System.out::println);
        System.out.println("---------------------------------------------------------");


        // 1) 객체에서 Comparable을 통해 정렬하는 방법 -> 추천안함
        Collections.sort(list);
        list.forEach(System.out::println);
        System.out.println("---------------------------------------------------------");

        // 2) comparator 통해 정렬항는 방법
        // 다양한 기준으로 정렬 가능
        // 단점 : 문법이 어렵다.
        System.out.println("나이순으로 정렬");
        list.sort(new Comparator<Member>() {
            @Override
            public int compare(Member o1, Member o2) {
                //Custom Command
//                return( x<y)? -1:((x==y)?0:1);
                return Integer.compare(o1.getAge(), o2.getAge()); //양수 음수 0으로 나온다.오름차순
//                return Integer.compare(o2.getAge(), o1.getAge());  내림차순
            }
        });
        list.forEach(System.out::println);
        System.out.println("---------------------------------------------------------");


        System.out.println("이름순 정렬하는 방법");
        Collections.sort(list, new Comparator<Member>() {
            @Override
            public int compare(Member o1, Member o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        list.forEach(System.out::println);
        System.out.println("---------------------------------------------------------");


        // 3.람다식 정렬(Java 8 over)
        // - 익명클래스나 함수를 람다식으로 바꿔 쉽게 표현 가능하다.
        // - 방법1 : Comparator 직접 구현 ex : (o1, o2) -> (returnValue) : 람다식 표현
        // - 방법2 : Comparator에서 getter로 정렬순서 정하기 가능
        // - 생소해서 문법 가독성이 살짝 떨어짐 -> 익숙해지면 편하다!

        System.out.println("계좌 잔액 순 정렬");
        // 방법1. comparator를 람다식으로 직접 구현(코테용)
        list.sort((o1,o2)->Double.compare(o1.getAccount(),o2.getAccount()));

        // 방법2. comparator에서 선언된 객체의 getter 정렬
        list.sort(Comparator.comparing(Member::getAccount));
        list.forEach(System.out::println);
        list.sort(Comparator.comparing(Member::getAccount).reversed());
        list.forEach(System.out::println);
        System.out.println("--------------------------------------------------------");

        // 4. Stream(=데이터 처리 용도, Java8 이상)을 통한 정렬
        // - 람다식중 하나인 Stream 문법을 통해 정렬하는 방법
        // - parallel를 활용하면 병렬처리 되어 매우 빠르게 정렬된다고 한다.
        System.out.println("나이순으로 정렬");
        List<Member> newList1 = list.stream()
                .sorted(Comparator.comparingInt(Member::getAge))
                .toList();
        newList1.forEach(System.out::println);
        System.out.println("---------------------------------------------------------");

        // parallel 활용 문법
        List<Member> newList2 = list.stream().parallel()
                .sorted(Comparator.comparingInt(Member::getAge))
                .toList();
        newList2.forEach(System.out::println);
        System.out.println("---------------------------------------------------------");

        // 사용자 커스텀 정렬 활용
        // -이름-나이-계좌순 정렬

        // 1. 정렬 세번 -> 비추


        // 2. 익명클래스(람다식) 외워야 한다.
        System.out.println("이름-나이-계좌순 정렬2");
        list.sort((o1,o2)->{
            int res=o1.getName().compareTo(o2.getName());
            if(res==0){
                res=Integer.compare(o1.getAge(),o2.getAge());
            }
            if(res==0){
                res=Double.compare(o1.getAccount(),o2.getAccount());
            }
            return res;

        });
        list.forEach(System.out::println);
        System.out.println("--------------------------------------------------------");


        // 3. 스트림을 통해 한줄로 표현
        System.out.println("이름-나이-계좌순 정렬3");
        list.sort(Comparator.comparing(Member::getName).thenComparingInt(Member::getAge).thenComparingDouble(Member::getAccount));
        list.forEach(System.out::println);
        System.out.println("---------------------------------------------------------");



    }
}














































