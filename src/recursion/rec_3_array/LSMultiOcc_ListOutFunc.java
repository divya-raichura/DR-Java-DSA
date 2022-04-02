package src.codes.recursion.rec_3_array;

import java.util.ArrayList;

public class LSMultiOcc_ListOutFunc {
    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 18, 9, 18};
        int target = 18;
        search(arr, target, 0);
        System.out.println(list);
    }


    static ArrayList<Integer> list = new ArrayList<>();

    static void search(int[] arr, int target, int index) {
        if (index == arr.length) {
            return;
        }
        if (arr[index] == target) {
            list.add(index);
        }
        search(arr, target, index + 1);
    }
}
