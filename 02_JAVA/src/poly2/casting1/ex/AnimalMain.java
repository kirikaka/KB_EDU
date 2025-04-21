package poly2.casting1.ex;

public class AnimalMain {
    public static void main(String[] args) {
        Animal[] animals = {new Animal(), new Cat(), new Dog(),new Duck()};

        for(Animal animal : animals){
            animalCall(animal);
        }

    }
    public static void animalCall(Animal animal){
        animal.sound();
        if(animal instanceof Duck){
            ((Duck)animal).fly();
        }

    }
}
