package nested.staticc;

public class StaticOuterMain {
    public static void main(String[] args) {
        StaticOuter staticOuter = new StaticOuter();
        StaticOuter.Nested nested = new StaticOuter.Nested();

        nested.print();
    }
}
