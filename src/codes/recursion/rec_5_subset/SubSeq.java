package src.codes.recursion.rec_5_subset;

import java.util.ArrayList;

// subsequence is for strings and subset is for array
public class SubSeq {
    public static void main(String[] args) {
        System.out.print("printing the subsets : ");
        subSeq("", "abc");
        System.out.println();
        System.out.print("returning an arraylist of subsets(method 1) : ");
        System.out.println(subSeqRetList("", "abc"));
        System.out.print("returning an arraylist of subsets(method 2) : ");
        System.out.println(subSeqRetList2("", "abc"));
    }

    // p  = processed   => new
    // up = unprocessed => og
    static void subSeq(String p, String up) {
        if (up.isEmpty()) {
            System.out.print(p + " ");
            return;
        }
        subSeq(p + up.charAt(0), up.substring(1));
        subSeq(p, up.substring(1));
    }

    static ArrayList<String> subSeqRetList(String p, String up) {
        ArrayList<String> list = new ArrayList<>();
        if (up.isEmpty()) {
            list.add(p);
            return list;
        }
        ArrayList<String> lhs = subSeqRetList(p + up.charAt(0), up.substring(1));
        ArrayList<String> rhs = subSeqRetList(p, up.substring(1));
        list.addAll(lhs);
        list.addAll(rhs);
        return list;
    }

    // better
    static ArrayList<String> subSeqRetList2(String p, String up) {
        if (up.isEmpty()) {
            ArrayList<String> list = new ArrayList<>(); // andar dalnese ye fayda hua ki ab har call pe list nahi banayega, sirf tabhi banayega jab jarurat hai, that is, jab unprocessed is empty then processed is the ans which will be stored in the list
            list.add(p);
            return list;
        }
        ArrayList<String> lhs = subSeqRetList2(p + up.charAt(0), up.substring(1));
        ArrayList<String> rhs = subSeqRetList2(p, up.substring(1));
        lhs.addAll(rhs); // so now, lhs will contain all ans of it as well as rhs, so we return lhs
        return lhs;
    }

}
