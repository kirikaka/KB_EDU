package generic.method;

public class GenericMethod {
    public static <T> T genericMethod(T t){
        System.out.println("Generic Method : "+ t);
        return t;
    }
}
