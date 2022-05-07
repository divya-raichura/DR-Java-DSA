package src.revise;

import java.util.ArrayList;

public class SubSeq {
    public static void main(String[] args) {
        sub1("", "abc");
        System.out.println();
        System.out.println(sub2(new ArrayList<String>(), "", "abc"));
        System.out.println(sub3("", "abc"));
    }


    // up = old // p = new
    // print...
    static void sub1(String p, String up) {
        if (up.isEmpty()) {
            System.out.print(p + " ");
            return;
        }

        sub1(p + up.charAt(0), up.substring(1));
        sub1(p, up.substring(1));
    }

    // return as a list(list in args)...
    static ArrayList<String> sub2(ArrayList<String> list, String p, String up) {
        if (up.isEmpty()) {
            list.add(p);
            return list;
        }

        sub2(list, p + up.charAt(0), up.substring(1));
        sub2(list, p, up.substring(1));
        return list;
    }

    // return as a list(list in body)...
    static ArrayList<String> sub3(String p, String up) {
        if (up.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> lhs = sub3(p + up.charAt(0), up.substring(1));
        ArrayList<String> rhs = sub3(p, up.substring(1));
        lhs.addAll(rhs);
        return lhs;
    }
}

