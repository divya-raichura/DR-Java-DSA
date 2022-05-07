package src.recursion.rec_5_subset;

public class AllCombosOfReturnAndPrint {
    public static void main(String[] args) {
        print1("", "Divya");
        System.out.println(print3("Divya"));
        print2("", "Divya");
        System.out.println(print4("Divya"));
    }

    // doesn't reverse, print
    static void print1(String up, String p) {
        if (p.isEmpty()) {
            System.out.println(up);
            return;
        }

        print1(up + p.charAt(0), p.substring(1));
    }

    // doesn't reverse, return print ie ans in body
    static String print3(String p) {
        if (p.isEmpty()) {
            return "";
        }

        return p.charAt(0) + print3(p.substring(1));
    }

    // reverse, print
    static void print2(String up, String p) {
        if (p.isEmpty()) {
            System.out.println(up);
            return;
        }

        print2(p.charAt(0) + up, p.substring(1));
    }

    // reverse, return print ie ans in body
    static String print4(String p) {
        if (p.isEmpty()) {
            return "";
        }

        return print4(p.substring(1)) + p.charAt(0);
    }
}
