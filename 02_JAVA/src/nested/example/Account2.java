package nested.example;

public class Account2 {
    private String owner;
    private int balance;

    public Account2(String owner, int balance) {
        this.owner = owner;
        this.balance = balance;
    }

    public void deposit(int amount) {
        balance += amount;
        Transaction transaction = new Transaction("입금", amount);
        transaction.print(balance);
    }

    public void withdraw(int amount) {
        if (balance < amount) {
            System.out.println("잔액 부족");
            return;
        }

        balance -= amount;
        Transaction transaction = new Transaction("출금", amount);
        transaction.print(balance);
    }
}
