package src.oop.codes.oop_6.generics;

import java.util.ArrayList;
import java.util.List;


// here T can be
public class Wildcard<T extends Number> {
    // https://docs.oracle.com/javase/tutorial/java/generics/upperBounded.html

    // but when you do
    // Wildcard<HERE> obj = new Wildcard<>(); ==> HERE can only be anything class under Numbers
    // not something like String

    public void getList(List<? extends Number> list) {
        // if we do, List<Number> list then we can only pass Number here
        // with List<? extends Number> list we can also pass subclasses of Number like Integer, Float etc
    }
    public static void main(String[] args) {
    }
}
