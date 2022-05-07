package src.recursion.rec_5_subset;

import src.oop.oop_2.codes.nayaPackage.A;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Try {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
//        int t = in.nextInt();
//        while (t-- > 0) {
//            int n = in.nextInt();
//            int[] arr = new int[n];
//            for (int i = 0; i < arr.length; i++) {
//                arr[i] = in.nextInt();
//            }
//            subset(arr);
//        }
        // for 2nd q: https://www.codechef.com/problems/CHEFCODE
        int n = in.nextInt();
        int k = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = in.nextInt();
        }
        subset(arr, 4);
    }

    static void subset(int[] arr, int k) {
        List<List<Integer>> outer = new ArrayList<>();

        outer.add(new ArrayList<>());

        for (int num : arr) {
            int n = outer.size();
            for (int i = 0; i < n; i++) {

                List<Integer> internal = new ArrayList<>(outer.get(i));

                internal.add(num);
                outer.add(internal);
            }
        }
//        System.out.println(outer);
        int count = 0;
        for (List<Integer> list : outer) {
            boolean checked = true;
            if (list.size() == 0) {
                continue;
            }
            int pro = 1;
            for (Integer integer : list) {
                int product = pro * integer;
                if (product > k) {
                    checked = false;
                    break;
                } else {
                    pro = product;
                }
            }
            if (checked) {
                count += 1;
            }
        }
        System.out.println(count);
    }






    static void subsetAns(int[] arr) {
        int sumEven = 0;
        int sumOdd = 0;
        int ans;
        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0)
            {
                sumEven += arr[i];
            }
            else
            {
                sumOdd += arr[i];
            }
        }
        ans = Math.max(sumOdd, sumEven);
        System.out.println(ans);
    }


    static void subsetWrong(int[] arr) {
        List<Integer> arrInList = new ArrayList<>();
        for (int num : arr) {
            arrInList.add(num);
        }
        List<List<Integer>> outside = new ArrayList<>();
        outside.add(new ArrayList<>());
        for (int num : arr) {
            int n = outside.size();
            for (int i = 0; i < n; i++) {
                List<Integer> inside = new ArrayList<>(outside.get(i));
                inside.add(num);
                outside.add(inside);
            }
        }
//        System.out.println(outside);
        List<List<Integer>> ans = new ArrayList<>();
        for (List<Integer> list : outside) {
            boolean checked = false;
            if (list.size() == 0) {
                continue;
            }
            if (list.size() == 1) {
                ans.add(list);
            } else {
                int c = 0;
                for (int i = 0; i < list.size() - 1; i++) {

                    int firstOg = arrInList.indexOf(list.get(i));
                    int secondOg = arrInList.indexOf(list.get(i + 1));
                    if (secondOg - firstOg != 2) {
                        break;
                    } else {
                        c += 1;
                    }

                }
                if (c == list.size() - 1) {
                    ans.add(list);
                }
            }
        }
//        System.out.println(ans);

//        int max = Integer.MIN_VALUE;
//        for (List<Integer> sum : ans) {
//            int add = 0;
//            for (int num : sum) {
//                add += num;
//            }
//            if (add > max) {
//                max = add;
//            }
//        }
//        System.out.println(max);
    }
}
