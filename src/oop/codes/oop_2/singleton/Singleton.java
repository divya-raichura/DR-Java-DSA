package src.oop.oop_2.singleton;

public class Singleton {
    private Singleton() {
        // v.v.imp to create it and make it private
    }

    private static Singleton instance;

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
