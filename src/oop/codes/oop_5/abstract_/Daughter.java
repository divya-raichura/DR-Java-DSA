package src.oop.codes.oop_5.abstract_;

public class Daughter extends Parent {
//    public Daughter(int age) {
//        this.age = age; //super.age
//    }

    // calling age using super()


    public Daughter(int age) {
        super(age);
    }

    @Override
    void career() {
        System.out.println("I want to be a doctor");
    }

}
