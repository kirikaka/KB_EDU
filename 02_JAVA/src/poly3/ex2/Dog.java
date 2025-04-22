package poly3.ex2;

public class Dog implements Animal {
    @Override
    public void eat() {
        System.out.println("dog eat");
    }
    @Override
    public void sound() {
        System.out.println("bowwow");
    }
}
