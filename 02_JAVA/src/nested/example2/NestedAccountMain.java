package nested.example2;

public class NestedAccountMain {
    public static void main(String[] args) {
        Account account = new Account("이효석", 1000);
        Account account2 = new Account("안태현", 100000000);
        Account.AccountInfomation accountInner = account2.new AccountInfomation();


        Account.StaticAccountStatus.showStatus();

        accountInner.showStatus();
    }
}