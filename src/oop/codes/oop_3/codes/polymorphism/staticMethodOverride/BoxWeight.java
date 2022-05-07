package src.oop.oop_3.codes.polymorphism.staticMethodOverride;

public class BoxWeight extends Box {
    double weight;

    @Override
    void naya() {
        System.out.println("This is in BoxWeight(child) to try overriding");
    }


    // can't do this error deta hai but what if this is also static
//    void greet() {
//        System.out.println("Hello, I am in BoxWeight(Child) Class.");
//    }


    // can do this, but it does not override
//    @Override // nope
//    static void greet() {
//        System.out.println("Hello, I am in BoxWeight(Child) Class.");
//    }

    public BoxWeight() {
        this.weight = -1;
    }

    public BoxWeight(double l, double b, double h, double weight) {
        super(l, b, h);
        this.weight = weight;
    }


    public BoxWeight(double weight, double h) {
        this.weight = weight;
    }

    public BoxWeight(double l, double b, double h) {
        super(l, b, h);
    }

    BoxWeight(BoxWeight old) {
        super(old);
        this.weight = old.weight;
    }
}
