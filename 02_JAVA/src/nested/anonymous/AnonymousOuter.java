package nested.anonymous;

public class AnonymousOuter {
    private String outerInstance="outerInstance";

    public void outerMethod(){
        String methodString="methodString";

//        class LocalInner implements Print{
//            @Override
//            public void printLocal() {
//                System.out.println(outerInstance);
//                System.out.println(methodString);
//            }
//        }
//        LocalInner localInner=new LocalInner();
//        localInner.printLocal();

        Print print = new Print() {
            @Override
            public void printLocal() {
                System.out.println(outerInstance);
                System.out.println(methodString);
            }
        };
        print.printLocal();
    }

    public static void main(String[] args) {
        AnonymousOuter anonymousOuter=new AnonymousOuter();
        anonymousOuter.outerMethod();
    }
}
