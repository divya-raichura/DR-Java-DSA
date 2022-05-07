package src.oop.oop_3.revise.revise_2.poly;

public class Main {
    public static void main(String[] args) {
//        Shape o = new Circle(); // in this case, Shape should compulsorily have area
        // area of circle is called, as which will be accessed depends on obj type
        // but if circle doesn't have area then it will call area of Shape

        // But we saw previously that what can be accessed depends on Ref Type class
        // then why is it calling obj type wala area
        // it is not contradiction. It actually requires the Ref type to have area
        // What can be accessed depends on Ref Type but what will be accessed depends
        // on the Obj Type
//        o.area();

//        Circle b = new Circle(); // not necessary to have area in Shape
//         circle doesn't have area then area of Shape is called
//        b.area();
    }
}
