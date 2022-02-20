package lectures.functions;

// https://www.infoworld.com/article/3512039/does-java-pass-by-reference-or-pass-by-value.html#:~:text=%E2%80%9CPassing%20by%20value%E2%80%9D%20refers%20to,of%20the%20variable%20in%20memory.


// NO PASS BY REFERENCE IN JAVA
// PRIMITIVES - INT, BYTE, CHAR, SHORT ETC == JUST PASSING VALUE
// EG:- LIKE 'a' OUTSIDE AND 'a' IN SCOPE do not point TO SAME VALUE 'EG 10' BUT DIFFERENT 10 RESPECTIVELY

// OBJECTS AND STUFF(non primitives) == PASSING VALUE OF REFERENCE VARIABLE(copy of value of ref var is passed)
// EG:- LIKE NAAM AND NAME POINTING TO THE SAME OBJECT


                  /*
                  conclusion :-
 1. primitives me og value will not change if one of the ref var is assigned new value
 cause only, value is passed

 2. But in objects and stuff(non primitives), copy of the value of ref var is passed
 So both ref var point to same object so if obj is changed via one ref var, og obj is also changed
 But in this also, it is possible with only arrays not strings
 as in arrays you modify the obj but in strings you create new obj, can't
 modify due to security purpose so,
 non primitives hote hue bhi string, primitive jaisi harkat karta hai, naya obj bana leta hai
 like primitives instead of modifying og object like arrays

 */


/*
                again in short

  primitives like int,byte,short etc naye obj banate hai isliye
 ek ref var se obj me change will not affect og obj
 but non primitives like string and arrays me, copy banta hai of value of ref var,
 so, usme ek ref var se obj me change kiya toh og obj me changes reflect honge
 aur isme bhi string me naya obj banta hai like primitive, so string vale ko modify nahi karskte
 and hence, string wale me if obj is changed via one ref var, og obj me change nahi ayega
 par array me ek variable change kiya toh dusre me bhi woh change reflect hoga
   */

import java.util.Arrays;

public class PassByRefORvalue {
    public static void main(String[] args) {
        String name = "kunal kushwaha";
        changename(name);
        System.out.println(name);
    }

    static void  changename (String naam){
            naam = "Narendra Modi";
        System.out.println(naam);
    }

    static void passExamples(String naam){
        int[] arr = {0, 12, 2, 6, 5};
        int[] num = arr;
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(num));
        arr[1] = 69;
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(num));

        int a = 44;
        int b = a;
        System.out.println(a);
        System.out.println(b);
        a = 3;
        System.out.println(a);
        System.out.println(b);

        String name = "divya";
        String abc = name;

        System.out.println(name);
        System.out.println(abc);

        abc = "kunal";
        System.out.println(name);
        System.out.println(abc);
    }
}
        /*
            {
              String chacha = "Iron man";
              greet(chacha);
            }

             static void greet(String naam) {

                 System.out.println(naam);

            }
        */



            /*

            This code to swap names using function doesn't work

        String name = "kunal kushwaha";
        changename(name);
        System.out.println(name);

     static void changename(String naam) {
        naam = "Narendra Modi"
       }

       //output is kunal kushwaha and not narendra modi
       //but if we remove sout and put it in method as sout(naam) then output will be
       //narendra modi and not kunal kushwaha

             */

       /*

        This code to swap using function doesn't work

    int a = 10;
    int b = 99;
    swap(a , b);

    System.out.println(a + " " + b);

    static void swap(int num1, int num2) {
        int temp = num1;
        num1 = num2;
        num2 = temp;
    }
    // NOTE HERE THAT :-
    // a -> 10      b -> 99 outside but inside,
    // num1 and num2 are not pointing to same 10 and 99 they are pointing to different 10 and 99
    // they can also point to same 10, depends on java - ye point nahi samja
    // But in naam (inside) and name (outside) both point to same object "Kunal Kushwaha"
    // and when inside, naam is changed to "Rahul Rana", it doesn't modify "kk" but creates new object
    // which is  "Rahul Rana" even though strings are non primitives strings can't be modified
    // due to security reasons but arrays can be modified, so if naam and name are strings
    // if naam is changed inside scope, it creates new object and name outside remains same
    // but if naam and name are arrays, and inside scope, naam is modified, og object will be modified as well
    // ie, name outside will also change in case of arrays


        */

            /* Swap code

    int a = 10;
    int b = 99;

    int temp = a;
     a = b;
     b = temp;

    System.out.println(a + " " + b);


             */