package poly3.multiple;

public class Taehyun implements Animal,Human{
    @Override
    public void eat() {
        System.out.println("또 먹네");
    }

    @Override
    public void sleep() {
        System.out.println("자고 싶다");
    }

    @Override
    public void think() {
        System.out.println("생각 그만~");
    }
}
