package src.oop.codes.oop_5.nestedInterfaces;

public class A {
    // nested interface
    public interface Nested_interface {
        boolean isEven(int n);
    }
}

// what's the difference from normal interface?
// nested interface can be declared as public, private or protected
// but... the top level interface has to be declared as public or default
// only

class B implements A.Nested_interface {
    @Override
    public boolean isEven(int n) {
        return (n & 1) == 0;
    }
}