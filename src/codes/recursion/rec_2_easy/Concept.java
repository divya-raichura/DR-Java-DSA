package src.codes.recursion.rec_2_easy;

public class Concept {
    // 1    // pehle 10 print kardeta, fir increment karta, toh niche agar sout(x) lagaya toh 11 print karega
//        System.out.println(x++);

// 2    // same, 10 print karta fir -- hoke 9 banta so agar next line me sout(x) kiya toh 9 dikhega
//        System.out.println(x--);

// 3    // pehle increment karta to 11 then it prints, so ek line me kaam hojata
//        System.out.println(++x);

// 4    // pehle -- karta to 9 and then prints, and hence ek line me kaam done
//        System.out.println(--x);

    public static void main(String[] args) {
        concept(5);
    }

    static void concept(int n) {
        if (n == 0) {
            return;
        }
        System.out.println(n);
//        concept(n--); // gives stack overflow error
        concept(--n);
//        n--  vs  --n ==> explanation above
    }

}
