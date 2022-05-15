package lectures.strings;

// class ka name StringBuilder nahi rakha kyuki java me ye class ka name bhi
// String builder hai so can't name it same

// StringBuilder modifies the og string instead of creating object everytime
// just like array it is mutable

                // IMPORTANT FOR CP AND INTERVIEWS


import java.util.ArrayList;

public class SB {
    public static void main(String[] args) {
        StringBuilder build = new StringBuilder();
//        build. gives many options
        for (int i = 0; i < 26; i++) {
            char ch = (char) ('a' + i);
            build.append(ch);
        }
        System.out.println(build);
        build.deleteCharAt(1); // will delete index 1
        System.out.println(build);
        build.reverse(); // will reverse it
        System.out.println(build);
    }
}
