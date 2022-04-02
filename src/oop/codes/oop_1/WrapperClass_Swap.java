package src.codes.oop.codes.oop_1;

public class WrapperClass_Swap {
    public static void main(String[] args) {
        int a = 19;
        int b = 10;
        swap(a, b);
//        System.out.println(a + " " + b); // it does not swap cause we know
        // that java is pass by value and in case of primitives, copy is
        // passed, ie both variables point to different values
        // so in the function, a and b are different and here in main
        // a and b are different
        Integer c = 12;
        Integer d = 3;
        swapClass(c, d);
        System.out.println(c + " " + d);
// it still doesn't swap though we know that wrapper class means object
        // and in case of object a reference is passed and both point to
        // same value though it doesn't swap
        // cause if we see Integer class, we see a 'final' keyword
    }

    static void swapClass(Integer a, Integer b) {
        Integer temp = a;
        a = b;
        b = temp;
    }


    static void finalKeyword() {
        /*
        using final we can make our content to be constant, and we can
        prevent it to be modified
        CONVENTION: If something is constant, we write it in CAPITALS
        eg :-
         */
        final int INCREASE = 2; // this means that now INCREASE can't be
        // modified

        // final declare kiya toh we need to compulsorily initialize it
        // can't do something like "final int INCREASE;"
        // because you can't modify/change it so we need to always initialize it while declaring
        // this immutablity that you can't change the value holds true only for primitve data type
        // if it is not primitive, ie its object then you can modify the values inside
        // object but  you can't change the reference, you can't reassign it
/*
final A kunal = new A("Kunal Kushwaha");
        kunal.name = "other name";

 // when a non primitive is final, you cannot reassign it.
 // kunal = new A("new object");
 */

    }

    static void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
    }

}
