package lectures.arrays;

import java.util.Arrays;

public class Swap {
    public static void main(String[] args) {
        int[] arr = {2, 34, 5, 14, 6};
        System.out.println(Arrays.toString(arr));
//        System.out.println(Arrays.toString(arr));
//        swap(arr, 0, 4);
//        System.out.println(Arrays.toString(arr));

//        masti(arr, 0, 4);
//        System.out.println(Arrays.toString(arr));

        reverse(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void reverse(int[] arr) {
        int start = 0;
        int end = arr.length-1; // cause if array length is 5 then last index is 4
        while(start < end) {
            // swap
            swap(arr, start, end);
            start++;
            end--;
        }
    }

    static void swap(int[] arry, int index1, int index2){
        int temp = arry[index1];
        arry[index1] = arry[index2];
        arry[index2] = temp;
    }

//    static void masti( int [] arrmasti, int index1, int index2){
//        arrmasti[index1] = index2; // with this, index 1 , ie 0 has element 2, will change to index 2 ka number 4
//        arrmasti[index2] = index1; // with this, arr ka 4th index jo 6 hai, woh element hi change hoke index1 me jo number h i.e 0 usme change hojayega
        // toh idar swap ya aisa kuch nahi horaha hai just elements change hora hai
//    }
}
