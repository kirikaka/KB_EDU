package poly3.multiple;

public class TaehyunMain2 {
    public static void main(String[] args) {
        Animal[] animals = {new Dog(), new Taehyun()};
        for (Animal animal : animals) {
            animalDo(animal);
            System.out.println();
            if (animal instanceof Human) {
                humanDo((Human) animal);

            }
        }

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
