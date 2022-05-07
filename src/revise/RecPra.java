package src.revise;

public class RecPra {
    public static void main(String[] args) {
        System.out.println(printMe(1824, 0));

    }


    // print 1 to 5 and then 5 to 1
    static int printMe(int n, int ans) {
        // create ans
        // take remainder
        // multiply ans by 10 and add remainder to it
        if (n == 0) {
            return ans;
        }
        return printMe(n / 10, ans * 10 + n % 10);
    }
}
