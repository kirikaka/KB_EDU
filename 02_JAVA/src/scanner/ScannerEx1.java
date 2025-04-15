package scanner;

import java.util.Scanner;

public class ScannerEx1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.print("시작 정수 입력 : " );
        int num1=sc.nextInt();

        System.out.print("종료 정수 입력 : "  );
        int num2=sc.nextInt();

        int sum=0;
        if(num1>num2){
            System.out.println("시작이 종료보다 큽니다!");
            return;
        }
        for(int i=num1;i<=num2;i++){
            sum=sum+i;
        }
        System.out.println("시작부터 종료 합은 "+sum);



    }

}
