package src.oop.codes.oop_3.codes.inheritance.OneClassObj_OtherRef;

import src.oop.codes.oop_5.interfaces.car_.Car;

public class Main {
    public static void main(String[] args) {
        // following is when both classes are parent
        // in that case you can't use one class ref variable and other as object type
//        Car s1 = new Car("DivyaRaichura");
//        System.out.println(s1.name); // prints DivyaRaichura
//        Bmw s1 = new Bmw(18);
//        System.out.println(s1.age); // prints 18

//        Car is parent and Bmw is the child
        // when parent(Car) is given ref and obj is of (child)Bmw
        Car s1 = new Bmw();

    }
}
