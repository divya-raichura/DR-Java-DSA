package src.codes.recursion.rec_5_subset;

import java.util.ArrayList;
import java.util.List;

public class SubSet {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        List<List<Integer>> list = subSet(arr);
        for (List<Integer> individual : list) {
            System.out.println(individual);
        }
    }


    // []
    // [][1]
    // [][1][2][1,2]
    // [][1][2][1,2][3][1,3][2,3][1,2,3]
    static List<List<Integer>> subSet(int[] arr) {
        List<List<Integer>> outer = new ArrayList<>();

        outer.add(new ArrayList<>()); // cause initially we have empty list [] then we add [1] then [2],[1,2] and so on

        for (int num : arr) { // for every no, take the size of og list, create a new list and add it in og list
            int n = outer.size();
// when outer size is 2, 2 new lists will be created, when outer size is 4, 4 new lists will be created

            for (int i = 0; i < n; i++) { // because for new elements, the array is running for number of times of size of previous arraylist
// eg agar [],[1] hai list me aur 2 ke subsets dalne hai then there are two subsets of 2 -> [2],[1,2] so loop will run 2 times which is the size of outer loop processed till previous number

                List<Integer> internal = new ArrayList<>(outer.get(i)); // cause if outer is [],[1] an we are running loop for 2, 2 will be added in previous
// lists like []->[2] and [1]->[1,2], so that 'i' means get 0th list [], next line means add num (2 in this eg) to that ith list
// then 2nd time iteration ==> get 1th list -> [1] and next line means add num to it ==> [1,2]

                internal.add(num);
                outer.add(internal); // because in the outer list i am adding this individual lists, so
// individual lists getting added to main outer list is happening via this line
            }
        }
        return outer;
    }

}
