package nested.local;

public class LocalOuter {
    private String outerInstance = "outerInstance";

    public void outerMethod(String methodParameter) {
        String methodString = "methodString"; // 지역 변수

        class LocalInner {
            String localInstance = "localInstance";

            public void printLocal() {
                System.out.println("outerInstance = " + outerInstance);
                System.out.println("methodString = " + methodString);
                System.out.println("localInstance = " + localInstance);
                System.out.println("parameter = " + methodParameter);
            }
        }

        LocalInner localInner = new LocalInner();
        localInner.printLocal();
    }

    public static void main(String[] args) {
        LocalOuter localOuter = new LocalOuter();
        localOuter.outerMethod("parameter");
    }
}