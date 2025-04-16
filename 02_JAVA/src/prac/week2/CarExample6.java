package prac.week2;

public class CarExample6 {
    public static void main(String[] args) {
        Car6 myCar = new Car6();

        myCar.setSpeed(-50);
        System.out.println("현재 속도 :"+myCar.getSpeed());
        myCar.setSpeed(60);
        System.out.println("현재 속도 :"+myCar.getSpeed());
        myCar.setStop(true);
        System.out.println("현재 속도 :"+myCar.getSpeed());

    }
}
