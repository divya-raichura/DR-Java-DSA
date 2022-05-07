package src.oop.oop_3.revise.revise_1;

public class BoxW extends Box{
    double weight;

    BoxW() {
        this.weight = -1;
        this.b = 9;
        this.h = 9;
        this.l = 9;
    }


    BoxW(BoxW old) {
        super(old);
        this.weight = old.weight;
    }

    public BoxW(double weight) {
        this.weight = weight;
    }

    public BoxW(double l, double b, double weight) {
        super(l, b);
        this.weight = weight;
    }

    public BoxW(double l, double b, double h, double weight) {
        super(l, b, h);
        this.weight = weight;
    }

    public BoxW(double side, double weight) {
        super(side);
        this.weight = weight;
    }

    public BoxW(BoxW old, double weight) {
        super(old);
        this.weight = weight;
    }
}
