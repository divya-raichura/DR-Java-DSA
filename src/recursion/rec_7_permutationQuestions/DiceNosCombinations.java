package src.recursion.rec_7_permutationQuestions;

import java.util.ArrayList;
import java.util.List;

public class DiceNosCombinations {
    public static void main(String[] args) {
        dice("", 4);
        System.out.println();
        System.out.println(diceCombo("", 4));
    }

    static void dice(String p, int target) {
        if (target == 0) {
            System.out.print(p + " ");
            return;
        }
        for (int i = 1; i <= target; i++) {
            dice(p + i, target - i);
        }
    }

    static List<String> diceCombo(String p, int target) {
        if (target == 0) {
            List<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        List<String> list = new ArrayList<>();
        for (int i = 1; i <= target; i++) {
            List<String> ans = diceCombo(p + i, target - i);
            list.addAll(ans);
        }
        return list;
    }


//    static List<List<Integer>> combo(List<Integer> p, int up) {
//        if (up == 0) {
//            List<List<Integer>> list = new ArrayList<>();
//            list.add(p);
//            return list;
//        }
//        List<List<Integer>> list = new ArrayList<>();
//        for (int i = 1; i <= up; i++) {
//            List<Integer> pro = new ArrayList<>();
//            pro.add(i);
//            List<List<Integer>> ans = combo(pro, up - i);
//            ans.addAll(pro);
//            list.addAll(ans);
//        }
//        return list;
//    }

}
