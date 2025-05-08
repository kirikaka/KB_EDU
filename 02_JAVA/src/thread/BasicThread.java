package thread;

public class BasicThread {
    public static int second=0;

    public static void main(String[] args) {
        //Main Thread 구간 : 메인이 실행되는 쓰레드. 프로그램 분기가 시작되는 곳
        while(true){
            try{
                second++;
                System.out.println(second + "초 입니다.");

                //Sleep :
                // Sleep을 주면 Thread가 지정한 시간까지 잠시 멈춤
                // -> 실제 현업에서 네트워크/파일나 입출력을 수행시 잠시 멈추지 않으면 데이터전송/읽기쓰기 되지 않을때가 있다.
                //  (이유 : 다른 thread가 일할 시간을 안주거나 상대방의 응답시간을 고려하지 않은 경우)
                //    이럴때 sleep을 주면 해결되는 경우가 있다.
                Thread.sleep(1000);
                //   nano second 옵션도 존재! -> 아주 적게 줄때 가능
                Thread.sleep(1000);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
