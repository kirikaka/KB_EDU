package scanner;

import java.util.Scanner;

public class Scanner3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("문자열 입력바랍니다. 종료를 원하시면 exit 입력 : ");
            String input = sc.nextLine();
            if (input.equals("exit")) {
                System.out.println("프로그램을 종료");
                break;
            }
            System.out.println("입력한 문자열 : "+input);
        }
    }
}
