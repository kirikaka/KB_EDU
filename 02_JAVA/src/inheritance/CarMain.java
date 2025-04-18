package inheritance;

public class CarMain {
    public static void main(String[] args) {
        ElecCar elecCar = new ElecCar();
        GasCar gasCar = new GasCar();
        HydrogenCar hydrogenCar = new HydrogenCar();

        elecCar.move();
        elecCar.openDoor();
        elecCar.charge();

        gasCar.move();
        gasCar.openDoor();
        gasCar.fillUp();

        hydrogenCar.move();
        hydrogenCar.openDoor();
        hydrogenCar.fillHydrogen();

    }
}
