package src.concepts.strings;

public class AtoZ {
    public static void main(String[] args) {
//        not efficient
        String ans = "";
        for (int i = 0; i < 26; i++) {
            char ch = (char) ('a' + i);  // char + integer converts char
//      to ASCII value and then both get added to print the addition
//      we convert it to char to print the character value of that addition
//      'a' + 0 is (char)97='a', in next iteration 'a'+1=(char)98='b'
            ans += ch + " ";
        }
        System.out.println(ans);

//  WE USE SOLVE THIS Q BY STRINGBUILDER

//        method 2 seems by-hearted, avoid
        int asci = 97;
        for (int i = asci; i < asci + 26; i++) {
            System.out.print((char) i + " ");
        }
    }
}
