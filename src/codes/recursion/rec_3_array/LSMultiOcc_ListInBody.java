package src.codes.recursion.rec_3_array;

import java.util.ArrayList;

public class LSMultiOcc_ListInBody {
    public static void main(String[] args) {
        int[] arr = {3, 2, 4, 9, 4};
        int target = 4;
        System.out.println(search(arr,target,0));
    }

    static ArrayList<Integer> search(int[] arr, int target, int index) {

        ArrayList<Integer> list = new ArrayList<>();
        if (index == arr.length) {
            return list;
        }
        if (arr[index] == target) {
            list.add(index);
        }
        ArrayList<Integer> ansFromBelowCalls = search(arr, target, index + 1);

        list.addAll(ansFromBelowCalls);

        return list;
    }

}
