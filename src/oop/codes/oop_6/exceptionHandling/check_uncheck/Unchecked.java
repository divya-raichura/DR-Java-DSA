package src.oop.codes.oop_6.exceptionHandling.check_uncheck;

// unchecked : should be dealt with
// checked   : must be dealt with

public class Unchecked {
    public static void main(String[] args) {
        String name = null;
        printL(name);
    }

    private static void printL(String name) {
        // should not put throws for unchecked as:-
    //    https://stackoverflow.com/questions/20871763/should-i-declare-unchecked-exceptions-in-the-throws-specification

        // when name is null, we get null pointer exception but
        // java doesn't give any compilation errors, it compiles file
        // but gives error when we run it (ie, at runtime)
        // because null pointer exc is 'unchecked'
        System.out.println();
    }
}
