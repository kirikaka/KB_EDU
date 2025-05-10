package io;

import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class StreamRW {
    // reader : 문자열 단위로 읽어오는 기능
    // writer : 문자열 단위로 쓰는 기능
    // java에서 문자열은 2byte를 기준으로 함(unicode 기준)

    // try-with-resources문  ★★★★★★
    // - java 1.7부터 추가된 문법으로 Closeable 객체의 close를 자동으로 해주는 문법
    // - try (open 부) {~~~} catch(e){~~~}로 활용하는데, open부에서 자원생성을 수행해야한다.
    // - ※ 주의 : Closeable 객체만 활용 가능!

    // IO 객체 사용시의 코딩 테크닉 - try-with-resources ver. (java 1.7 이상)
    // 1. try-catch문을 생성한다.
    // 2. try 뒤에 ()를 열고 IO 객체 선언 및 스트림 오픈을 수행한다.
    // 3. 필요한 IO을 수행한다. 보통 while문으로 수행
    //  -> try-with-resources을 사용하면 finally 구현이 필요 없다.
    public static void main(String[] args) {
        try(InputStreamReader isr = new InputStreamReader(System.in);
            OutputStreamWriter osw = new OutputStreamWriter(System.out);
            PrintWriter pw = new PrintWriter(osw);)
        {
//            osw.append("문자열 입력해주세요 \n");
            pw.println("문자열 입력 바람");
            pw.flush(); //버퍼에 있는 내용 출력.

            char[] buf= new char[1024]; //buf 2의 배수로 정하는게 일반
            int size=isr.read(buf);     //1024 byte읽어서 buf 에 저장
            // read: Blocking 함수, 프로그램 동작 멈추고
            // 특정 이벤트 발생하면 다시 프로그램 흐름이 실행되는 함수.

            pw.println("read size : " + size);
            pw.println("입력된 문자열 : " + new String(buf));
            pw.println("입력된 문자열 : " + String.valueOf(buf));
            pw.flush();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
