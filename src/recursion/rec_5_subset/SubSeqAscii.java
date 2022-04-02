package src.codes.recursion.rec_5_subset;

public class SubSeqAscii {
    public static void main(String[] args) {
        subSeqAscii("", "abc");
    }

    static void subSeqAscii(String p, String up) {
        if (up.isEmpty()) {
            System.out.print(p + " ");
            return;
        }
        subSeqAscii(p + up.charAt(0), up.substring(1));
        subSeqAscii(p, up.substring(1));
        subSeqAscii(p + (up.charAt(0) + 0), up.substring(1));
    }

}
