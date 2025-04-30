package generic.method;

public class GenericMethodMain {
    public static void main(String[] args) {
        Integer val= GenericMethod.<Integer>genericMethod(100);
        System.out.println(val);

    }
}
