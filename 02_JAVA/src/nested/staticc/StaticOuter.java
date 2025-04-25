package nested.staticc;

public class StaticOuter {
    private static String outerStatic="outerStatic";
    private String outerInstance="outerInstance";

    static class Nested{
        private static String nestedStatic="nestedStatic";
        private String nestedInstance="nestedInstance";

        public void print(){
            // 클래스 내부 static 값 접근
            System.out.println("nestedStatic = "  +nestedStatic);
            System.out.println("outerStatic = "+outerStatic);

            // 클래스 내부의 non-static 접근
            System.out.println("NestedInstance = "+nestedInstance);
//            System.out.println("OuterInstance = "+outerInstance);
        }
    }



}
