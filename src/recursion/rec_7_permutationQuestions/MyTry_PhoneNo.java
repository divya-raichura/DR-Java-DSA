package src.recursion.rec_7_permutationQuestions;

import java.util.ArrayList;
import java.util.List;

public class MyTry_PhoneNo {
    public static void main(String[] args) {
//        List<String> list1 = permutations("", "");
//        List<String> list2 = permutations("", "def");
//        List<String> ans = new ArrayList<>();
//        for (int i = 0; i < list1.size(); i++) {
//            for (int j = 0; j < list2.size(); j++) {
//                ans.add(list1.get(i) + list2.get(j));
//            }
//        }
//        System.out.println(ans);
    }

    static List<String> permutations(String p, String up) {
        if (up.length() == 2) {
            List<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        List<String> list = new ArrayList<>();

        for (int i = 0; i < up.length(); i++) {
            List<String> ans = permutations(p + up.charAt(i), up.substring(0,i) + up.substring(i+1));
            list.addAll(ans);
        }
        return list;
    }

}
