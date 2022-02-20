package questions.binarysearch;

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

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (target < letters[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return letters[start % letters.length];
    }
}
