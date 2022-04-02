package src.codes.recursion.revise;

public class Pivot {
    public static void main(String[] args) {
//        int[] arr = {4, 5, 6, 7, 1, 2, 3};
        int[] num = {1, 2, 3, 4};
        System.out.println(pivot(num, 0, num.length - 1));
    }

    static int pivot(int[] arr, int start, int end) {
        if (start > end) {
            return -1;
        }
        int mid = start + (end - start) / 2;
        if (end > mid && arr[mid] > arr[mid + 1]) {
            return mid;
        }
        if (start < mid && arr[mid - 1] > arr[mid]) {
            return mid - 1;
        }
        if (arr[start] >= arr[mid]) {
            return pivot(arr, start, mid - 1);
        }
        return pivot(arr, mid + 1, end);
    }

}
