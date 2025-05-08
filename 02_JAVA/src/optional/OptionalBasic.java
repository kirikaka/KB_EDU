package optional;

import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;

public class OptionalBasic {
    // Optional이란?
    // - null 또는 값을 감싸서 NPE(NullPointerException)로부터 부담을 줄이기 위해 등장한 Wrapper 클래스
    // - Optional은 값을 Wrapping하고 Null Check로직은 간소화하여 코드의 가독성을 높인다고 한다.
    //  -> 문제) 실제 사용해 보면 생산성이 떨어진다. 정말 필요한 경우만 사용 권장! 단순 vo나 dto에는 선언할 필요 없다고 생각

    public static void main(String[] args) {
//        String str = "abcde";
        String str = null;

        if(str != null){ // null check
            System.out.println(str.toLowerCase());
        }

        // Optional 선언하기
        Optional<String> optStr = Optional.of("abcde"); // 정상적으로 옵셔널 객체 생성!
//        Optional<String> optStrNull = Optional.of(null); // of일때 null을 넣으면 죽는다!
        Optional<Integer> optInt = Optional.of(100);
        OptionalInt optInt2 = OptionalInt.of(100);
        OptionalDouble optDouble = OptionalDouble.of(100.123);

        // Optional 사용법 -> 그냥 출력하면 안된다!
        System.out.println(optStr); // Optional[abcde]
        System.out.println(optInt); // Optional[100]
        System.out.println(optInt2); // OptionalInt[100]
        System.out.println(optDouble); // OptionalDouble[100.123]

        // get을 통해 호출하는 방법
        System.out.println(optStr.get()); // 인자를 가져오는 방법
        System.out.println(optInt.get()); // 인자를 가져오는 방법
        System.out.println(optInt2.getAsInt()); // 인자를 가져오는 방법
        System.out.println(optDouble.getAsDouble()); // 인자를 가져오는 방법
        System.out.println("---------------------------------------------------------------");

        // Optional 선언법2 ★★★
        // - null이 인자로 들어올수 있는 상황일때는 ofNullable를 활용 -> 선언만 가능!
        Optional<String> optStr2 = Optional.ofNullable("abcde");
        Optional<String> optStr3 = Optional.ofNullable(null);

        // 출력
        System.out.println(optStr2.get());
//        System.out.println(optStr3.get()); // null 일때 get이면 죽는다!

        // null인 인자를 체크하고 가져오는 방법
        // 1. isPresent : null이 아닐때 참
        if(optStr2.isPresent()){
            System.out.println(optStr2.get());
        }
        if(optStr3.isPresent()){
            System.out.println(optStr3.get());
        }
        System.out.println("---------------------------------------------");
        // 2. isEmpty : null 일때 참
        if(!optStr2.isEmpty()) { // !로 쓰면 잘 안보인다!
            System.out.println(optStr2.get());
        }
        if(optStr3.isEmpty() == false) {
            System.out.println(optStr3.get()); // 출력 안됨!
        }
        System.out.println("---------------------------------------------");

        // 3. ofElse : null일때 default 값을 설정하는 방법 ★★★
        System.out.println(optStr3.orElse("null 입니다."));

        // 4. orElseThrow : null 일때 특정 에러를 발생시키는 방법 ★★★★★
        try {
            System.out.println(optStr3.orElseThrow(Exception::new));
        } catch (Exception e) {
            System.out.println("null 에러발생!!");
        }
        System.out.println("--------------------------------------------");

        // filter : 특정값을 필터링할때 사용하는 메소드
        //  -> Predicate : 동사, 필터링할 행위를 표현해야함
        // length이 0인 문자열을 필터링 하는 문법
        String result1 = Optional.of("test").filter(s -> !s.isEmpty()).get();
        System.out.println(result1);

        // length이 0인 문자열을 필터링 하는 문법
        String result2 = Optional.of("").filter(s -> !s.isEmpty()).orElse("빈 문자열");
        System.out.println(result2);
        System.out.println("---------------------------------------------");

        // map : 특정 Function형을 실행시키고 다시 자신을 돌려주는 기능 (단순 사상)
        //   -> Function : 함수를 이미, 이미 만들어진 것도 활용 가능
        int result3 = Optional.of("123").map(Integer::parseInt).get(); // 파싱 한줄로하는법
        int result4 = Optional.of("12345").map(Integer::parseInt).get(); // 파싱 한줄로하는법
        System.out.println(result3);
        System.out.println(result4);
        System.out.println("---------------------------------------------");

        // filter + map
        int result5 = Optional.of("123").filter(x -> !x.isEmpty()).map(Integer::parseInt).get();
        int result6 = Optional.of("").filter(x -> !x.isEmpty()).map(Integer::parseInt).orElse(-1);
        System.out.println(result5);
        System.out.println(result6);


    }


}