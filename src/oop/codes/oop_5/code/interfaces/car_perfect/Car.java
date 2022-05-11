package src.oop.codes.oop_5.code.interfaces.car_perfect;

public class Car {
    private Engine engine;
    private Media media;
    private Brake brake;

    public Car() {
        System.out.println("Petrol Car and Music Media is created by default");
        this.engine = new PowerEngine();
        this.media = new MusicMedia();
        this.brake = new BrakeClass();
    }

    void changeEngine() {
        System.out.println("Engine was changed to Electric!");
        this.engine = new ElectricEngine();
    }

    void startCar() {
        engine.start();
    }

    void stopCar() {
        engine.stop();
    }

    void brake() {
        brake.apply();
    }

    void startMusic() {
        media.starts();
    }

    void stopMusic() {
        media.stops();
    }

}
