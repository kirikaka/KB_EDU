package poly4;

public class KaKaoPay implements Pay{
    @Override
    public void pay(int amount) {
        System.out.println("KaKao시스템과 연계중");
        System.out.println(amount+"원 결제를 시도합니다.");
        System.out.println("결제 성공!");
    }
}
