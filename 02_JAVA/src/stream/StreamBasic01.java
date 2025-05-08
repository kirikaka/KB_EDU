package stream;

import java.util.Arrays;
import java.util.stream.Stream;

public class StreamBasic01 {
    // 스트림(Stream)이란?
    // - 함수형 프로그래밍이 가능한 순수 함수 문법인 람다의 확장 기능으로 우아한 코딩(?)이 가능하다.
    // - 본래 용도는 데이터 분석용도로 개발된 기능으로 다른 분석용 언어에서 지원하는 다양한 기능을 내장화 하였다.
    // - 또한 내부적으로 병렬처리를 지원함으로써 더욱 빠르게 데이터 처리가 가능하다.
    //   -> java에서 유일한 공식적인 병렬처리 방법으로 알고는 있어야한다. (혹시 모를 대용량 병렬처리를 위해)

    // 스트림 병렬처리 : 내부적으로 알고리즘과 Thread를 자동으로 구성하여 병렬처리 가능하다. -> 자동화
    // Thread : 병렬처리가 가능하도록 도구 제공하고 알고리즘은 개발자가 구성 필요 -> 반자동

    // https://docs.oracle.com/javase/8/docs/api/java/util/stream/package-summary.html
    public static void main(String[] args) {
        String[] strArray = {"abc", "bbb", "ccc", "abb", "bcc", "ddd"};
        // allMatch : 스트림의 모든 객체가 조건에 매칭되는지 확인하는 기능
        // anyMatch : 스트림의 특정 객체가 조건에 매칭되는지 확인하는 기능
        // noneMatch : allMatch 반대, 스트림의 모든 객체가 조건에 매칭되지 않는지 확인하는 기능
        System.out.println("a가 포함된 문자열 ");
        System.out.println("allMatch : " + Stream.of(strArray).allMatch((str)-> str.contains("a")));
        System.out.println("anyMatch : " + Stream.of(strArray).anyMatch((str)-> str.contains("a")));
        System.out.println("noneMatch : " + Stream.of(strArray).noneMatch((str)-> str.contains("a")));
        System.out.println("---------------------------------------------");

        String[] strArray2 = {"aaa", "bbb", "bbb", "ccc", "ccc", "ccc"};
        Stream<String[]> strArrStrm2 = Stream.of(
                new String[]{"abc", "bbb", "ccc"},
                new String[]{"ABC", "bbb", "ddd"} );

        // 2차원 스트림을 만드는 가장 기본적인 방법
        Stream<Stream<String>> strStream2 = strArrStrm2.map(Arrays::stream);

        // flatMap : 2차원을 1차원으로 바꾸는 메소드
        System.out.println("2차원 스트림을 1차원으로 변경");
        Stream<String> strStream3 = strArrStrm2.flatMap(Arrays::stream);
        strStream3.forEach(s -> System.out.print(s + ","));

    }

}
