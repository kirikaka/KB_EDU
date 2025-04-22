package poly3.ex1;

public class Spanish implements Human{

    @Override
    public void speak() {
        System.out.println("Hola");
    }

    @Override
    public void eat() {
        System.out.println("El espanol come paella");
    }

    @Override
    public void hello() {
        System.out.println("Hola.Actualmente es el ano "+year);
    }
}
