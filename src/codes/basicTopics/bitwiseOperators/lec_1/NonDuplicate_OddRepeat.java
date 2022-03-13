package src.codes.basicTopics.bitwiseOperators.lec_1;
// --> Integer.parseInt(Integer.toBinaryString(result)) ===>
//     to convert result(decimal) to binary we use .binarystring method but ans is
//     in string, so to convert that to integer we use .parse method
public class NonDuplicate_OddRepeat {
    public static void main(String args[]) {
        int arr[] = {12, 1, 12, 3, 12, 1, 1, 2, 3, 2, 2, 3, 7};
        int n = arr.length;
        System.out.println("The element with single occurrence is " + getSingle(arr, n));
    }

    static final int INT_SIZE = 32; // as int has 4 bytes and 1 byte = 8 bits
    // therefore total is 8*4 == 32 bits

    static int getSingle(int[] arr, int n) {
        int result = 0;
        int x, sum;

        // Iterate through every bit
        // 1st iteration(i=0)= sum of unit digit's bit(1st bit) of all elements,
        // 2nd(i=1) = sum of ten's digit bit (2nd bit) of all elements ...
        // last iteration(i=31) = sum of 32nd bit of all element (if 32nd bit exists, exists only for large nos),
        for (int i = 0; i < INT_SIZE; i++) {
            // Find sum of set bits at ith position in all
            // array elements
            sum = 0;
            x = (1 << i);

            // iterate over every element's ith bit
            for (int j = 0; j < n; j++) { // n = arr.length
                if ((arr[j] & x) != 0) {
                    sum++;
                }
            } // after loop, we have sum of all 1's of all element's ith bit

            // The bits with sum not multiple of 3, are the
            // bits of element with single occurrence.
            if ((sum % 3) != 0) {
                result |= x; // think this, you'll know why, damn intelligent move
            }

        }
        return result;
    }



    // experiment to run loop from 1 to 32 instead of 0 to 31, ==> x=1<<(i-1)
    // don't trust, only experiment
    // ans is right tho
    static int getSingle2(int[] arr, int n) {
        int result = 0;
        int x, sum;

        // Iterate through every bit
        // 1st iteration(i=0)= sum of unit digit's bit(1st bit) of all elements,
        // 2nd(i=1) = sum of ten's digit bit (2nd bit) of all elements ...
        // last iteration(i=31) = sum of 32nd bit of all element (if 32nd bit exists, exists only for large nos),
        for (int i = 1; i <= INT_SIZE; i++) {
            // Find sum of set bits at ith position in all
            // array elements
            sum = 0;
            x = (1 << i-1);

            // iterate over every element's ith bit
            for (int j = 0; j < n; j++) { // n = arr.length
                if ((arr[j] & x) != 0) {
                    sum++;
                }
            } // after loop, we have sum of all 1's of all element's ith bit

            // The bits with sum not multiple of 3, are the
            // bits of element with single occurrence.
            if ((sum % 3) != 0) {
                result |= x; // think this, you'll know why, damn intelligent move
            }
        }
        return result;
    }

}
