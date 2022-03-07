package src.codes.recursion.practice;

import java.util.ArrayList;
import java.util.List;

public class LsMulti {
    public static void main(String[] args) {
        int[] arr = {12, 3, 4, 5, 4, 7};
        int target = 4;
//        ArrayList<Integer> list = new ArrayList<>();
//        System.out.println(ls(arr, target, 0, list));
        System.out.println(bodyList(arr, target, 0));

    }


    static ArrayList<Integer> bodyList(int[] arr, int target, int index) {
        ArrayList<Integer> arrList = new ArrayList<>();
        if (arr.length == index) {
            return arrList;
        }
        if (arr[index] == target) {
            arrList.add(index);
        }
        ArrayList<Integer> list = bodyList(arr, target, index + 1);
        arrList.addAll(list);
        return arrList;
    }

    static ArrayList<Integer> ls(int[] arr, int target, int index, ArrayList<Integer> list) {
        if (index == arr.length) {
            return list;
        }
        if (arr[index] == target) {
            list.add(index);
        }
        return ls(arr, target, index + 1, list);
    }

}
