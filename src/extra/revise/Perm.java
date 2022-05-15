package src.extra.revise;

public class Perm {

    static int count = 0;


    public static void main(String[] args) {
        permutation("abc", "");
        System.out.println("\ncount: " + count);
    }


    static void permutation(String str, String prefix) {
//        if (str.isEmpty()) {
//            System.out.print(p + " ");
//            return;
//        }
//
//        char ch = up.charAt(0);
//        for (int i = 0; i <= p.length(); i++) {
//            count++;
//            String f = p.substring(0, i);
//            String s = p.substring(i, p.length());
//            permutations(f + ch + s, up.substring(1));
//        }

        count++;
        if (str.length() == 0) {
//            count++; // 6
            System.out.println(prefix);
        } else {
            for (int i = 0; i < str.length(); i++) {
                String rem = str.substring(0, i) + str.substring(i + 1);
                permutation(rem, prefix + str.charAt(i));
            }
        }
    }
}

/*

if (str.length() == 0) {
 System.out.println(prefix);
 } else {
 for (int i= 0; i < str.length(); i++) {
 String rem = str.substring(0, i) + str.substring(i + 1);

 permutation(rem, prefix + str.charAt(i));

 }


 */