package src.revise;

import src.oop.oop_3.codes.override.A;

import java.util.ArrayList;
import java.util.List;

public class Pemn {
    public static void main(String[] args) {
        permutation("", "abc");
    }

    // up - old, p - new
    static List<String> permutation(String p, String up) {
        if (up.isEmpty()) {
            List<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < up.length(); i++) {
            List<String> list = permutation(p + up.charAt(i), up.substring(0, i) + up.substring(i + 1));
            ans.addAll(list);
        }
        return ans;
    }
}
