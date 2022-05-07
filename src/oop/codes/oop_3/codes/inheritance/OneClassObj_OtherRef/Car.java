package src.oop.oop_3.codes.inheritance.OneClassObj_OtherRef;

public class Car {
    int name;
    int seats;

    // this constructor is necessary in order to not contain super
    Car() {
        this.name = -1;
        this.seats = -1;
    }

    public Car(int name, int seats) {
        this.name = name;
        this.seats = seats;
    }
}
