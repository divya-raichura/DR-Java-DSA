package com.topics.recursion.array_rec_lec2;

import java.util.ArrayList;

public class LSMultiOcc_ListReturn {
    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 18, 9, 18};
        int target = 18;
        ArrayList<Integer> list = new ArrayList<>();
        System.out.println(search(arr, target, 0, list));

        // or directly : sout(search(arr, target, 0, new ArrayList<>()))

        // or
        /*
        ArrayList<Integer> ans = search(arr, target, 0, new ArrayList<>())
        sout(ans)
         */
    }

    static ArrayList<Integer> search(int[] arr, int target, int index, ArrayList<Integer> list) {

        if (index == arr.length) {
//            list.add(-1);
            return list;
        }
        if (arr[index] == target) {
            list.add(index);
//            return list;
        }

        return search(arr, target, index + 1, list);

    }

}
