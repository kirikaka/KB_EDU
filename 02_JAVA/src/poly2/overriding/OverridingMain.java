package poly2.overriding;

public class OverridingMain {
    public static void main(String[] args) {
        Parent parent = new Parent();
        System.out.println("Parent Value : "+parent.value);
        parent.method();

        Child child = new Child();
        System.out.println("Child Value : "+child.value);
        child.method();

        Parent poly = new Child();
        System.out.println("Poly Value : "+poly.value);
        poly.method();

    }
}
