package poly3.abstractt;

public class Duck extends AbstractAnimal {

    public void sound(){
        System.out.println("오리가 꽥꽥");
    }
    public void fly(){
        System.out.println("오리 날다!");
    }

    @Override
    public void eat() {
        System.out.println("오리가 밥을 먹네");
    }
}
