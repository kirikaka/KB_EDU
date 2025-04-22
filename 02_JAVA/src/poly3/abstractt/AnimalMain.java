package poly3.abstractt;

public class AnimalMain {
    public static void main(String[] args) {
        AbstractAnimal[] animals = {new Cat(), new Dog(),new Duck()};

        for(AbstractAnimal animal : animals){
            animalCall(animal);
        }

    }
    public static void animalCall(AbstractAnimal animal){
        animal.sound();
        animal.eat();
        if(animal instanceof Duck){
            ((Duck)animal).fly();
        }

    }
}
