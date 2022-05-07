package src.codes.myPractice.prac2;

public class ReverseString {
    public static void main(String[] args) {
        System.out.println(rev("DivyaR"));
    }

    // wierd recursive way
    // to understand why it prints reversed string by one method and
    // normal string by another method, I have drawn recursive tree on
    // the last page of notebook
    static void reverse(String revname, String og) {
        if (og.isEmpty()) {
            System.out.println(revname);
            return;
        }
//         name is reversed
        reverse(og.charAt(0) + revname, og.substring(1));
//         name is not reversed
//        reverse( revname + og.charAt(0), og.substring(1));
    }


    // above method but with return type
    static String rev(String name) {
        if (name.isEmpty()) {
            return "";
        }
        char ch = name.charAt(0);
//         reverses
        return rev(name.substring(1)) + ch;
//         does not reverse
//        return ch + rev(name.substring(1));
    }

    // normal way
    static void revbuilder(String name) {
        StringBuilder builder = new StringBuilder();
        for (int i = name.length() - 1; i >= 0; i--) {
            builder.append(name.charAt(i));
        }
        System.out.println(builder);
    }
}



