package src.revise;

import java.util.ArrayList;

public class Ls {
    public static void main(String[] args) {
        int[] arr = {2, 235, 54, 1, 4, 5, 5, 6, 1};
        ArrayList<Integer> ans = search(arr, 1, 0, new ArrayList<>());
        ArrayList<Integer> ans2 = search2(arr, 1, 0);
        System.out.println(ans);
        System.out.println(ans2);
    }

    static ArrayList<Integer> search(int[] arr, int target, int index, ArrayList<Integer> list) {

        if (index == arr.length) {
            return list;
        }

        if (arr[index] == target) {
            list.add(index);
        }
        return search(arr, target, index + 1, list);
    }


    static ArrayList<Integer> search2(int[] arr, int target, int index) {
        ArrayList<Integer> list = new ArrayList<>();
        if (index == arr.length) {
            return list;
        }
        if (arr[index] == target) {
            list.add(index);
        }
        ArrayList<Integer> ans = search2(arr, target, index + 1);
//        ans.addAll(list); // will print in reverse
//        return ans;
        list.addAll(ans); // will print in correct order
        return list;
    }
}
