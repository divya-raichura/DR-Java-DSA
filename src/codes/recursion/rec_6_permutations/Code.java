package src.codes.recursion.rec_6_permutations;

import java.util.ArrayList;
import java.util.List;

public class Code {
    public static void main(String[] args) {
        permutations("", "abc");
        System.out.println();
        System.out.println(permutationsList("", "abc"));
        System.out.println(permutationsCount("", "abc"));
    }


    static void permutations(String p, String up) {
        if (up.isEmpty()) {
            System.out.print(p + " ");
            return;
        }

        char ch = up.charAt(0);
        for (int i = 0; i <= p.length(); i++) {
            String f = p.substring(0, i);
            String s = p.substring(i, p.length());
            permutations(f + ch + s, up.substring(1));
        }
    }


    static List<String> permutationsList(String p, String up) {
        if (up.isEmpty()) {
            List<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        List<String> list = new ArrayList<>();

        char ch = up.charAt(0);
        for (int i = 0; i <= p.length(); i++) {
            String f = p.substring(0, i);
            String s = p.substring(i, p.length());
            List<String> ans = permutationsList(f + ch + s, up.substring(1));
            list.addAll(ans);
        }
        return list;
    }


    static int permutationsCount(String p, String up) {
        if (up.isEmpty()) {
            return 1;
        }
        int count = 0;
        char ch = up.charAt(0);
        for (int i = 0; i <= p.length(); i++) {
            String f = p.substring(0, i);
            String s = p.substring(i, p.length());
            int ans = permutationsCount(f + ch + s, up.substring(1));
            count += ans;
        }
        return count;
    }
}
