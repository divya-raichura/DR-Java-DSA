package src.oop.oop_3.codes.polymorphism.override;


// we did this in weight examples that if ref is parent and the obj is child
// we can access those only which are available in parent
public class A {
    int l = 1;
    int b;
    int h;

    A() {
        System.out.println("empty constructor");
    }

    public A(int l, int b, int h) {
        this.l = l;
        this.b = b;
        this.h = h;
    }

    public static void main(String[] args) {
        A obj = new B(1, 2, 4, 5);
//        System.out.println(obj.price);
// can't access price, but we can initialize it
        A o = new A();
        System.out.println(o.l);
        B o2 = new B();
        System.out.println(o2.l);

    }
}

class B extends A {
    int l = 9;
    int price;

    B() {
        System.out.println("empty constructor");
    }

    B(int l, int b, int h, int price) {
        super(l, b, h);
        this.price = price;
    }
}