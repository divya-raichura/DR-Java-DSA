package lectures.functions;

import java.util.Scanner;

public class StringExample {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter your name : ");
        String naam = in.next();
        String message = myGreets(naam);
        System.out.println(message);
    }

    private static String myGreets(String name) {
        String personalised = "Hello " + name;
        return personalised;
    }



//    public static void main(String[] args) {
//        String message = myGreets("I am Divya Raichura ");
//        System.out.println(message);
//    }
//
//     static String myGreets(String name) {
//         String personalised = "Hello there, " + name ;
//         return personalised;
//    }


//    psvm.....{
//        String message = greet();
//        System.out.println(message);
//    }
//    static String greet() {
//        String greeting = "how are you";
//        return greeting;
//    }
}

