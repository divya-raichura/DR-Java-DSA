package src.codes.recursion.revise;

public class Palindrome {
    public static void main(String[] args) {
        String name = "raccar";
        System.out.println(palin(name, 0, name.length() - 1));
    }

    static boolean palin(String name, int s, int e) {
        if (s >= e) {
            return true;
        }

        if (name.charAt(s) != name.charAt(e)) {
            return false;
        }

        return palin(name, s + 1, e - 1);
    }

}
