package bitwiseOperators.lec_1;


public class CountOfDigits {
    public static void main(String[] args) {
        int n = 20;
        System.out.println(count(n));
        System.out.println(countFormula(n));
    }

    static int count(int n) {
        int count = 0;
        while (n > 0) {
            n = n >> 1;
            count++;
        }
        return count;
    }

    // did this in rightmost Set position question
    // but the general formula for any no system is :-
    // int{ (log to the base b (n)) + 1 } base b = base of no sys, n = number
    // for binary base is 2, for decimal its 10 etc
    static int countFormula(int n) {
        return (int) (1 + (Math.log(n) / Math.log(2)));
        // complexity is log(n)
    }


}
