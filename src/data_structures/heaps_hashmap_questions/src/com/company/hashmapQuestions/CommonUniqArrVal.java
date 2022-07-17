package com.company.questions;

import java.util.HashMap;
import java.util.Scanner;

public class CommonUniqArrVal {

    public static void main(String[] args) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];
        for (int i = 0; i < n; i++) {
            arr1[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            arr2[i] = in.nextInt();
        }
        for (int val : arr1) {
            if (map.containsKey(val)) {
                int of = map.get(val);
                int nf = of + 1;
                map.put(val, nf);
            } else {
                map.put(val, 1);
            }
        }
        for (int j : arr2) {
            if (map.containsKey(j)) {
                System.out.println(j);
                map.remove(j);
            }
        }
    }
}
