package variable;

public class String1 {
    public static void main(String[] args) {
        String str1 = "abc";
        String str2 = "def";

        System.out.println("abc"=="abc");
        System.out.println("abc"=="def");
        System.out.println("abc"==new String("abc"));
    }
}
