package nested.example2;

import java.time.LocalDateTime;

public class Account {
    private String owner;
    private int balance;
    static private int count=0; // 계좌에 대한 개수 정보

    public Account(String owner, int balance) {
        this.owner = owner;
        this.balance = balance;

        count++;
        StaticAccountStatus.lastOpenner=owner;
        AccountInfomation.lastOpenner=owner;
    }


    public static class StaticAccountStatus{
        static private String lastOpenner;   //마지막 계좌 개설자

        public static void showStatus(){
            System.out.println("현재 해당 상품은 총 "+count+"만큼 개설 되었습니다.");
            System.out.println("마지막 계좌 개설자는 : "+lastOpenner);
        }
    }

    class AccountInfomation{
        static private String lastOpenner;

        public void showStatus(){
            showStatus1();
        }

        private void showStatus1(){
            System.out.println("현재 해당 상품은 총 "+count+"만큼 개설 되었습니다.");
            System.out.println("마지막 계좌 개설자는 : "+lastOpenner);
            System.out.println("해당 계좌의 소유주는 "+lastOpenner+"이고, 잔고는 "+balance+" 입니다.");

        }


    }





    private class Transaction {
        private String type;
        private int amount;
        private LocalDateTime timestamp;

        public Transaction(String type, int amount) {
            this.type = type;
            this.amount = amount;
            this.timestamp = LocalDateTime.now();
        }

        public void print() {
            System.out.println("[" + timestamp + "] " + type + " - 금액: " + amount + "원, 잔액: " + balance + "원");
        }
    }

    public void deposit(int amount) {
        balance += amount;
        Transaction transaction = new Transaction("입금", amount);
        transaction.print();
    }

    public void withdraw(int amount) {
        if (balance < amount) {
            System.out.println("잔액 부족");
            return;
        }

        balance -= amount;
        Transaction transaction = new Transaction("출금", amount);
        transaction.print();
    }
}
