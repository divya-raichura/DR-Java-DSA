package src.codes.recursion.array_rec_lec2;

public class LinearSearch {
    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 18, 9};
        int target = 18;
        System.out.println(searchIndex(arr,0,target));
        System.out.println(searchIndexFromEnd(arr, arr.length - 1, target));
        System.out.println(findUsingBool(arr,0,target));
    }

    static int searchIndex(int[] arr, int i, int target) {

        if (i == arr.length) { // can't write this if condn below arr[i]==target condn
            return -1; // to do that, u need to do some changes like, i == arr.l -1 then return arr[i] == target ? index : -1;
        }
        if (arr[i] == target) {
            return i;
        }

        return searchIndex(arr, i + 1, target);
    }

    static int searchIndexFromEnd(int[] arr, int i, int target) {

        if (i == -1) {
            return -1;
        }
        if (arr[i] == target) {
            return i;
        }

        return searchIndex(arr, i - 1, target);

    }

    static boolean findUsingBool(int[] arr, int i, int target) {
        if (i == arr.length) {
            return false;
        }
        return arr[i] == target || findUsingBool(arr, i + 1, target);
    }


}
