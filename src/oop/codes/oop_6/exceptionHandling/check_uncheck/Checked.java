package src.oop.codes.oop_6.exceptionHandling.check_uncheck;
import java.io.FileNotFoundException;
import java.io.FileReader;

// unchecked : should be dealt with
// checked   : must be dealt with

public class Checked {
    public static void main(String[] args)  throws FileNotFoundException { // program crashes

        readFile("myFile.txt");

        // we need to compulsory put try catch when there is checked exception
        // in method or outside method
    }

    private static void readFile(String fileName) throws FileNotFoundException {
        // checked exceptions "must" be handled and unchecked(runtimeExceptions)
        // "should" be handled


        // this throws a checked exception, which means, we can't even compile
        // the code, we need to deal with it, if it was unchecked, we would
        // be able to run it

        // put try-catch
        // or
        // we will not deal with it 'here', whatever piece  of code calls this
        // method has to deal with it
        // we can do this by putting 'throws exception' in method signature
        // it passes error to whatever calls this method
        FileReader reader = new FileReader(fileName);
        System.out.println("hello");
    }
}
