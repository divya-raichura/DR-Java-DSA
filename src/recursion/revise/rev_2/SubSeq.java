package src.codes.recursion.revise.rev_2;

import java.util.ArrayList;
import java.util.List;

public class SubSeq {
    public static void main(String[] args) {
        subseq("", "abc");
        System.out.println();
        System.out.println(subSeqList("", "abc"));
    }

    static void subseq(String p, String up) {
        if (up.isEmpty()) {
            System.out.print(p + "  ");
            return;
        }
        subseq(p + up.charAt(0), up.substring(1));
        subseq(p, up.substring(1));
    }

    static List<String> subSeqList(String p, String up) {
        if (up.isEmpty()) {
            List<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        List<String> left = subSeqList(p + up.charAt(0), up.substring(1));
        List<String> right = subSeqList(p, up.substring(1));
        left.addAll(right);
        return left;
    }

}
