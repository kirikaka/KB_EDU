package scanner;

import java.util.Scanner;

public class ScannerEx2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int randNum= (int) (Math.random()*100);
        while(true){
            System.out.print("랜덤 숫자를 입력하세요 : ");
            int num=sc.nextInt();
            if(num==randNum){
                System.out.println("정답입니다. 랜덤 숫자는 "+randNum);
                break;
            }
            if(num<randNum){
                System.out.println("Up");
            }
            if(num>randNum){
                System.out.println("Down");
            }

        }
    }
}
