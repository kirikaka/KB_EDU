package poly3.interfacee;

public class InterfaceAnimalImpl implements InterfaceAnimal {
    @Override
    public void eat() {
        System.out.println("인터페이스 구현체가 밥을 먹어요");
    }

    @Override
    public void sound() {
        System.out.println("인터페이스 구현체가 소리를 낸다. 누구인가?");
    }
}
