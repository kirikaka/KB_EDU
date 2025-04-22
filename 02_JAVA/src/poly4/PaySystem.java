package poly4;

import java.util.Scanner;

public class PaySystem {
    private Pay pay;
    Scanner sc = new Scanner(System.in);

    int option;
    int amount;

    static final int KB_PAY=1;
    static final int KAKAO_PAY=2;
    static final int NAVER_PAY=3;

    public void setPay(Pay pay) {
        this.pay = pay;
    }

    public void selectPay(){
        System.out.print("결제 옵션을 입력하세요 (1.KBPay / 2.KaKaoPay / 3.NaverPay) : ");
        option = sc.nextInt();

        if(option == KB_PAY){
            this.setPay(new KBPay());
        } else if(option == KAKAO_PAY){
            this.setPay(new KaKaoPay());
        } else if(option == NAVER_PAY){
            this.setPay(new NaverPay());
        }
    }

    public void selectAmount(){
        System.out.print("결제 금액을 입력하세요 : ");
        amount = sc.nextInt();
        payment(amount);
    }

    public void payment(int amount) {
        System.out.println("결제 시작");
        pay.pay(amount);
    }
}
