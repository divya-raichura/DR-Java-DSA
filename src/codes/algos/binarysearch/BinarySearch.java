package lectures.binarysearch;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {-18, -12, -4, 0, 2, 3, 4, 15, 16, 18, 22, 45, 89};
        int target = 22;  // this is the worst case if we talk about time complexity as at the end only one element remains which start and end itself and it is 22 which is also the target element
        int ans = binarysearch(arr, target);
        System.out.println(ans);
    }

    // return the index
    // return -1 if it does not exist

    static int binarysearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            // find the middle element's index
            // int mid = ( start + end ) / 2; // might be possible that (start + end) exceeds the range of 'int' in java so we will use modified formula
            int mid = start + (end - start) / 2;

            if (target < arr[mid]) { // then target lies on left side of mid, and start point will remain same but end point will become one index less than mid
                end = mid - 1;
            } else if (target > arr[mid]) { // then target lies on right side of mid, and end point will remain same but start point will become one index more than mid
                start = mid + 1;
            } else {
                return mid; // we studied in func that whenever return statement is hit the function exits and it goes in psvm... khatam tata bye bye
            }
        }
        // if any above conditions doesn't come true that means the target element is not found, and in that case we need to return -1
        return -1;

    }


}
