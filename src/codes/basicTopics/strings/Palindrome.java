package lectures.strings;

public class Palindrome {
    public static void main(String[] args) {
        String name = "abccba"; // works with empty string too
        System.out.println(palin(name));
    }

    // string builder, while, for, reverse it and if og == reverse true
    static boolean palin(String name) {
        if (name == null) {
            return true;
        }
        name = name.toLowerCase(); // so even if one of them is in
        // upper it doesn't matter

        int s = 0;
        int e = name.length() - 1;
        while (s <= e) {
            if (name.charAt(s) == name.charAt(e)) {
                s++;
                e--;
            } else {
                return false;
            }
        }
        return true;
    }

    static boolean palin2(String str) {
        if (str == null || str.length() == 0) {
            return true;
        }

        str = str.toLowerCase();
        for (int i = 0; i <= str.length() / 2; i++) {
            char start = str.charAt(i);
            char end = str.charAt(str.length() - 1 - i);

            if (start != end) {
                return false;
            }
        }
        return true;
    }
}
