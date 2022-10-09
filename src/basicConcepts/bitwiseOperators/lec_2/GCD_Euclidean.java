package bitwiseOperators.lec_2;

// https://www.khanacademy.org/computing/computer-science/cryptography/modarithmetic/a/the-euclidean-algorithm
// https://www.hackerearth.com/practice/math/number-theory/basic-number-theory-1/tutorial/
// https://www.geeksforgeeks.org/c-program-find-gcd-hcf-two-numbers/
// https://www.geeksforgeeks.org/euclidean-algorithms-basic-and-extended/

// The idea of this algo is, GCD of two numbers doesn’t change if smaller number is
// subtracted from a bigger number. gcd(a,b) = gcd(b,a-b) = gcd(b,c)  where c = a-b (a>b)
        // proof
// suppose D = gcd(a,b) -> xD = a and yD = b (because it is common divisor of a,b so something into d is a and other something into d is b)
/*
    a - b = c
    xD-yD = c
   (x-y)D = c and as x,y are some integers, x-y is also an integer
    kD = c --> so, just like xD and yD, we have kD where D = gcd(a,b) and c is just a-b
    and, as  x and y are integers, k is also integer which means teeno ka, a,b,c(a-b) ka same gcd hai


    // SIMILARLY, a + b = c then, xD + yD = c
    //  (x+y) D = c (i.e) kD = c and as x,y = integers, k is should also be integer and
    // hence if ax + by = c hota hai and kuch common nikalke 'c' divide nahi hoskta toh bucket nahi bharskte wala concept by kk


    // HENCE PROVED THAT, GCD OF A AND B = GCD OF B AND A-B (a>b)
    // gcd(a,b) = gcd(b,a-b) = gcd(b,c)
    // so we can take any one of them either two nos, or smaller no and subtraction of two nos

    // hindi - D is a number is a  greatest "common" divisor of two nos a and b then it is
    //  also gcd of a-b and b (subtraction of those two nos and the smaller no)
    // matlab ek no D do nos a aur b ka highest common factor hai toh woh do nos ke subt aur dono me se
    // chote number ka bhi hcf hoga
*/

// see next proofs on khan academy, gfg


public class GCD_Euclidean {
    public static void main(String[] args) {
        System.out.println(gcd(9,18)); // here order doesn't matter a > b or a < b cause we handle it in code
//        System.out.println(gcdRemainder(92,36)); // here it matters
    }

    // easy approach of gcd(a,b) = gcd(a-b,b) if a > b or vice versa
    static int gcd(int a, int b) {
        if (a == 0)
            return b;
        if (b == 0)
            return a;
        if (a == b)
            return a;
        if (a > b) {
            return gcd(a - b, b);
        } else {
            return gcd(b - a, a);
        }
    }

    // remainder approach
    static int gcdRemainder(int a, int b) {
        // a > b for 1st call and from 2nd call (1st recursive call) a < b
        // so, we flip 'b' position in call
        // but if initially, we took a < b then rec call should be like kk did in video
        // it should be (b % a, a)
        if (b == 0) {
            return a;
        }

        return gcdRemainder(b, a % b);

    }
}
