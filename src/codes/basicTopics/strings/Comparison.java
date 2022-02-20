package lectures.strings;

public class Comparison {
    public static void main(String[] args) {
        // both point to same obj
        String a = "Kunal";
        String b = "Kunal";
        String c = a;
        // == is a comparator and .equals is a method
        System.out.println(c == a); // true
        System.out.println(a == b); // true
        // both points to different obj
        String name1 = new String("kunal");
        String name2 = new String("kunal");

        System.out.println(name1 == name2); // false
        System.out.println(name1.equals(name2)); // true as .equals checks only if values are equal or not, doesn't check arrows

        // we can't do something like
//        System.out.println(name1[0]); // like we do in arrays
        // we use
        System.out.println(name1.charAt(0));
    }
}
