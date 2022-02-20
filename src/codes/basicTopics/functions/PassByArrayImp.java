package lectures.functions;

import java.util.Arrays;

// https://www.scaler.com/topics/pass-by-value-and-call-by-reference-in-java/

public class PassByArrayImp {
    public static void main(String[] args) {
        int[] arr = {99, 55, 44, 332, 2212};
        System.out.println(Arrays.toString(arr));
        main(arr);
//        main2(arr);
        System.out.println(Arrays.toString(arr));
    }

    // a reference to the og arr is passed, we can modify it
    // but if we try to make new obj and then change it, then og
    // obj will not make those changes



    //The called method will be able to modify the original object but
    // not replace it with another object.
    static void main(int[] arr) {
        arr = new int[2];
        arr[1] = 3;
    }

    static void main2(int[] arr) {
        arr[1] = 3;
    }

}
