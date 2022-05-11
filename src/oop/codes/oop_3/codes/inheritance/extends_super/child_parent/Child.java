package src.oop.oop_3.codes.inheritance.extends_super.child_parent;

public class Child extends Parent{
    public Child(int age) {
        // it is like, is age here? no? then call from parent(superclass)
        this.age = age; // super.age to be sure that if age is in this class alsp
        // there it will call age of this class not of parent
    }
}
