package src.oop.codes.oop_2.packages;

public class Message {
    public static void main(String[] args) {

    }

    public static void message() { // public means, the files outside this package can also access this method
        System.out.println("this is from another class in same package");
    }
    // all those items which are declared as public, we can import only those
}
