package src.codes.recursion.rec_2_easy;

public class DigitProduct {
    public static void main(String[] args) {
        System.out.println(product(1342));

    }

    static int product(int n) {

        if (n % 10 == n) { // this means when at the end, one digit is remaining, return that digit
            return n; // eg : '3421' -> '342' -> '32' -> '3' ==> here 3 % 10 == 3 i.e n % 10 == n , hence, return that last digit '3' which is 'n'
        }

//        if (n <= 1) { // for n == 0 in og input(first call) also, it returns 1 hence
//            return 1;
//        }

//        int last = n % 10;
        return product(n / 10) * (n % 10); // sum(n / 10) + last;
    }

}
