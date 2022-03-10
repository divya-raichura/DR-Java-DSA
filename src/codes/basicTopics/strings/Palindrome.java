package src.codes.basicTopics.strings;

public class Palindrome {
    public static void main(String[] args) {
        String name = "madam"; // works with empty string too
        System.out.println(palin1(name));
        System.out.println(palin2(name));
    }

    // string builder, while, for, reverse it and if og == reverse true
    static boolean palin1(String str) {
        if (str == null || str.length() == 0 || str.length() == 1) {
            return true;
        }
        str = str.toLowerCase(); // so even if one of them is in
        // upper it doesn't matter

        int s = 0;
        int e = str.length() - 1;
        while (s <= e) {
            if (str.charAt(s) == str.charAt(e)) {
                s++;
                e--;
            } else {
                return false;
            }
        }
        return true;
    }

    static boolean palin2(String str) {
        if (str == null || str.length() == 0 || str.length() == 1) {
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
