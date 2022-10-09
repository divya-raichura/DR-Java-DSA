package src.concepts.primitive_typecast;

import java.util.Scanner;


                // w3 schools op
// https://www.w3schools.com/java/java_type_casting.asp
/*
1) Widening casting is done automatically when passing a smaller size type to a larger size type
byte -> short -> char -> int -> long -> float -> double

2) Narrowing Casting (manually) - converting a larger type to a smaller size type
double -> float -> long -> int -> char -> short -> byte
 */

public class
Typecasting {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // bade data type me chota dala - ok ... eg -> float num = koi bhi integer, it will automatically convert eg input = 9 then output = 9.0
        // par chote type me bada dalna hai toh manually karna padega ... eg -> int num = (int) float, it will print integer value of float eg if input = 9.8 output = 9

//        float num = in.nextInt();
        // integer value se sakte input me aur float me convert hojayega but
        // float value nahi leskte cause in.nextInt hai
//        int num1 = (int)in.nextFloat(); // nope
        // float num = in.nextfloat(); then any input dalo, chalega
//        TYPE CASTING
//        int num = (int) in.nextFloat();
//        wrote nextFloat to be able to take float values and (int) for converting float to int jabardasti
//        NOT  int num = (float) in.nextInt();
//        NOT  int num1 = (int) in.nextInt();

//        int a = 257;
//        byte b = (byte) a;
//        System.out.println(b);

//        Automatic type conversions
//        byte a = 50;
//        byte b = 40;
//        byte c = 100;
        // a*b is 2000 which exceeds the byte limit though operation is performed
        // as it automatically converts byte to int type while performing any type of operation
//        int ans = a * b / c;
        // while performing operations it automatically converts to int
//        byte d = 50;
//        d = d*2;
//        this is error as while doing 50*2 it converts to int so we cant store it in
//        "d" which is still byte

//      java follows unicode principle, that is it can print any language
//        ASCII values :-
//        int num = 'A';
//        System.out.println(num);

        /*
                           Rules for type promotion

          how does it automatically promotes type from byte to integer, the rules are as follows
          1- all byte/short/char values are promoted to integer
          2- any one of the operands, that is any one of the things u are mul or divi or whatever
            is long/float/etc then whole operation will be promoted to long/float/etc
            For Eg- if you do sout(3 * 1.2 ie integer * float) this will give float

         */

//        byte b = 42;
//        char c = 'a';
//        short s = 1024;
//        int i = 50000;
//        float f = 5.67f;
//        double d = 0.1234;
//        double result = (f * b) + (i / c) - (d * s);
        // note :- all the smaller ones will be converted to bigger ones
        // f*b = b is promoted to float because float is bigger than b and then f*b is calculated in float
        // similarly i/c is in integer
        // in d*s s is promoted to double as double is larger than s
        // so output is:- float + integer - double = double as double is maximum in all three of them
//        System.out.println((f * b) + " " +  (i / c) + "" + (d * s));
//        System.out.println(result);

        // SO SIMPLY, THE CONCLUSION IS THAT:-
        // IF YOU HAVE MULTIPLE TYPES ALL THE OTHERS ARE CONVERTED TO BIGGEST ONE, IN FLOAT-INTEGER-DOUBLE,
        // DOUBLE IS BIGGEST SO ENTIRE RESULT IS CONVERTED TO DOUBLE


        // if() loop:-
        // if the if bracket () is true then only system enters in that condition
        // eg- if(true) {sout hello} then it will print hello  but if it is if(false) then it will not print

//        int num = 1;
//        while (num <= 5) {
//            System.out.println(num);
//            num++;
//        }

//        for (int count = 0; count < 6; count++) {
//            System.out.println(count);
//        }

//        System.out.print("Enter the temperature in Celcius = ");
//        float tempC = in.nextFloat();
//        float tempF = (tempC * 9 / 5) + 32;
//        System.out.println("Temperature in Fahrenheit = " + tempF);

        /*
                NOTE :

        // if both data type are of same size then both gets auto type conversion
        // like if int in char then auto convert to int according to its ascii value
        // if char in int then it gets auto converted to int value according to its ascii value
        // both of this things occur due to ascii value concept

        char ch = 'a';
        System.out.println(ch);
        ch += 1;
        char a = 97;
        int q = 'a';
        System.out.println((int)ch);
        System.out.println(a);
        System.out.println(q);
         */
        char a = 65;
        System.out.println(a);
    }
}
