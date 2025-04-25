package lang.object;

public class RefMain {
    public static void main(String[] args) {
        User2 user1=new User2("태현");
        User2 user2=user1;

        System.out.println("user1: "+user1);
        System.out.println("user2: "+user2);

        user2.setName("서연");
        System.out.println("이름 뱐걍");
        System.out.println("user1: "+user1);
        System.out.println("user2: "+user2);


    }
}
