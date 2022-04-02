package src.codes.recursion.revise.rev_2;

public class SkipString {
    public static void main(String[] args) {
        String name = "pqeurapplebscc ojfj ffe";
        skip("", name);
        System.out.println(skip2(name));
    }

    static void skip(String p, String up) {
        if (up.isEmpty()) {
            System.out.println(p);
            return;
        }
        if (up.startsWith("apple")) {
            skip(p, up.substring(5));
        } else {
            skip(p + up.charAt(0), up.substring(1));
        }
    }

    static String skip2(String up) {
        if (up.isEmpty()) {
            return "";
        }
        char ch = up.charAt(0);
        if (up.startsWith("apple")) {
            return skip2(up.substring(5));
        }
        return ch + skip2(up.substring(1));
    }

}
