package src.oop.codes.oop_5.abstract_;

public class Main {
    public static void main(String[] args) {
        Son son = new Son(25);
//        son.career();
        Daughter daughter = new Daughter(30);
//        daughter.career();



        // we were able to make a constructor in the abstract class so
        // let's see if we can create objects of abstract class
//        Parent mom = new Parent(); // no we can't create obj of abstract class
        // that is, abstract class cannot be instantiated as written in notes(javatpoint)

        // WHY?
        // see notes, in brief, we can't call abstract methods, as they don't have
        // body, so can't create objects, because those classes are not complete

        // we can make normal and static methods in abstract classes as well
        // static :- as it depends on class, no object needed
        Parent.hey();

        // normal method:- tho we don't have objects of abstract classes
        // so we cannot call such methods directly but we can call them using
        // inheritance ie child.method() using this, it will see is method in child?
        // no? then call from parent if it is in parent, as child extends parent,
        // it has access to all of it's properties
        // we can also override the normal methods like we can do in normal classes
        daughter.hello();

        // with overriding the normal method
        // both these above and below points are same as normal classes
        son.hi();

        // abstract classes can obviously not be final
        // using super() in child, we can access constructors in parent
        // this is a way to initialize vars in parent class, as we cannot
        // create objects of parent and initialize those values by passing it
        // in args of constructor
    }
}
