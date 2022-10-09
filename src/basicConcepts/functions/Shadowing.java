package lectures.functions;

public class Shadowing {
    static int x = 90;
    public static void main(String[] args) {
        System.out.println(x); //90
        int x; // declaring
        x = 11; // initializing
        System.out.println(x); // 11
        fun();
    }

     static void fun() {
         System.out.println(x);
    }
}
