package poly3.ex2;

public class Duck implements Animal,Fly {
    @Override
    public void eat() {
        System.out.println("Duck EAT");
    }

    @Override
    public void sound() {
        System.out.println("QuackQuack");
    }

    @Override
    public void fly() {
        System.out.println("오리 날다. ");
    }
}
