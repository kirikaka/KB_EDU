package io;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class StreamIo {
    // Stream이란? - (한방향 빨대다!)
    // - Binary(이진) 데이터를 다루는 Stream = 1byte씩 처리 가능
    // - 활용 : 이미지나 동영상 파일, 네트워크, 프로그램간 데이터 전송 때

    // IO 객체 사용시의 코딩 테크닉 - 고전 ver.
    // 1. 가장 윗단에 IO 객체를 선언하고, null로 초기화한다. 이름은 앞글자를 줄여서 선언한다.
    // 2. try-catch문을 열고, e.printStackTrace 선언 및 finally 문 선언
    // 3. IO 객체를 오픈한다. -> try안에서
    // 4. 필요한 IO을 수행한다. 보통 while문으로 수행
    // 5. finally에 사용한 IO객체'들'을 정리(close)한다.
    // -> ※ try-with-resources문 활용 권장 ★★★★★
    public static void main(String[] args) {
        InputStream in=null;
        OutputStream out=null;
        try{    //고전 테크닉
            //오픈부
            in=System.in;
            out=System.out;

            //동작부
            System.out.println("숫자입력");
            int read = in.read();
            out.write(read);
            // write 강제법
            // flush : write 도중에 데이터 강제로 밀어내는 법
            // close : 자원 정리하며 flush와 동일하게 강제로 데이터 밀어냄
            // 둘은 같은 동작이다. flush가 먼저 실행됨
            out.flush();


        }catch(Exception e){
            e.printStackTrace();
        }finally {
            // close 구현부
            if(in!=null){
                try{
                    in.close();
                } catch(IOException e){

                }
            }
            if(out!=null){
                try{
                    out.close();
                } catch(IOException e){}
            }
        }

    }
}
