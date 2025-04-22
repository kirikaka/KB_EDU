package poly3.ex2;

public class AnimalMain {
    public static void main(String[] args) {
        Animal[] animals = {new Dog(),new Cat(),new Duck()};

        for (Animal animal : animals) {
            animalDo(animal);
            System.out.println();
            if(animal instanceof Fly){
                ((Fly) animal).fly();
            }
        }
    }
    public static void animalDo(Animal animal) {
        animal.eat();
        animal.sound();
    }
    public void flyDo(Fly fly) {
        fly.fly();
    }
}
