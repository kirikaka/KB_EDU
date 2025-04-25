package nested.example;

import java.time.LocalDateTime;

public class Transaction {
    private String type;
    private int amount;
    private LocalDateTime timestamp;

    public Transaction(String type, int amount) {
        this.type = type;
        this.amount = amount;
        this.timestamp = LocalDateTime.now();
    }

    public void print(int balance) {
        System.out.println("[" + timestamp + "] " + type + " - 금액: " + amount + "원, 잔액: " + balance + "원");
    }
}