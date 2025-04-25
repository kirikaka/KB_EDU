package lang.wrapper;

public class CompareMain {
    public static void main(String[] args) {
//        int a=1;
//        int b=2;
//
//        b.equals(a);

        Integer a=Integer.valueOf(1);
        Integer b=Integer.valueOf(2);
        System.out.println(b.compareTo(a));


        Integer integer1=Integer.valueOf(100);
        Integer integer2=100;

        Long long1=Long.valueOf(100L);
        Long long2=100L;

        int intValue1=integer1.intValue();
        int intValue2=integer2;

        long longValue1=long1.longValue();
        long longValue2=long2;


    }
}
