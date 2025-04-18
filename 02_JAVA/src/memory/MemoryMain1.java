package memory;

import java.util.Scanner;

public class MemoryMain1 {
    public static void main(String[] args) {
        System.out.println("메인 메서드 시작");
        method1();
        System.out.println("메인 메서드 종료");
    }
    static void method1(){
        System.out.println("메서드1 수행 시작");
        Data data1 = new Data(10);
        method2(data1);
        System.out.println("메서드1 수행 종료");
    }
    static void method2(Data data){
        System.out.println("메서드 2 수행 시작");
        System.out.println("data의 value 값은? "+data.getValue());
        System.out.println("메서드 2 수행 종료");
    }

}
