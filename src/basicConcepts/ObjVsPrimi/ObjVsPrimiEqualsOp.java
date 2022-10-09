package topics.ObjVsPrimi;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ObjVsPrimiEqualsOp {
    public static void main(String[] args) {
//        int a = 99;
//        int b = a;
//        System.out.println(a);
//        System.out.println(b);
//        System.out.println(a ==b);
////        b = 1;
//        b += 1;
//        System.out.println(a);
//        System.out.println(b);
//        System.out.println(a ==b);

//        int a = 99;
//        int b = 1;
//        System.out.println("a:" + a);
//        System.out.println("b:" + b);
//        int temp = a;
//        a = b;
//        b = temp;
//        System.out.println("a:" + a);
//        System.out.println("b:" + b);


        // i understood that... note: a and b are ref vars
        // == for primitives only checks if values of a and b are same or not
        // == for objects checks if a and b pointing to same object or not
        // .equals is for objects to only check if values are same...it doesn't check reference

        int[] a = {1, 2, 4};
        int[] b = {1, 2, 4};
        // doing this does not create a and b having same obj ref
//        but if we do this in strings, both string have same obj ref
        // it creates different obj and thus a and b have different obj ref
//        System.out.println(Arrays.equals(a, b)); // checks values, and as values are same gives true
//        System.out.println(a == b); // checks if they have same obj ref // false as they don't have same obj ref
//        doing this creates one obj and both a and b have same obj ref
        b = a;
//        System.out.println(a == b); // now they have same ref
        b[0] = 99;
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
//        String a = "kunal";
//        String b = "kunal";
//        System.out.println(a == b); // true
        // but unlike strings, if we modify b, it won't change a as strings are immutable
//        also...
        String name = "divya";
        // and we change name, then it won't modify it, it will create new obj in heap
        // and then reference of name will be changed to new obj

    }
}
