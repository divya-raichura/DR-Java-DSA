package com.company.questions;

import java.util.HashMap;
import java.util.Scanner;

public class MaxContiSeq {
    public static void main(String[] args) {
        HashMap<Integer, Boolean> map = new HashMap<>();

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        for (int val : arr) {
            map.put(val, true);
        }

        for (int val : arr) {
            if (map.containsKey(val - 1)) {
                map.put(val, false);
            }
        }

        // complexity?
        int maxL = Integer.MIN_VALUE;
        int msp = Integer.MIN_VALUE;
        for (int val : arr) {
            if (map.get(val)) {
                int l = 1;
                while (map.containsKey(val + l)) {
                    l++;
                }
                if (l > maxL) {
                    msp = val;
                    maxL = l;
                } // Math.max doesn't seem to work
                // cause, we use math max on max l, ok we got max L
                // but in next line even if max L series is  2 3 4 5 (max L = 4)
                // another series which is smaller but has less length will be selected eg 6 8
                // so max L is 4 but starting point is 6 which is wrong, it should be 2
            }
        }
        for (int i = 0; i < maxL; i++) {
            System.out.println(msp + i);
        }
    }
}
