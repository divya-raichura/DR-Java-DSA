package src.oop.codes.oop_5.interfaces.car_;

public interface Engine {

    int PRICE = 10000000; // every var is static and final by default, like
    // this static final int PRICE = 2; hence it must be initialized as it is final

    void start(); // methods are public and abstract by default in interfaces

    void stop();

    void acc();
}
