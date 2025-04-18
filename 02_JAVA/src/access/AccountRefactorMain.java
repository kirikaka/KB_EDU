package access;

public class AccountRefactorMain {
    public static void main(String[] args) {
        AccountRefactor account =new AccountRefactor(1000,"국민은행","VIP","안태현");

        System.out.println("Public 접근 제어자 확인");
        System.out.println("은행명은 :"+account.bank);

        System.out.println("default 접근 제어자 확인");
        System.out.println("계급은 :"+account.grade);

//        System.out.println("private 접근 제어자 확인");
//        System.out.println("이름 :"+account.name);
//        System.out.println("잔고는 :"+account.total);
    }
}
