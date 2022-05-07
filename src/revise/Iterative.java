package src.revise;

import java.util.ArrayList;
import java.util.List;

public class Iterative {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        System.out.println(ans(arr));
    }

    static List<List<Integer>> ans(int[] arr) {
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());
        for (int num : arr) {
            int size = outer.size();
            for (int i = 0; i < size; i++) { // i < outer.size() karte hai toh run nahi karta

                List<Integer> inner = new ArrayList<>(outer.get(i));
                inner.add(num);
                outer.add(inner);
            }
        }
        return outer;
    }
}
