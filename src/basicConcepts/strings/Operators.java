package src.concepts.strings;


        // String concatenation operator

import java.util.ArrayList;
// VERY IMPORTANT //
// the operator + is defined in java only for primitives
//  can be used for complex obj as well with condn that atleast one of the values is string
// can't use '-' for strings

/*
 '+' operator performs addn on primitives and it is overloaded for string type, we know '+'
 adds but additional functionality that it is concatenating(joining) two strings
 java has provided it separately. This is known as operator overloading , operator is giving
 more functionalities, so in string obj, the + operator is overloaded, how - it concatenates
 more than one strings. This is only for strings, you cannot concatenate two complex obj
 like hashmap and array and all, you can't modify what + operator can do in java, u can do it
 in python, c++, but it results in poor code

 This is the only operator that is intentionally overloaded in java to support string concatenation

 */

// + in java u can use this with primitives and u can use it with complex obj as
// well but the cond is atleast one of these obj shud be of type string

public class Operators {
    public static void main(String[] args) {

        // ALL THIS DOESN'T WORK FOR '-'

        // string is not converted to ASCII value
        // character is converted to its ASCII value

        System.out.println('a' + 'b'); // 195 = ASCII value of a + ASCII value of b
        System.out.println('a' - 'b'); // ASCII value of a - ASCII value of b

        System.out.println("a " + "b"); // ab

        System.out.println('a'); // prints-> a

        System.out.println('a' + 3); // ASCII value of 'a' + 3 => 100

        System.out.println((char)('a' + 3));
// 'a' + 3 = 100 & we convert it to char by using (char), prints -> d ... kyuki ASCII value of d is '100'


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


        System.out.println(new ArrayList<>() + "" + new Integer(56)); // error
        // NOTE : IF ONE OF THE DATA TYPE IS STRING, FINAL ANS WILL BE STRING
        // HENCE, ABOVE KA WHOLE FINAL ANS IS STRING
        String expi = new ArrayList<>() + "" + new Integer(56);


// '+' in java u can use this with primitives and u can use it will complex obj as
// well but the condition is atleast one of these obj shud be of type string


        // a1
        System.out.println('a' + "1"); // "1" acts like a string
        // and hence a1 as in case of string yehi hota hai, join hojate hai

        // NOTE : IF ONE OF THE DATA TYPE IS STRING, FINAL ANS WILL BE STRING

        // 98
        System.out.println('a' + 1); // aschii value of a '97' + 1 = 98

        // 146
        System.out.println('a' + '1');
        System.out.println('1' + '2');
        int num = 'A';
        char exp_to_see_ifCharCanStoreInteger = 65;
        int num2 = 'B';
        System.out.println(num);
        System.out.println(num2);
        System.out.println(num + num2);


        int[] arr = {3, 1, 5, 4, 2};
        String name = "divya";
        System.out.println(56);
        System.out.println(name);
        System.out.println('c' + "" + arr + "d");
//        System.out.println(new ArrayList<>()  +  arr + "");// error
        System.out.println(new ArrayList<>() + "" + arr);// correct

        System.out.println(exp_to_see_ifCharCanStoreInteger);

    }
}
