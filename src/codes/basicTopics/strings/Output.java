package lectures.strings;

import java.util.Arrays;

// PRIMITIVES ARE STORED IN STACK MEMORY AND OBJECTS ARE STORED IN HEAP MEMORY
// SO IN CASE OR ARRAY REF VARIABLE IN STACK POINT TO OBJ(ARRAY) IN HEAP
// IN PRIMITIVES LIKE INT,AND ALL, BOTH ARE IN STACK
// SEE MY NOTES AND THAT BOOKMARKED WEBSITE

public class Output {
    public static void main(String[] args) {

//        anything we give to '.print' its going to call '.value. and
//        that is going to call '.toString'
//        .value -> if obj is null just print null and if it is not pointing to null
//        then .value -> .toString, that null condition cause null.something will give error
//        cause x.something means u are using something from that x
//        so we don't do null.something as null is null
//        hence if didn't had that check and obj was null then it
//        would do null.x which is null pointer exception, hence we put that check there


//



        System.out.println(56); // internally, it returns string only --> value of and then Integer.toString
        System.out.println("kunal"); // same thing here, takes string value of kunal and then prints it just as above just idar ye khud hi string hai
        System.out.println(new int[]{1,2,3,4,5}); // new keyword object
        // here we are giving it an object to print
        // obj can be of many types, here it is array, in future we will learn about hashmaps, our own obj, etc
        // how would java know what type of obj it is and what to print
        // in that case, for every obj, they have a default representation
        // (andar dek println ke) it takes a hascode, adds a @ to it and adds some characters and whatever, but it is not beneficiary to us
        // so we over ride this method. You say, u don't want java to use this toString method (woh println ke andar wala)
        // u want to use ur own toString method that is why u do something
        // like this- Arrays.toString() ... so u say don't use that println ke andar wala toString, use
        // toString method available in 'Arrays'
        // woh Arrays.toString ke andar dek, it is printing nicely by adding commas, bracket, etc stuff
        System.out.println(Arrays.toString(new int[]{1,2,3,4,5})); // this is called function over riding
        // now it is not using the default one, similarly u can create ur own toString methods, we will do in future

    }
}
