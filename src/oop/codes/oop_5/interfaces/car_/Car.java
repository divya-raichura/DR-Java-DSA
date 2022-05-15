package src.oop.codes.oop_5.interfaces.car_;

public class Car implements Engine, Brake, Media { // as all methods in interface are
    // abstract by default, we must implement them all, that is, override

    @Override
    public void brake() {
        System.out.println("brake like normal car");
    }

    @Override
    public void start() {  // this is in engine as well as brake, but it doesn't
        // matter since they both don't have body, this is the use of interfaces
        System.out.println("start engine like normal car");
    }

    @Override
    public void stop() { // start and stop is in engine and media both
        // now, if we want to stop engine, we don't know what will be stopped
        // engine or media as it overrides both
        System.out.println("Stop engine like normal car");
    }

    @Override
    public void acc() {
        System.out.println("Accelerate like normal car");
    }
}
