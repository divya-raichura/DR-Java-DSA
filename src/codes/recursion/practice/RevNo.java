package src.codes.recursion.practice;

public class RevNo {
    public static void main(String[] args) {
        System.out.println(rev(69420));
        System.out.println(rev2(69420, 0));

    }

    static int rev2(int n, int ans) {
        if (n == 0) {
            return ans;
        }
        ans = ans * 10 + n % 10;
        return rev2(n / 10, ans);
    }

    static int rev(int n) {
        int ans = 0;
        while (n > 0) {
            int rem = n % 10;
            ans = ans * 10 + rem;
            n /= 10;
        }
        return ans;
    }
}
