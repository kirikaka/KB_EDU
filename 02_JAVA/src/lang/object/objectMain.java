package lang.object;

public class objectMain {
    public static void main(String[] args) {

        Child child = new Child();
        child.childMethod();
        child.parentMethod();

        System.out.println(child.toString());
        System.out.println(Integer.toHexString(child.hashCode()));
    }
}
