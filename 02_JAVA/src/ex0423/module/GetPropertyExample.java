package ex0423.module;

import java.util.Properties;
import java.util.Set;

public class GetPropertyExample {
    public static void main(String[] args) {
        // 운영체제 이름
        String osName = System.getProperty("os.name");
        System.out.println("운영체제 이름: " + osName);

        // 로그인 사용자 명
        String userName = System.getProperty("user.name");
        System.out.println("사용자 이름: " + userName);

        // 홈 디렉토리
        String userHome = System.getProperty("user.home");
        System.out.println("홈 디렉토리: " + userHome);

        // 시스템 속성 정보
        System.out.println("key: \t\tvalue");

        Properties props = System.getProperties();
        Set keys = props.keySet();

        for(Object objKey : keys) {
            String key = (String) objKey;
            String value = System.getProperty(key);
            System.out.println(key + ": \t\t" + value);
        }
    }
}
