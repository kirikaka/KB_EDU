package poly3.ex2;

public class Cat implements Animal {
    @Override
    public void eat() {
        System.out.println("cat eat");
    }
    @Override
    public void sound() {
        System.out.println("MEOWMEOW");
    }
}
