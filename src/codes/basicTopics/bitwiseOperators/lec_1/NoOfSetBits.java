package src.codes.basicTopics.bitwiseOperators.lec_1;


public class NoOfSetBits {
    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(45));
        System.out.println(count(45));
        System.out.println(count2(45));
        System.out.println(countUsingLog(45));
    }


    static int count(int n) {
        int count = 0;
        // method 1
        while (n > 0) {
            count++;
            n = n - (n & -n);
        }
        return count;
    }

    static int count2(int n) {
        int count = 0;
        while (n > 0) {
            n = n & (n - 1);
            count++;
        }
        return count;
    }

    static int countUsingLog(int n) {
        int count = 0;
        while (n > 0) {
            int bit = (int) (1 + (Math.log(n & -n)) / Math.log(2));
            count ++;
            n = n >> bit;
        }
        return count;
    }
}
