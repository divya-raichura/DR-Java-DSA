package lectures.functions;

import java.util.Scanner;



//    I DID THIS YAYYY!!!!!!
//    Prime or Not prime question


//      MY METHOD

//public class Questions {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        System.out.print("Enter a number: ");
//        int num = in.nextInt();
//        test(num);
//    }
//
//     static void test(int a) {
//        int count = 2;
//        while(count <= a) {
//            if (a % count == 0 && a != count) {
//                System.out.println("The number is not prime");
//                break;
//            } else if (a % count != 0) {
//                count++;
//            } else {
//             System.out.println("The number is prime");
//             break;
//            }
//        }
//    }
//}


//            KUNAL'S METHOD (lec 2 wala without using methods)

//
//        public class Questions{
//        public static void main(String[] args) {
//            Scanner in = new Scanner(System.in);
//            int n = in.nextInt();
//            if (n <= 1){
//                System.out.println("neither prime nor composite");
//            }
//            int c = 2;
//            while(c*c <= n) {
//                if (n % c == 0) {
//                    System.out.println("not prime");
//                    break;
//                }
//                c += 1;
//            }
//            if (c*c > n && n != 1) {
//                System.out.println("prime");
//            }
//        }
//    }


//                        same steps without c*c

//        public class Questions{
//            public static void main(String[] args) {
//                    Scanner in = new Scanner(System.in);
//                    int n = in.nextInt();
//                if (n <= 1){
//                    System.out.println("neither prime nor composite");
//                }
//                int c = 2;
//
//                while(c < n) {
//                    if (n % c == 0) {
//                        System.out.println("not prime");
//                        break;
//                    }
//                    c += 1;
//                }
//                  if (c >= n && n != 1) {
//                    System.out.println("prime");
//                 }
//            }
//        }

public class PrimeNosQ {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        boolean ans = isPrime(n);
        if (ans) {
            if (n == 1 || n == 0) {
                System.out.println("neither prime nor composite");
            } else if (n < 0){
                System.out.println("negative integers can not be prime");
            } else {
                System.out.println("prime");
            }
        }
        if (!ans) {
            System.out.println("not prime");
        }

    }

     static boolean isPrime(int n) { // false means not prime and true means prime(eg- 3,5,7,etc)
        if (n == 1) {
            return true;
//            return karneke baad bahar chala jata hai method ke niche nahi jata
        }
        int c = 2;
        while (c*c <= n) {
            if (n % c == 0) {
                return false;
            }
            c++;
        }
         return c * c > n; // if c*c>n is true it will return true or else return false
//         the above line is simplified form of below code
        /*
        if (c*c > n) {
            return true;
        }
        return false;
         */
     }
}






// revision ke vaqt ki kosis
// note that negative nos sab not prime hi hote hai idar wohi galti kardi :(



/*
public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a number = ");
        int num = in.nextInt();
        boolean ans = isPrime(num);

        if (ans) {
            System.out.println("Input number is Not Prime");
        }
        if (!ans) {
            if (num == 1 || num == 0 || num == -1) {
                System.out.println("Neither Prime nor Composite");
            } else {
                System.out.println("Input number is Prime");
            }
        }
    }
    static boolean isPrime(int num) {
        int c = 2;
        while (num > c) {
            if (num % c == 0) {
                return true;
            }
            c++;
        }
        if (num < 0) {
            while (-c > num) {
                if (num % c == 0) {
                    return true;
                }
                c++;
            }
        }
        return false;
    }
 */