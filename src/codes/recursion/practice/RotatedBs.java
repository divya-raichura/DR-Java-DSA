package src.codes.recursion.practice;

public class RotatedBs {
    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 1, 2, 3};
        System.out.println(bs(arr, 7, 0, arr.length - 1));
    }

    static int bs(int[] arr, int target, int s, int e) {
        if (s > e) {
            return -1;
        }
        int m = s + (e - s) / 2;
        if (arr[m] == target) {
            return m;
        }
        if (arr[s] <= arr[m]) {
            if (target <= arr[m] && target >= arr[s]) {
                return bs(arr, target, s, m - 1);
            } else {
                return bs(arr, target, m + 1, e);
            }
        }
        if (target <= arr[e] && target >= arr[m]) {
            return bs(arr, target, m + 1, e);
        } else {
            return bs(arr, target, s, m - 1);
        }

    }

}
