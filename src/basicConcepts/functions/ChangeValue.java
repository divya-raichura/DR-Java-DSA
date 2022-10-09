package lectures.functions;

import java.util.Arrays;

public class ChangeValue {
    public static void main(String[] args) {
        int[] arr = {1, 2, 45, 6, 8};
        System.out.println(Arrays.toString(arr));
        change(arr);
        System.out.println(Arrays.toString(arr));
    }
    // in name and naam we were not modifying string, we were creating new string obj
    // also we can't modify strings due to security reasons, will study later
    // but here in arrays, we are modifying the array,
     static void change(int[] nums) {
        nums[0] = 99; // of you make a change to obj via this var, same obj will be changed
    }
}

