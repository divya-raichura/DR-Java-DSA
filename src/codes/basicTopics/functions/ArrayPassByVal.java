package src.codes.basicTopics.functions;

import java.util.Arrays;

public class ArrayPassByVal {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
//        int[] num = {5, 6, 7, 3, 2};
//        arr = num;
//        System.out.println(Arrays.toString(arr));
//        System.out.println(Arrays.toString(num));
        hello(arr);
        System.out.println(Arrays.toString(arr));

    }

    static void hello(int[] num) {
        int[] dr = {55, 35, 22, 56, 757};
        num = dr;
        System.out.println(Arrays.toString(num));
        System.out.println(Arrays.toString(dr));
    }
}
