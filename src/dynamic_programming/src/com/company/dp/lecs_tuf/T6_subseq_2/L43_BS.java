package com.company.dp.lecs_tuf.T6_subseq_2;

import java.util.ArrayList;

public class L43_BS {
    public static void main(String[] args) {
        int[] arr = {2, 6, 8, 3, 4, 5, 1};
        System.out.println(binarySearch(arr));
    }

    // https://leetcode.com/problems/longest-increasing-subsequence/discuss/1326308/C%2B%2BPython-DP-Binary-Search-BIT-Solutions-Picture-explain-O(NlogN)
    static int binarySearch(int[] arr) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > list.get(list.size() - 1)) {
                list.add(arr[i]);
            } else {
                int start = 0;
                int end = list.size() - 1;
                int target = arr[i];
                while (start <= end) {
                    int mid = end + (start - end) / 2;
                    if (list.get(mid) == target) {
                        start = mid;
                        break;
                    } else if (list.get(mid) > target) {
                        end = mid - 1;
                    } else {
                        start = mid + 1;
                    }
                }
                list.set(start, target);
            }
        }
        return list.size();
    }
}
