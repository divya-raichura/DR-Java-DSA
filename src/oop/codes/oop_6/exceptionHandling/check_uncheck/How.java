package src.oop.codes.oop_6.exceptionHandling.check_uncheck;

public class How {
    public static void main(String[] args) {
        // errors and exception are extended from 'throwable' this is superclass
        // error can't be recovered from, but exc can...

        // all exceptions are subclasses of 'exception class'
        // 'runtime exception' is one subclass of 'exception class'
        // runtime exception has other subclass- nullPointer, NumberFormat, etc
        // 'runtime exception' and all of it's subclasses are 'unchecked'
        // all others are 'unchecked' that includes, 'exception' itself
        // and other subclasses of it besides for 'runtime exception'

        // 'runtime exception' and its subclasses all are unchecked
        // all other exception including 'exception'  itself and its other subclasses
        // except for 'runtime' are checked

        // we should deal with both exceptions using try catch, difference
        // is just java doesn't check if you are dealing with unchecked exc
        // but, it does if the exc is checked
    }


    private static void hello() {
//        throw new Exception(); // this gives error, we need to compulsorily deal
        // with it,  as 'Exception()' is checked exception

        throw new RuntimeException(); // this doesn't give error msg
        // as 'RuntimeException()' is unchecked exception

    }
}
