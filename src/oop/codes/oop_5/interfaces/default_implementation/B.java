package src.oop.codes.oop_5.interfaces.default_implementation;

public interface B {
    void greet();

    // can't put default methods in interfaces inherited cause, it will cause ambiguity same
    // as classes
//    default void fun() {
//        System.out.println("Default method in A");
//    }
}
