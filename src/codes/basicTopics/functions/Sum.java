package lectures.functions;


import java.util.Scanner;

public class Sum {
    public static void main(String[] args) {
        int ans = sum2(20 , 30);
        System.out.println("The sum is " + ans);
    }

    static int sum2(int a , int b) {
        int sum = a + b;
        return sum;
//        or u can write as ... return a + b; ... skipping ... int sum = a + b;
    }









//      psvm.... {
//      int ans = sumoftwonos();
//      sout(ans);
//      }




    static int sumoftwonos() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter first number : ");
        int num1 = in.nextInt();
        System.out.print("Enter second number : ");
        int num2 = in.nextInt();

        int sum = num1 + num2;
        return sum;
    }

//      psvm...{
//        sum();
//      }


//    static void sum() {
//        Scanner in = new Scanner(System.in);
//        System.out.print("Enter first number : ");
//        int num1 = in.nextInt();
//        System.out.print("Enter second number : ");
//        int num2 = in.nextInt();
//
//        int sum = num1 + num2;
//        System.out.println("The sum is " + sum);
//    }


        /*
            return_type () {
                //body
                return statement
            }
        */

}
