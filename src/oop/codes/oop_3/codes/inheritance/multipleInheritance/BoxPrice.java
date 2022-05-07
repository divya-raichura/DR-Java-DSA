package src.oop.oop_3.codes.inheritance.multipleInheritance;

public class BoxPrice extends BoxWeight {
    double price;

    BoxPrice() {
//        super(); // this is to call the constructor of just above class, however its not needed
        // cause from debugging, I saw that it automatically calls an empty constructor
        // from above class
        this.price = -1;
    }

    BoxPrice(BoxPrice other) {
        super(other);
//  this.price = other.price; // if we don't do this, it will give default value zero
        // and if we do it, then it will give prev boxPrice value
    }

    public BoxPrice(double l, double b, double h, double weight, double price) {
//        super(l, b, h, weight);
        super(l, b);
        this.price = price;
    }
}
