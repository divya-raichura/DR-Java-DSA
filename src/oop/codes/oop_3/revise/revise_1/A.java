package src.oop.oop_3.revise.revise_1;



// to try that does every constructor auto calls super or not and yes it calls
// empty constructor (super) if we don't create manually
public class A {
    String name;
//    public A() {
//        System.out.println("inside empty constructor of superclass");
//    }
//
//    public A(String name) {
//        this.name = name;
//        System.out.println(this.name);
//        System.out.println("name wale constructor ke andar swagat hai");
//    }

    public static void main(String[] args) {
        B obj = new B(52);
    }
}

class B extends A {
    int n;

    public B(int n) {
//        super("divya");
        this.n = n;
        System.out.println(this.n);
    }
}
