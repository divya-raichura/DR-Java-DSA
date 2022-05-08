package src.oop.oop_4.code.access_modifiers;

public class SamePackSubclass extends Main {
    public static void main(String[] args) {
        Main obj = new Main();
        System.out.println(obj.n); // can access in same package subclass
    }
}
