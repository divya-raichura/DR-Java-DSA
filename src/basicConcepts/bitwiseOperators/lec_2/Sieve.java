package bitwiseOperators.lec_2;

public class Sieve {
    public static void main(String[] args) {
        // 'boolean[] variable' array always has default value as 'false' initially
        // so if we print any element 'variable[0]' suppose, it will print false
        // unless we put some condition to change it

        int n = 40;
        boolean[] primes = new boolean[n+1];// cause, 40 should be included and arr starts
        // from 0, hence if we take till 'n', last no would be 39 and 40 will not be checked
        // hence, we take till n+1, so that 40 is also included
        sieve(n, primes);
    }



//    Sieve of Eratosthenes

    // --> n[log(log n)]

// false in the arr means the number is Prime
    static void sieve(int n, boolean[] primes) {
        for (int i = 2; i * i <= n; i++) {
            if (!primes[i]) {
                // for i = 3, it will start from j = 6(as j = i = 3 will be prime) and
                // then after every iteration, do j+=i i.e j+=3 --> 9,12,15,... till <=n
                for (int j = i * 2; j <= n; j += i) { // 19 for 2 // 12 for 3 ...
                    // by trend, we see that loop runs [(n / i) - 1] times everytime
                    primes[j] = true;
                }
            }
        }

        for (int i = 2; i <= n; i++) {
            if (!primes[i]) {
                System.out.print(i + " ");
            }
        }
    }

}
