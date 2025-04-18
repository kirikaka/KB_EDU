package inheritance;

public class GasCar extends Car{
    @Override
    public void move() {
        System.out.println("Gas car is moving");
    }
    public void openDoor() {
        System.out.println("Gas car is opening");
    }

    public void fillUp(){
        System.out.println("Gas car is filling up");
    }
}
