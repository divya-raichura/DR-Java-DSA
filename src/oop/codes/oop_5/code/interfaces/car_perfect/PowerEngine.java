package src.oop.codes.oop_5.code.interfaces.car_perfect;

public class PowerEngine implements Engine {
    @Override
    public void start() {
        System.out.println("Petrol car starts");
    }

    @Override
    public void stop() {
        System.out.println("Petrol car stops");
    }
}
