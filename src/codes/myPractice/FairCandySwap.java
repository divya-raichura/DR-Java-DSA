package myPractice;
// 31 jan 2022
import java.util.Arrays;

// https://leetcode.com/problems/fair-candy-swap/

public class FairCandySwap {
    public static void main(String[] args) {
        int[] a = {2};
        int[] b = {1, 3};
        System.out.println(Arrays.toString(fairCandySwap(a, b)));
    }

    static int[] fairCandySwap(int[] a, int[] b) {
        int[] ans = {-1, -1};

        int sumA = 0;
        int sumB = 0;
        for (int i = 0; i < a.length; i++) {
            sumA += a[i];
        }
        for (int i = 0; i < b.length; i++) {
            sumB += b[i];
        }

        int target = (sumA - sumB) / 2;

//        Arrays.sort(a);
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                if (a[i] == b[j] + target) {
                    ans[0] = a[i];
                    ans[1] = b[j];
                }
            }
        }
        return ans;
    }

}
