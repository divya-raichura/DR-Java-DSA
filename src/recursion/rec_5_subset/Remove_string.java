package src.codes.recursion.rec_5_subset;

public class Remove_string {
    public static void main(String[] args) {
        String name = "bcapplek";

        System.out.println(removeApple(name));
        System.out.println(appNotApple(name));
    }

    static String removeApple(String og) {
        if (og.isEmpty()) {
            return "";
        }
        char ch = og.charAt(0);
        if (og.startsWith("apple")) { // og.length() >= 5 && og.substring(0, 5).equals("apple")
            return removeApple(og.substring(5));
        } else {
            return ch + removeApple(og.substring(1)); // og.charAt(0) + removeApple(og.substring(1))
        }
    }

    // remove "app" from the string but not when "apple" is present
    static String appNotApple(String og) {
        if (og.isEmpty()) {
            return "";
        }
        char ch = og.charAt(0);
        if (og.startsWith("app") && !og.startsWith("apple")) { // og.length() >= 5 && og.substring(0, 5).equals("apple")
            return appNotApple(og.substring(3));
        } else {
            return ch + appNotApple(og.substring(1)); // og.charAt(0) + removeApple(og.substring(1))
        }
    }

}
