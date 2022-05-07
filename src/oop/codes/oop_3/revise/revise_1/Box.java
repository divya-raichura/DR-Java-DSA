package src.oop.oop_3.revise.revise_1;

public class Box {
    double l;
    double b;
    double h;

    Box() {
        this.l =  -1;
        this.b =  -1;
        this.h =  -1;
    }

    Box(double l, double b, double h) {
        this.l =  l;
        this.b =  b;
        this.h =  h;
    }

    Box(double l, double b) {
        this.l = l;
        this.b = b;
    }

    Box(double side) {
        this.l = side;
        this.b = side;
        this.h = side;
    }

    Box(Box old) {
        this.l = old.l;
        this.b = old.b;
        this.h = old.h;
    }
}
