package access;

public class AccountRefactor {
    private int total;
    public String bank;
    String grade;
    private String name;


    public AccountRefactor(int total, String bank, String grade, String name) {
        this.total = total;
        this.bank = bank;
        this.grade = grade;
        this.name = name;
    }


    void deposit(int amount) {
        this.total = this.total + amount;
    }
    void withdraw(int amount) {
        this.total = this.total - amount;
    }

}
