package poly4.ex1;

import java.util.Scanner;

public class Driver {
    private Car car;
    Scanner sc = new Scanner(System.in);


    public void setCar(Car car) {
        this.car = car;
    }
    public void selectCar(){
        System.out.print("운전하고 싶은 차를 선택하세요. (1. K5 / 2.그랜저) : ");
        int choice = sc.nextInt();
        if(choice == 1){
            this.setCar(new K5Car());
        } else if(choice == 2){
            this.setCar(new GrandeurCar());
        }

        drive();
    }

    public void drive(){
        car.drive();
    }
}
