package src.oop.codes.oop_5.code.interfaces.static_in_interface;

public interface A {
    // static methods can't be inherited wkt, cause...
    // inheritance ==> overriding ==> you have to create objects
    // because it is runtime polymorphism and static methods do not
    // depend on object that's why they cannot be inherited

    // so, if we have static methods it means they cannot be...
    // inherited which means they cannot be overridden, it means
    // they must have a body here

    static void fun() { // call via interface name
        System.out.println("hello!");
    }
}
