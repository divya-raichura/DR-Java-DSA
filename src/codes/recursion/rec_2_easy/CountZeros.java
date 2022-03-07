package src.codes.recursion.rec_2_easy;

public class CountZeros {
    public static void main(String[] args) {
        System.out.println(countZeros(0, 0));

    }

    static int countZeros(int n, int count) {

//        if (n / 10 == 0) { // not needed cause, call itself does it
//            return count;
//        }

        // or

        if (n == 0) {
            return count;
        }

        // or

//        if (n % 10 == n) {  // not needed cause, call itself does it
//            if (n == 0) {
//                return ++count;
//            } else {
//                return count;
//            }
//        }



//        if (n % 10 == 0) {
//            return countZeros(n / 10, ++count);
//        } else {
//            return countZeros(n / 10, count);
//        }

        // else condition not needed

        if (n % 10 == 0) {
            return countZeros(n / 10, ++count);
        }

        return countZeros(n / 10, count);
    }

}
