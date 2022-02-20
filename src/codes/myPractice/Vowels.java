package myPractice;

public class Vowels {
    public static void main(String[] args) {
        System.out.println(vowels("hello"));
    }

    static int vowels(String name) {
        int count = 0;
        for (int i = 0; i < name.length(); i++) {
            char element = name.charAt(i);
            if (element == 'a' || element == 'e' || element == 'i' || element == 'o' || element == 'u') {
                count++;
            }
        }
        return count;
    }

}
