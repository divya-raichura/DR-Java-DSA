package src.recursion.rec_7_permutationQuestions;

import java.util.ArrayList;
import java.util.List;

public class PhoneNoToSubmit {
    public static void main(String[] args) {
        System.out.println(pad("", "7"));
    }

    static List<String> pad(String p, String up) {
        if (up.isEmpty()) {
            List<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        List<String> list = new ArrayList<>();
        int digit = Integer.parseInt(String.valueOf(up.charAt(0)));

        if (digit == 7) {
            for (int i = (digit - 2) * 3; i <= (digit - 1) * 3; i++) {
                char ch = (char) ('a' + i);
                List<String> ans = pad(p + ch, up.substring(1));
                list.addAll(ans);
            }
        } else if (digit == 8) {
            for (int i = ((digit - 2) * 3) + 1; i <= (digit - 1) * 3; i++) {
                char ch = (char) ('a' + i);
                List<String> ans = pad(p + ch, up.substring(1));
                list.addAll(ans);
            }
        } else if (digit == 9) {
            for (int i = ((digit - 2) * 3) + 1; i <= ((digit - 1) * 3) + 1; i++) {
                char ch = (char) ('a' + i);
                List<String> ans = pad(p + ch, up.substring(1));
                list.addAll(ans);
            }
        } else {
            for (int i = (digit - 2) * 3; i < (digit - 1) * 3; i++) {
                char ch = (char) ('a' + i);
                List<String> ans = pad(p + ch, up.substring(1));
                list.addAll(ans);
            }
        }
        return list;
    }

}
