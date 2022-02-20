package questions.binarysearch;

public class FindPivot {
    public static void main(String[] args) {
//        int[] arr = {15, 18, 2, 3, 6, 12};
//        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7};
        int[] arr = {1};
//        System.out.println(findPivotWithDuplicates(arr));
//        System.out.println("No of times the array was rotated = " + noOfTimesRotated(arr));
        System.out.println(findPivotWithDuplicates(arr));
    }

    static int findPivot(int[] arr) {
        int start = 0;
        int end   = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            // 4 cases here (I wrote those in notes)
            if (end > mid && arr[mid] > arr[mid + 1]) {
                return mid;
            }
            if (start < mid && arr[mid] < arr[mid - 1]) {
                return mid - 1;
            }
            if (arr[start] >= arr[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1; // this means that the array is not rotated
    }


    static int noOfTimesRotated(int[] arr) {
        int pivot = findPivot(arr);

        // NO NEED TO WRITE THIS IF statement AS ... if pivot is not find i.e array is normal sorted then pivot is -1 and at the end, pivot + 1 = -1 + 1 = 0
//        if (pivot == arr.length - 1) { // instead of writing "pivot == arr.length - 1" we can write "pivot == -1"
//             return 0;
//        }

        return pivot + 1;
    }

    static int findPivotWithDuplicates(int[] arr) {
        int start = 0;
        int end   = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            // 4 cases here (I wrote those in notes)
            if (end > mid && arr[mid] > arr[mid + 1]) {
                return mid;
            }
            if (start < mid && arr[mid] < arr[mid - 1]) {
                return mid - 1;
            }
            // if  elements at middle, start and end are equal then just skip the duplicates
            if (arr[start] == arr[mid] && arr[mid] == arr[end]) {
                // skip the duplicates in this case

                // NOTE: But, what if the elements start and end were the pivots??
                // So, check if start is pivot
                if (arr[start] > arr[start + 1]) {
                    return start;
                }
                start++;

                // Now, check if end is pivot
                if (arr[end] < arr[end - 1]) {
                    return end - 1;
                }
                end--;
            }
            // left side is sorted, so the pivot should be in right
            // 2,9,2
            else if (arr[start] < arr[mid] || (arr[start] == arr[mid] && arr[mid] > arr[end])) {
                start = mid + 1; // {2, 2, 9, 1} jaise arr ke liye 2nd || wala condn
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

}
