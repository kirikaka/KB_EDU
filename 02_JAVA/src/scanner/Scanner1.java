package scanner;

import java.util.Scanner;

public class Scanner1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.print("enter a string : " );
        String str=sc.nextLine();
        System.out.println("String is : "+str);


        System.out.print("enter a number : "  );
        int num=sc.nextInt();
        System.out.println("number is : " + num);

    }
}
