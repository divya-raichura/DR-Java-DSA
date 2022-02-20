package topics.strings;


        // String concatenation operator

import java.util.ArrayList;
import java.util.Arrays;
// VERY IMPORTANT //
// the operator + is defined in java only for primitives and
// when any one of these values is string

// + in java u can use this with primitives and u can use it will complex obj as
// well but the cond is atleast one of these obj shud be of type string

public class Operators {
    public static void main(String[] args) {

        // ALL THIS DOESN'T WORK FOR '-'

        // string is not converted to aschii value
        // character is converted to its aschii value

        System.out.println('a' + 'b'); // 195 = aschii value of a + aschii value of b

        System.out.println("a" + "b"); // ab

        System.out.println('a'); // prints-> a

        System.out.println('a' + 3); // 'character value of a' + 3=>100

        System.out.println((char)('a' + 3));
//   'a' + 3 = 100 & we convert it to char by using (char), prints -> d ... kyuki aschii value of d is '100'


        System.out.println("a" + 1); // it prints-> a1
        // this is same as after a few steps: "a" + "1"
//        vimp ==> when an integer is added with a string, it is converted to its wrapper class integer
//        integer will be converted to Integer that will call toString()

        System.out.println(new ArrayList<>());
        System.out.println("Divya" + new ArrayList<>());
//        System.out.println("Divya" + new Integer(56));
        // java is like oh this is not a string, so it will convert it to string, how-> it will call toString method, we saw in println

//        System.out.println(new ArrayList<>() + new Integer(56)); // error
        // if u add string in that, then it will work
        //        System.out.println(new ArrayList<>() + "" + new Integer(56));

// '+' in java u can use this with primitives and u can use it will complex obj as
// well but the condition is atleast one of these obj shud be of type string


        // a1
        System.out.println('a' + "1"); // "1" acts like a string
        // and hence a1 as in case of string yehi hota hai, join hojate hai


        // 98
        System.out.println('a' + 1); // aschii value of a - '97' + 1 = 98

        // 146
        System.out.println('a' + '1');
        System.out.println('1' + '2');
        int num = 'A';
        int num2 = 'B';
        System.out.println(num);
        System.out.println(num2);
        System.out.println(num + num2);


    }
}
