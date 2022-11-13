package com.company.questions;

import java.util.HashMap;
import java.util.Scanner;

public class PrintCommon {
    public static void main(String[] args) {
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
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int val : arr1) {
            if (map.containsKey(val)) {
                int of = map.get(val);
                int nf = of + 1;
                map.put(val, nf);
            } else {
                map.put(val, 1);
            }
        }

        for (int val : arr2) {
            if (map.containsKey(val) && map.get(val) > 0) {
                System.out.println(val);
                int of = map.get(val);
                int nf = of - 1;
                map.put(val, nf);
            }
        }
    }
}
