package com.company.recursionRevise;

import java.util.ArrayList;
import java.util.List;

public class Palindrome {
    public static void main(String[] args) {
        System.out.println(partition("aab"));
    }

    static List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        p(s, ans, new ArrayList<>());
        return ans;
    }

    // my try

    static void p(String up, List<List<String>> ans, List<String> list) {

        if (up.isEmpty()) {
            // found substring
            ans.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < up.length(); i++) {
            String ch = up.substring(0, i + 1);
            if (palindrome(ch)) {
                list.add(ch);
                p(up.substring(i+1), ans, list);
                list.remove(list.size() - 1);
            }
        }
    }

    static boolean palindrome(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
