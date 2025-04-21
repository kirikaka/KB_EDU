package poly;

public class AnimalMain {
    public static void main(String[] args) {
        Dog dog = new Dog();
        Donkey donkey = new Donkey();
        Chicken chicken = new Chicken();
        Cat cat = new Cat();

//        dog.sound();
//        donkey.sound();
//        chicken.sound();
//        cat.sound();

        Animal animal = new Animal();
        soundAnimal(animal);
        soundAnimal(dog);
        soundAnimal(donkey);
        soundAnimal(chicken);
        soundAnimal(cat);

        Animal[] animals = {new Dog(), new Donkey(), new Chicken(), new Cat()};

        for (Animal animal1 : animals) {
            soundAnimal(animal1);
        }
    }
    static void soundAnimal(Animal animal) {
        animal.sound();
    }

}
