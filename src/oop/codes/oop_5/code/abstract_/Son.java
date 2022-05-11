package src.oop.codes.oop_5.code.abstract_;

public class Son extends Parent {
//    public Son(int age) {  // we can do like this or we can make a constructor
//        // in the parent class and call it from child using super()
//        this.age = age; //super.age
//    }

    // calling age using super()


    @Override
    void hi() {
        super.hi();
    }

    public Son(int age) {
        super(age);
    }

    @Override
    void career() {
        System.out.println("I want to be a coder");
    }
}
