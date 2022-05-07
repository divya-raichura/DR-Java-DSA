package src.leetcode;

class Solution_392 {

    public static void main(String[] args) {
        boolean ans;
        String s = "abc";
        String t = "ahcgdb";
        System.out.println(isSubsequenceLeet(s, t));
    }

    static boolean isSubsequenceAns(String s, String t) {
        int count = -1;
        for (int i = 0; i < s.length(); i++) {
            int khatam = -1;
            for (int j = count + 1; j < t.length(); j++) {
                if (s.charAt(i) == t.charAt(j)) {
                    count = j;
                    khatam = j;
                    break;
                }
            }
            if (khatam == -1) {
                return false;
            }
        }
        return true;
    }

    static boolean isSubsequenceLeet(String s, String t) {
        int i = 0;
        for(int j = 0;j<t.length() && i<s.length();j++) {
            if (t.charAt(j) == s.charAt(i)) {
                i++;
            }
        }
        return i == s.length();
    }


    public boolean isSubsequence(String s, String t) {
        int count = -1;
        for (int i = 0; i < s.length(); i++) {
            int khatam = -1;
            for (int j = count + 1; j < t.length(); j++) {
                if (s.charAt(i) == t.charAt(j)) {
                    count = j;
                    khatam = j;
                    break;
                }
            }
            if (khatam == -1) {
                return false;
            }
        }
        return true;
    }
}