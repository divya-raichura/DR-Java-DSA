package src.oop.codes.oop_6.exceptionHandling.myException;

public class Main {
    public static void main(String[] args) {
        try {
            throw new MyException("Kya karra hai bhai");
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }
    }
}
