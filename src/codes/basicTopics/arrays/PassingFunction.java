package lectures.arrays;

import java.util.Arrays;

public class PassingFunction {
    public static void main(String[] args) {
        int[] nums = {2, 4, 54, 21, 11};
        System.out.println(Arrays.toString(nums));
        change(nums);
        System.out.println(Arrays.toString(nums));
    }
    static void change(int[] arr) {
        arr[0] = 99;
    }
}
