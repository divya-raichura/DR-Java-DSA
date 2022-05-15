package src.oop.codes.oop_5.interfaces.car_perfect;

public class Main {
    public static void main(String[] args) {
        Car car = new Car();
        car.startCar();
        car.changeEngine();
        car.startCar();
        car.startMusic();
        car.brake();
        car.stopMusic();
        car.stopCar();
    }
}
