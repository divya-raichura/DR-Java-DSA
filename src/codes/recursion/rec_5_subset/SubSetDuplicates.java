package src.codes.recursion.rec_5_subset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SubSetDuplicates {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2};
        List<List<Integer>> list = subSetDup(arr);
//        List<List<Integer>> list = subSetDupLittleUpgrade(arr);
        for (List<Integer> individual : list) {
            System.out.println(individual);
        }
    }

    static List<List<Integer>> subSetDup(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> outer = new ArrayList<>();

        outer.add(new ArrayList<>());
        int start = 0;
        int end = 0;
        for (int i = 0; i < arr.length; i++) {
            start = 0;
            if (i > 0 && arr[i] == arr[i - 1]) {
                start = end + 1;
            }
            end = outer.size() - 1;
            int n = outer.size();
            for (int j = start; j < n; j++) {
                List<Integer> internal = new ArrayList<>(outer.get(j));
                internal.add(arr[i]);
                outer.add(internal);
            }
        }
        return outer;
    }

    static List<List<Integer>> subSetDupLittleUpgrade(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> outer = new ArrayList<>();

        outer.add(new ArrayList<>());
        int start;
        int end = 0;
        for (int i = 0; i < arr.length; i++) {
            start = 0;
            if (i > 0 && arr[i] == arr[i - 1]) {
//                start = end + 1;
                start = end;
            }
            end = outer.size();
//            int n = outer.size();
            for (int j = start; j < end; j++) {
                List<Integer> internal = new ArrayList<>(outer.get(j));
                internal.add(arr[i]);
                outer.add(internal);
            }
        }
        return outer;
    }

}
