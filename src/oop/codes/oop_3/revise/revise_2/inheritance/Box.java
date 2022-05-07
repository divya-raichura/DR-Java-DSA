package src.oop.oop_3.revise.revise_2.inheritance;

public class Box {
    double l;
    double b;
    double h;

    public Box() { // need this
        this.l = -1;
        this.b = -1;
        this.h = -1;
    }


    public Box(double l, double b, double h) {
        this.l = l;
        this.b = b;
        this.h = h;
    }

    public Box(double side) {
        this.l = side;
        this.b = side;
        this.h = side;
    }

    public Box(Box old) {
        this.l = old.l;
        this.b = old.b;
        this.h = old.h;
    }
}
