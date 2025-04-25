package nested.example;

public class WithoutNestedAccountMain {
    public static void main(String[] args) {
        Account2 account2 = new Account2("이효석", 1000);

        account2.deposit(500);
        account2.withdraw(1000);
        account2.withdraw(1000);
    }
}