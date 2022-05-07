package src.oop.oop_3.codes.polymorphism.understandPoly_;

public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle(); // if this circle class does not have area method in it,
        // then the area method in Shape(parent class) will be called by default
        // but if circle has area method, then that area method will be called
        // similar to toString method, when we do sout(circle),
        // toString method is called, now if our object does not have it, parent class toString will be called
        // and it will print the default value but if we make our own toString and tell it what to print
        // when we do sout(object_ref_var), it will override and call our toString
        circle.area();

//        Shape shapes = new Shape();
//        Square square = new Square();
//        shapes.area(); // I am in Shapes
//        circle.area(); // Area is pi * r * r
//        square.area(); // Area is side * side

//        Shape shape2 = new Square(); // ref type = parent & object type = child
//        shape2.area(); // Area is side * side
//        circle.area(); // if there is no area in circle class, but circle is child of
        // parent Shape, so when it does not find area method in circle, it takes it from
        // parent's class
    }
}
