package poly3.multiple;

public class TaehyunMain {
    public static void main(String[] args) {
        Taehyun th = new Taehyun();
        Dog dog = new Dog();


        animalDo(th);
        animalDo(dog);

        humanDo(th);



    }

    public static void animalDo(Animal animal) {
        System.out.println("Test Animal Function");
        animal.eat();
        animal.sleep();
        System.out.println("Test Animal Function Done");

    }
    public static void humanDo(Human human) {
        System.out.println("Test Human Function");

        human.think();
        System.out.println("Test Human Function Done");
    }
}
