package lectures.strings;

public class DotEquals {
    public static void main(String[] args) {
        String c = "divya";
        String d = "divya";
        System.out.println(c==d);
        System.out.println(c.equals(d));
//        b = "kunal";
        String a = new String("Divya");
        String b = new String("Divya");
        System.out.println(c.equals(d));
        System.out.println(a==b);
        System.out.println(b);
    }
}
