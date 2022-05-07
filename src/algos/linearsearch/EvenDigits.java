package lectures.linearsearch;
    //  https://leetcode.com/problems/find-numbers-with-even-number-of-digits/
public class EvenDigits {
        public static void main(String[] args) {
            int[] arr = {12, 345, 2, 6, 7896};
            System.out.println(noOfEvenDigits(arr));
        }

        static int noOfEvenDigits(int[] arr) {
            int ans = 0;
            for (int nums : arr) {
                if (even(nums)) {
                    ans++;
                }
            }
            return ans;
        }

        static boolean even(int nums) {
            int noOfDigits = noOfDigits(nums);
            return noOfDigits % 2 == 0;
        }

        static int noOfDigits(int nums) {
            int count = 0;

            if (nums == 0) {
                return 1;
            }
            if (nums < 0) {
                nums = nums * -1;
            }
            while (nums > 0) {
                count++;
                nums /= 10;
            }
            return count;
        }
}













//        public static void main(String[] args) {
//            int[] nums = {12, 345, 2, 6, 7896};
//            System.out.println(findNumbers(nums));
//        }
//        static int findNumbers(int[] nums) {
//            int count = 0;
//            for(int num : nums) {  // "int num : nums" means- for every element in nums array
//                if (even(num)) {
//                    count++;
//                }
//            }
//            return count;
//        }
//
//        // function to check whether a number contains even digit or not
//
//        static boolean even(int num) {
//            int numberOfDigits = digits(num);
//
//            return numberOfDigits % 2 == 0; // or in simple way :-
//
////        if (numberOfDigits % 2 == 0) {
////            return true;
////        }
////        return false;
//        }
//
//        // count number of digits in a number
//        static int digits(int num) {
//
//            if (num < 0) {
//                num = num * -1;
//            }
//
//            if (num == 0) {
//                return 1;
//            }
//
//            int count = 0;
//
//            while(num > 0) {
//                count++;
//                num = num / 10; // num =/ 10
//            }
//
//            return count;
//        }