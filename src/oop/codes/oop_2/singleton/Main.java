package src.oop.codes.oop_2.singleton;

// in that static string name in innerclasses.java we were creating two objects
// thought when we did output only kunal was printed, as first "divya" obj was created and
// name pointed to it and them "kunal" obj was created and name then pointed to it
// hence both time value of name that is "kunal" was printed
public class Main {
    public static void main(String[] args) {
//        Singleton obj1 = new Singleton();// in singleton, we don't want to let user create more than one object
        // to prevent user from creating obj we need to private constructor cause that's what we use to create obj\
        // upar woh static String name me more than one obj were created but at the end a single obj remained and ref var pointed to it
        // but here in singleton only one object is created and many ref var point to that same obj
        Singleton obj1 = Singleton.getInstance();
        Singleton obj2 = Singleton.getInstance();
        Singleton obj3 = Singleton.getInstance();
        // all 3 ref vars are pointing to the same one obj and no new obj is created

    }
}
