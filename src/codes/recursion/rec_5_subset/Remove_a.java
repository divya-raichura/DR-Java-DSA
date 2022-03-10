package src.codes.recursion.rec_5_subset;

public class Remove_a {
    public static void main(String[] args) {
        String name = "DivyaRaichura";

        // 1
        System.out.println(remove(name, 0, ""));
        // 2
        normal(name);
        // 3
        skip("", name);
        // 4
        System.out.println(skip2(name));
    }

    // my try, using recursion
    // note : with every call, ans is not "modified" as wkt strings are immutable, can't modify them
    // so with every call, new string object is made and old one hits garbage collection
    static String remove(String name, int count, String ans) {
        if (count >= name.length()) {
            return ans;
        }

        if (name.charAt(count) != 'a') {
//            ans += name.charAt(count); // since in string, + operator is used to concatenate(joi two or more strings)
            return remove(name, count + 1, ans + name.charAt(count)); // since in string, + operator is used to concatenate(joi two or more strings)
        }

        return remove(name, count + 1, ans);
    }



    // my try, using StringBuilder and no recursion.
    static void normal(String name) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < name.length(); i++) {
            if (name.charAt(i) == 'a') {
                continue; // when if hits ==> continue hits and sirf woh particular iteration ka next code run nahi hoga agla iteration pe chala jayega when continue hits
//                break; // when if hits ==> break hits and for loop se hi bahar nikal jata hai, next iterations are stopped
            }
            builder.append(name.charAt(i));
        }
        System.out.println(builder);
    }



    // kk approach 1 ==> in argument
    static void skip(String ans, String og) {
        if (og.isEmpty()) {
            System.out.println(ans);
            return;
        }
        char ch = og.charAt(0);
        if (ch == 'a') {// skip it -> don't add it to ans, so ans will remain as it is
            skip(ans, og.substring(1));
        } else {
            skip(ans + ch, og.substring(1));// don't skip it, add the ch to ans
        }
    }


    // kk approach 2 ==> in body, while function calls are returning
    static String skip2(String og) {
        if (og.isEmpty()) {
            return "";
        }
        char ch = og.charAt(0);
        if (ch == 'a') {
            return skip2(og.substring(1));
        } else {
            return ch + skip2(og.substring(1));// return skip2(og.substring(1)) + ch --> to print in reverse
        }
    }

}
