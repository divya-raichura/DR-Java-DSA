package src.oop.oop_3.codes.inheritance.extends_super;

public class Imp_super {
    public Imp_super() {
        System.out.println("This is superclass");
    }

    void hello() { // necessary to have this as what can be accessed depends
        // on the ref type and here ref type is parent class
        // what will be accessed depends on obj type, and it is child class
        // so overriding happens and dynamic polymorphism is achieved
        System.out.println("Hello!!!");
    }

    public static void main(String[] args) {
        Imp_super obj = new Child();
        obj.hello();
        // when we do this why is constructor of
        // parent class called? because it goes in the constructor of obj
        // class but try to recollect that in that const we have super()
        // which is on very 1st line of child class cons, hence parent
        // class const gets called first
    }
}

class Child extends Imp_super{
    public Child() {
        System.out.println("This is subclass");
    }

    void hello() {
        System.out.println("Hello!!!");
    }
}