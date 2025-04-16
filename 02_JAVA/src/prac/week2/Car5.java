package prac.week2;

public class Car5 {
    String model;

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    int speed;

    public Car5(String model) {
        this.model = model;
    }

    void run(){
        int carSpeed=getSpeed();
        System.out.printf("%s가 달립니다.(시속 : %dkm/h)",this.model,carSpeed);
    }

}
