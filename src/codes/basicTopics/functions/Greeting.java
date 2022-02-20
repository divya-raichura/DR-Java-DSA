package lectures.functions;

import java.util.Scanner;

public class Greeting {
    public static void main(String[] args) {
//        String message = greetings();
//        System.out.println(message);
        Scanner in = new Scanner(System.in);
        System.out.print("Enter your name : ");
        String naam = in.next();
        String msg = myGreet(naam);
        System.out.println(msg);
    }

    static String myGreet(String name) {
        String message = "Hello " + name;
        return message;
    }


    static String greetings() {
        String greet = "hello divya";
        return greet;
        }
}