package file;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FilesBasic {
    // Files 클래스
    // - file을 관리하기 위한 기능성 클래스로 경로 복사 및 file을 다루는 간단한 방법 제공
    // - 내부적으로는 NIO를 사용하기 때문에 성능이 보장되어 있음
    // - 대부분 static method로 구현되어 있어 활용 편리함
    // - java8 이후에 함수형 프로그래밍 관련 메서드가 추가되어있어 활용이 굉장히 편해짐!

    public static void main(String[] args) {
        // 파일 찾기
        try {
            System.out.println(".txt 파일 찾기");
            Files.find(new File("./05_IO").toPath(), 10, (path, basicFileAttributes) -> path.toString().endsWith(".txt")).forEach(System.out::println);
            System.out.println("----------------------------");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // 파일 삭제 및 파일 복사
        try {
            Files.deleteIfExists(new File("./05_IO/copy_covid.txt").toPath());
            Path path = Files.copy(new File("./05_IO/covid.txt").toPath(), new File("./05_IO/copy_covid.txt").toPath());
            System.out.println("복사 된 경로 : " + path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // 파일의 내용을 출력
        try {
            Files.lines(new File("./05_IO/copy_covid.txt").toPath()).forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

