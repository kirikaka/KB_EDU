package poly4.ex1;

import java.util.Scanner;

public class GrandeurCar implements Car {
    int fuel;
    static final int EFFICIENCY=2;
    Scanner sc = new Scanner(System.in);

    @Override
    public void fillFuel() {
        System.out.print("주유할 기름의 양을 입력하세요 : ");
        fuel = sc.nextInt();
    }

    @Override
    public void openDoor() {
        System.out.println("그랜저 차 문을 엽니다.");
    }

    @Override
    public void drive() {
        fillFuel();
        openDoor();
        System.out.println("그랜저가 주행을 시작합니다");
        System.out.println("그랜저가 총 "+fuel/EFFICIENCY +"km만큼 달렸습니다.");
        System.out.println("그랜저 주행종료");

    }
}
