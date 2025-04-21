package poly2.casting1.ex;

public class ex1Main {
    public static void main(String[] args) {
        Animal dog=new Dog();
        Animal cat=new Cat();


        dog.eat();
        cat.eat();

        ((Dog) dog).sound();
        ((Cat) cat).sound();
    }
}
