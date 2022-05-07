package src.oop.oop_3.codes.polymorphism.overloading_main;

public class Overload {

    // JVM calls main() method which receives string array as arguments only.
    public static void main(String[] args) {
        System.out.println("I am in String[] args");
    }

    public static void main(String args) {
        System.out.println("I am in String args");
    }

    public static void main() {
        System.out.println("I am in empty");
    }
}
