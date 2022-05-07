package src.oop.oop_3.codes.polymorphism.Overload_TypePromotion;

public class Example {

}

class OverloadingCalculation1 {
    public static void main(String args[]) {
        OverloadingCalculation1 obj = new OverloadingCalculation1();
        obj.sum(20, 20);//now second int literal will be promoted to long
        obj.sum(20, 20, 20);

    }

    void sum(int a, long b) {
        System.out.println(a + b);
    }

    void sum(int a, int b, int c) {
        System.out.println(a + b + c);
    }
}

class OverloadingCalculation2 {
    public static void main(String args[]) {
        OverloadingCalculation2 obj = new OverloadingCalculation2();
        obj.sum(20, 20);//now int arg sum() method gets invoked
    }

    void sum(int a, int b) {
        System.out.println("int arg method invoked");
    }

    void sum(long a, long b) {
        System.out.println("long arg method invoked");
    }
}

class OverloadingCalculation3 {
    public static void main(String args[]) {
        OverloadingCalculation3 obj = new OverloadingCalculation3();
//        obj.sum(20, 20);//now ambiguity
    }

    void sum(int a, long b) {
        System.out.println("a method invoked");
    }

    void sum(long a, int b) {
        System.out.println("b method invoked");
    }
}