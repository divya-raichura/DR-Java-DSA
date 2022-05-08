package src.oop.oop_4.code.access_modifiers;

import java.util.Arrays;

public class AboutGetClass {
    int n;
    String name;

//    @Override
//    public Class<?> getClass() {
    // can't override this method as, see using ctrl + click...
    // it is final method, hence it cannot be overridden
//    }

    public AboutGetClass(int n, String name) {
        this.n = n;
        this.name = name;
    }

    public AboutGetClass(String name) {
        this.name = name;
    }

    public AboutGetClass(int n) {
        this.n = n;
    }

    public static void main(String[] args) {

        // we can get various info about a class using getClass() and it
        // is stored in the heap memory
        AboutGetClass obj = new AboutGetClass(2);
        System.out.println(obj.getClass()); // class src.oop.oop_4.code.access_modifiers.GetClass
        System.out.println(Arrays.toString(obj.getClass().getConstructors()));

    }
}
