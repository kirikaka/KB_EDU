package inheritance;

public class HydrogenCar extends Car {
    @Override
    public void openDoor() {
        System.out.println("Hydrogen car is opening");
    }
    public void move(){
        System.out.println("Hydrogen car is moving");
    }

    public void fillHydrogen(){
        System.out.println("수소를 충전 빠라삐리빠라뽀");
    }
}
