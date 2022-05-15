package src.oop.codes.oop_5.interfaces.extends_;

public class Child implements B{// for interface to class inheritance we
    // use implements keyword

    // when we implement interface which is itself extended from another interface
    // we need to implement all methods in both of them

    // so we need to implement abstract method of B as well as A from which
    // B is inherited
    @Override
    public void fun() {

    }

    @Override
    public void greet() {

    }
}
