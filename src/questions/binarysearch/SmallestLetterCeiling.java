package src.questions.binarysearch;

// https://leetcode.com/problems/find-smallest-letter-greater-than-target/

    /*
        exact same approach as ceiling of a number, only change is...
        - we have to return smallest char greater than target & not equal to target
          in ceiling we returned the smallest number greater than or equal to
          target here we have to return smallest number only greater than target

        - Note that the letters wrap around.
          means that if...
          char[] arr = {'c', 'd', 'f', 'g'}; and target = 'j'
          there is no character larger than 'j' in the array. This is the case/note
          given that if no character is larger than the target then just return the
          0th index of the array
    */

import java.util.Scanner;

public class SmallestLetterCeiling {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char[] letters = {'c', 'f', 'j'};
        char target = in.next().trim().charAt(0);
        char ans = nextGreatestLetter(letters, target);
        System.out.println(ans);
    }

    static char nextGreatestLetter(char[] letters, char target) {
        int start = 0;
        int end = letters.length - 1;

//        while (start <= end) {
//            int mid = start + (end - start) / 2;
//
//            if (target < letters[mid]) {
//                end = mid - 1;
//            } else { // imp why below code won't work:-
// because, we want ceiling. so when we find target we want char greater than target
//        hence we do s = m+1 when arr[m] == tar hence we have this condition in else
//        while below its opposite we want greater than tar but when we find tar
//        we are doing e = m-1 so how will we find greater than tar as that
//        lies in rhs so we need to do s = m+1 hence here this else cond
//                start = mid + 1;
//            }
//        }

//        this doesn't work!!
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (target > letters[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return letters[start % letters.length];
    }

    public char nextGreatestLetter2(char[] arr, char target) {
        if (target > arr[arr.length - 1] || target == arr[arr.length - 1]) {
            return arr[0];
        }
        int s = 0;
        int e = arr.length - 1;
        while (s <= e) {
            int m = s + (e - s) / 2;
            if (arr[m] > target) {
                e = m - 1;
            } else {
                s = m + 1;
            }
        }
        return arr[s];
    }
}
