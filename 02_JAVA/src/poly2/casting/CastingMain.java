package poly2.casting;

public class CastingMain {
    public static void main(String[] args) {
        Child child = new Child();


        child.childMethod();
        child.parentMethod();

        Parent parent = new Child();
        parent.parentMethod();
//        parent.childMethod();

        Child poly =(Child) parent;
        poly.childMethod();

        ((Child) parent).childMethod();
    }
}
