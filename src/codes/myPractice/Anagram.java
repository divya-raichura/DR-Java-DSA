package myPractice; // 14th feb
// https://leetcode.com/problems/valid-anagram/
import java.util.Arrays;
import java.util.Scanner;

public class Anagram {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter two Strings : ");
        System.out.println(anagram(in.next(), in.next()));
    }



    static boolean anagram(String name, String naam) {
        char[] name1 = name.toCharArray();
        char[] naam1 = naam.toCharArray();
        Arrays.sort(name1);
        Arrays.sort(naam1);

        if (name.length() != naam.length()) {
            return false;
        }

        for (int i = 0; i < naam1.length; i++) {
            if (name1[i] != naam1[i]) {
                return false;
            }
        }
        return true;
    }

    // wrong attempt of mine, nice try but
//    static boolean anagram(String naam, String name) {
//        int count = 0;
//        for (int i = 0; i < naam.length(); i++) {
//            for (int j = 0; j < name.length(); j++) {
//                if (naam.charAt(i) == name.charAt(j)) {
//                    count++;
//                    break;
//                }
//            }
//        }
//        if (name.length() == naam.length()) {
//            return count == name.length(); // or name.length
//        } else if (name.length() > naam.length()) {
//            return count == name.length();
//        }
//        return count == naam.length();
//    }

}
