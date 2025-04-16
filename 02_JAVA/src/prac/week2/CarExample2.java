package prac.week2;

public class CarExample2 {
    public static void main(String[] args) {
        Car2 car1=new Car2();
        System.out.println(car1.company);

        Car2 car2=new Car2("자가용");
        System.out.println(car2.company);
        System.out.println(car2.model);

        Car2 car3=new Car2("자가용","빨강");
        System.out.println(car3.company);
        System.out.println(car3.model);
        System.out.println(car3.color);

        Car2 car4=new Car2("택시","검정",200);
        System.out.println(car4.company);
        System.out.println(car4.model);
        System.out.println(car4.color);
        System.out.println(car4.maxSpeed);

    }
}
