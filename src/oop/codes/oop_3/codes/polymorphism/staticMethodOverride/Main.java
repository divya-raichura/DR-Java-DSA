package src.oop.oop_3.codes.polymorphism.staticMethodOverride;

public class Main {
    public static void main(String[] args) {
//        Box.greet();
//        Box box1 = new Box(); // Hello, I am in Box(parent) Class.
//        BoxWeight box2 = new BoxWeight(); // Hello, I am in BoxWeight(Child) Class.
//        Box box3 = new BoxWeight(); // Hello, I am in Box(parent) Class.
//        box1.greet();
//        box2.greet();
//        box3.greet(); // does not override


    }

    void hello1() {
        System.out.println("hello this is non static");
        hello2();
    }

    static void hello2() {
        System.out.println("this is static");
        // hello1(); // not possible
    }
}
