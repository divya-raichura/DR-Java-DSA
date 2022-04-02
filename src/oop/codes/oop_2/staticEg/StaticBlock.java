package src.oop.codes.oop_2.staticEg;

public class StaticBlock {
    static int a = 5;
    static int b;
    // we can initialize them using static block
    // this static block runs only once when first object is created
    // for second object, it won't run again

    static {
        System.out.println("this is  in static block");
        b = a * 4;
    }

    public static void main(String[] args) {
        // static will run only once when the first obj is created ie the
        // class is loaded for the first time

        // all the static elements are run first
        StaticBlock obj1 = new StaticBlock();
        System.out.println(StaticBlock.a + " " + StaticBlock.b);
        // for this obj, as it is first object that will load class,
        // the static block runs


        StaticBlock.b += 3;
        System.out.println(StaticBlock.a + " " + StaticBlock.b);

        // now as this one is second, static block won't run for this
        // we observe this when we run program as agar static dusri baar chalta
        // toh fir b = 20 hojata and firse sout print hota
        StaticBlock obj2 = new StaticBlock();
        System.out.println(StaticBlock.a + " " + StaticBlock.b);
    }
}
