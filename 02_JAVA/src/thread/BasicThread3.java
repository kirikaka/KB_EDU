package thread;

public class BasicThread3 {
    // Thread 생성법 3가지
    // 1. Thread를 상속 받아서 사용하기 -> 설계가 커지고 복잡할때 사용
    // 2. Thread Runnable Interface를 구현하여 사용하기
    //  2.1 - Class에서 직접 구현하기
    //  2.2 - 익명 Class를 사용하는 방법★ 짧은 쓰레드를 만들때 사용한다.

    // Thread의 생명주기 실험
    // - Main Thread가 죽어도 다른(자식) Thread가 살아 있는 경우 프로그램은 종료되지 않는다.
    // - 만일 Main Thread를 죽이지 않고 다른 Thread의 처리를 기다릴 경우 join을 활용

    // ※ 주의 run 호출하는 것은 그냥 메소드 호출이다. Sub Thread 생성하기 위해선 반드시 start를 사용
    public static int second=0;

    public static void main(String[] args) {


    }

}
