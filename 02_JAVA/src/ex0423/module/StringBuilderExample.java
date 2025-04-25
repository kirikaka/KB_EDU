package ex0423.module;

public class StringBuilderExample {
    public static void main(String[] args) {
        String data = new StringBuilder()
                .append("DEF")
                .insert(0, "ABC")
                .delete(3, 4)
                .toString();

        // 실행 결과: ABCEF
        System.out.println(data);
        // 실제 결과: ABCEF
    }
}
