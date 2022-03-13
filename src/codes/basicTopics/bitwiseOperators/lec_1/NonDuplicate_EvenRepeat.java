package bitwiseOperators.lec_1;


// 1 feb 2022
public class
NonDuplicate_EvenRepeat {
    public static void main(String[] args) {
        int[] arr = {21, 69, 3, 11,  11, 69, 21};
        int[] arrKK = {2, 3, 3, 4, 2, 6, 4};
        System.out.println(dup(arr));
    }


    // complexity is O(n)
    static int dup(int[] arr) {
        int unique = 0;

        for (int n : arr) {
            unique ^= n;
        }

        return unique;
    }

    // revise
    static int noDup(int[] arr) {
        int ans = arr[0];
        for (int i = 1; i < arr.length; i++) {
            ans = ans ^ arr[i];
        }
        return ans;
    }

}
