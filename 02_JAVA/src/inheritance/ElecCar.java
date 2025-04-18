package inheritance;

public class ElecCar extends Car{
    @Override
    public void move() {
        System.out.println("Electric car is moving");
    }
    @Override
    public void openDoor() {
        System.out.println("Electric car is opening");
    }



    public void charge(){
        System.out.println("Electric car is charging");
    }
}
