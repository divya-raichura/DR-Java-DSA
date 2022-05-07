package src.oop.oop_3.codes.polymorphism.staticMethodOverride;

// base class (parent class)
public class Box {
    double l;
    double b;
    double h;

    void naya() {
        System.out.println("This is in Box and to try overriding");
    }

    static void greet() {
        System.out.println("Hello, I am in Box(parent) Class.");
    }

    Box() {
        this.l = -1;
        this.b = -1;
        this.h = -1;
    }

    // cube
    Box(double side) {
        this.l = side;
        this.b = side;
        this.h = side;
    }

    Box(double l, double b, double h) {
        this.l = l;
        this.b = b;
        this.h = h;
    }

    Box(Box old) {
        this.l = old.l;
        this.b = old.b;
        this.h = old.h;
    }
}
