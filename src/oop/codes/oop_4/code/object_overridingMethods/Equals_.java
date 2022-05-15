package src.oop.codes.oop_4.code.object_overridingMethods;

public class Equals_ {
    int n;

    public Equals_(int n) {
        this.n = n;
    }

    @Override
    public boolean equals(Object obj) {
        return this.n == ((Equals_)(obj)).n; // checks where this.n ie,
        // whether a.n ka value is equal to b's value of n
        // (Test)(obj) this means cast bigger data type Object to Test
        // and what is this obj? it is the argument we passed in .equals
        // ie, .equals(b) so it is like Object obj which we casted to
        // Test b, which does ((Test)(obj)).n ie b.n
    }

    public static void main(String[] args) {
        Equals_ a = new Equals_(2);
        Equals_ b = new Equals_(2);

        System.out.println(a == b); // false, as obvi both have diff ref
        // as they are different objects
        System.out.println(a.equals(b)); // we modified this

    }
}
