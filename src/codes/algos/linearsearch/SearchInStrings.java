package lectures.linearsearch;

import java.util.Arrays;

// conclusion :-
/*
1- .length() =  gives the no of letters in string kunal just like arr.length is for
                     int[], for string u have .length()
2- .toCharArray() =  .toCharArray converts a string in form of array of chars
3- .charAt(i) = gets the element at that index i
 */
public class SearchInStrings {
    public static void main(String[] args) {
        String name = "kunal";
        char target = 'a';
//        System.out.println(search(name, target));
//        System.out.println(name.length()); // gives the no of letters in string kunal
        // just like arr.length is for int[], for string u have .length()
        System.out.println(Arrays.toString(name.toCharArray()));
           //       .toCharArray converts a string in form of array of chars
    }
    // using for each loop
    static boolean search2(String str, char target) {
        if (str.length() == 0) {
            return false;
        }
        for (char ch : str.toCharArray()) { // .toCharArray converts a string in form of array of chars
            // so this condn means for every char in string array return true if ch = target
            if (ch == target) {
                return true;
            }
        }
        return false;
    }

    static boolean search(String str, char target) {
        if (str.length() == 0) {
            return false;
        }
        for (int index = 0; index < str.length(); index++) {
            if (target == str.charAt(index)) {
                return true;
            }
        }
        return false;
    }
}
