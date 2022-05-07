package src.recursion.rec_7_permutationQuestions;

import java.util.ArrayList;
import java.util.List;

public class LeetcodeSolnForPhone {
    public static void main(String[] args) {
        System.out.println(letterCombinations("23")); // input numbers of type string
        // '0' has ascii value 48
//        System.out.println('0' + 0);
//        'a' has ascii value 97 and '0' has 48
        System.out.println('a' - '0');
    }

    static List<String> letterCombinations(String digits) {
        String[] numPad = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> ans = new ArrayList<>();
        if (digits.length() == 0) { // ""
            return ans; // []
        }
        ans.add("");
        for (int i = 0; i < digits.length(); i++) {
            ans = combine(numPad[digits.charAt(i) - '0'], ans); // '2' - '0' = 50 - 48 = 2
        }
        return ans;
    }

    static List<String> combine(String alpha, List<String> list) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < alpha.length(); i++) {
            for (String x : list) {
                result.add(x + alpha.charAt(i));
            }
        }
        return result;
    }
}


