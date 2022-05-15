package src.oop.codes.oop_3.codes.inheritance.OneClassObj_OtherRef;

import src.oop.codes.oop_5.interfaces.car_.Car;

public class Bmw extends Car {
    int age;

    Bmw() {
        this.age = -1;
    }

    public Bmw(int age) {
//        super(242); // need to compulsorily write this if we don't create empty constructor in the parent class
        // in order to give default values to variables there
        // as when this will be called, in main, it will go to that empty cons in parent class Hello and take default values from there
        this.age = age;
    }

}
