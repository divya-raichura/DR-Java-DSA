package src.oop.codes.oop_5.code.interfaces.car_perfect;

public class ElectricEngine implements Engine {

    @Override
    public void start() {
        System.out.println("Electric car starts");
    }

    @Override
    public void stop() {
        System.out.println("Electric car stops");
    }
}
