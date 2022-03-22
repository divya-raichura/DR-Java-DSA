package src.leetcode;

class Solution_344 {
    public static void main(String[] args) {
        char[] s = {'h', 'e', 'l', 'l', 'o', 'd'};
        for (int i = 0; i < (s.length) / 2; i++) {
            char temp = s[i];
            s[i] = s[s.length - 1 - i];
            s[s.length - 1 - i] = temp;
        }
        System.out.println(s);
    }

    public void reverseString(char[] s) {
        for (int i = 0; i <= (s.length + 1) / 2; i++) {
            char temp = s[i];
            s[i] = s[s.length - 1 - i];
            s[s.length - 1 - i] = temp;
        }
        System.out.println(s);
    }

    static void rev(char[] chars, int start, int end) {
        if (start > end) {
            System.out.println(chars);
            return;
        }
        char temp = chars[start];
        chars[start] = chars[end];
        chars[end] = temp;
        rev(chars, ++start, --end);
    }
}