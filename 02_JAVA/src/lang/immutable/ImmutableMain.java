package lang.immutable;

public class ImmutableMain {
    public static void main(String[] args) {
        ImmutableUser user1 =new ImmutableUser("태현");
        ImmutableUser user2=user1;

        System.out.println("user1: "+user1);
        System.out.println("user2: "+user2);

        System.out.println("이름 뱐걍");
        System.out.println("user1: "+user1);
        System.out.println("user2: "+user2);


    }
}
