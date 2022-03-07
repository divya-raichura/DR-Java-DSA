package src.codes.recursion.practice;

public class LS {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 5, 63, 67, 8, 10, 9};
        int target = 41;
        System.out.println(search(arr, target, 0));
    }

    static int search(int[] arr, int target, int i) {

        if (i == arr.length) {
            return -1;
        }

        if (arr[i] == target) {
            return i;
        }
        return search(arr, target, i + 1);
    }

}
