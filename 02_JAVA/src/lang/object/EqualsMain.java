package lang.object;

public class EqualsMain {
    public static void main(String[] args) {
        User user1=new User("안태현","kirikaka");
        User user2=new User("안태현","kirikaka");

        System.out.println(user1==user2);
        System.out.println(user1.equals(user2));
    }
}
