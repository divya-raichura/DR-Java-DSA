package src.codes.recursion.rec_7_questions;

import java.util.ArrayList;
import java.util.List;

public class LeetcodeSolnForPhone {
    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }

    static List<String> letterCombinations(String digits) {
        String[] numpad = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> ans = new ArrayList<>();
        if (digits.length() == 0) {
            return ans;
        }
        ans.add("");
        for (int i = 0; i < digits.length(); i++) {
            ans = combine(numpad[digits.charAt(i) - '0'], ans);
        }
        return ans;
    }

    static List<String> combine(String digit, List<String> list) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < digit.length(); i++) {
            for (String x : list) {
                result.add(x + digit.charAt(i));
            }
        }
        return result;
    }
}


