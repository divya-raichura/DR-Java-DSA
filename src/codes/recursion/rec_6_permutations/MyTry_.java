package src.codes.recursion.rec_6_permutations;
// yay!! successful
// way easier code for permutations than taught in the tutorial

// tree diagram for this in book and my group on whatsapp
public class MyTry_ {
    public static void main(String[] args) {
        permutations("", "abc");
        }

    static void permutations(String p, String up) {
        if (up.isEmpty()) {
            System.out.println(p);
            return;
        }

        for (int i = 0; i < up.length(); i++) {
            permutations(p + up.charAt(i), up.substring(0,i) + up.substring(i+1, up.length()));
        }

    }

}
