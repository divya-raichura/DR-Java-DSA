package src.codes.basicTopics.functions;

import java.util.Arrays;

public class VarArgs {
    public static void main(String[] args) {
        demo("kunal", "modi");
    }
//        fun(2,3,4,5,65,45,11,99,21);
//        multiple(2, 13, "kunal", "modi", "aman");
//        demo(2, 5, 44, 45);

        /*
          if we do demo() and do not write anything inside it in this case, it will
          get confused on which demo to run and will give error
          this is called ambiguity
         */

     static void demo(int ...v) {
         System.out.println(Arrays.toString(v));
    }

    static void demo(String ...v) {
        System.out.println(Arrays.toString(v));
    }


    static void multiple(int a, int b, String ...v) {
//        for normal and variable arguments together
    }

    static void fun(int ...v) {
         System.out.println(Arrays.toString(v));
    }
}
