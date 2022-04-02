package src.codes.oop.codes.oop_1;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
//        Student3[] students = new Student3[5];
//        Student3 s1 = new Student3();
//        System.out.println(Arrays.toString(students)); // prints array of elements having value 'null'
//        System.out.println(s1); // prints random value
//        System.out.println(s1.rno);// prints 0
//        System.out.println(s1.name); // prints null
//        System.out.println(s1.marks); // prints 0.0... NOTE: if inside class, we initialize that marks, as marks = 1000; then it will print 1000 but if we change on next line as s1.marks = 99 then it will change to 99 from 1000
//        // primitives have some by default fixed value
//        // but objects are assigned initially as 'null'
//        s1.rno = 13;
//        s1.name = "Divya Raichura";
//        s1.marks = 99.99f;
//        System.out.println(s1.rno);
//        System.out.println(s1.name);
//        System.out.println(s1.marks);
//
        GarbageCollection a;
        for (int i = 0; i < 1000000000; i++) {
            a = new GarbageCollection("Kunal");
        }


    }
}

class Student3 {
    int rno;
    String name;
    float marks;
}

class GarbageCollection {
    String name;

    GarbageCollection(String name) {
        this.name = name;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("object is destroyed");
    }
}