//package src.codes.algos.sorting.merge_sort;
//
//import java.util.Arrays;
//
//public class RecursiveMS {
//    public static void main(String[] args) {
//        int[] arr = { 1, 2, 5, 0, -5};
////        int[] arr = {3, 0, -4, 4, 12};
////        System.out.println(Arrays.toString(mergeSort(arr)));
//
//    }
//
//
//
//
//
//    // my try
//    static int[] mergeSort(int[] arr) {
//        if (arr.length == 1) {
//            return arr;
//        }
//        int m = arr.length / 2;
//        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, m));
//        int[] right = mergeSort(Arrays.copyOfRange(arr, m, arr.length));
////        return mergeArrMyTry(left, right);
//        return mergeArr(left, right);
//    }
//
//    static int[] mergeArr(int[] first, int[] second) {
//
//    }
//
//
//    // my try - success, yay!
//    static int[] mergeArrMyTry(int[] first, int[] last) {
//        int i = 0;
//        int j = 0;
//        int[] merge = new int[first.length + last.length];
//        int k = 0;
//        while (first.length > i && last.length > j) {
//            if (first[i] < last[j]) {
//                merge[k] = first[i];
//                i += 1;
//            } else {
//                merge[k] = last[j];
//                j += 1;
//            }
//            k += 1;
//        }
//        if (last.length > j) {
//            for (int l = j; l < last.length; l++) {
//                merge[k] = last[j];
//                j += 1;
//                k += 1;
//            }
//        } else if (first.length > i) {
//            for (int l = i; l < first.length; l++) {
//                merge[k] = first[i];
//                k += 1;
//                i += 1;
//            }
//        }
//        return merge;
//    }
//
//}
