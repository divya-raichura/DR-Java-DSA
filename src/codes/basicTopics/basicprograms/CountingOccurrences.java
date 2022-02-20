package lectures.basicprograms;

import java.util.Scanner;

public class CountingOccurrences {
    public static void main(String[] args) {

//        int n = 1577877779;
//        //how many times the number 7 occurs in n
//
//        int count = 0;
//
//        while(n > 0) {
//            int rem = n % 10;
//            if (rem == 7) {
//                count = count + 1;
//            }
//            n/=10;
//        }
//        System.out.println(count);

        Scanner in = new Scanner(System.in);
        System.out.print("Enter a number : ");
        int n = in.nextInt();
        int input = n;
        System.out.print("For which number do you want to check occurrence : ");
        int check = in.nextInt();
        int count = 0;

        while(n > 0) {
            int rem = n % 10;
            if (rem == check) {
                count++;
            }
            n/=10;
        }
        System.out.print(check + " occurred " + count + " times in the input number " + input );

        /*
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a number = ");
        int n = in.nextInt();
        System.out.print("Enter a digit from your input number whose no of occurrences you want to find = ");
        int input  = in.nextInt();
        int count = 0;
        while (n > 0) {
            int remainder = n % 10; // last digit // remainder of a number with 10 gives the last digit
            if (remainder == input) {
                count++;
            }
            n /= 10; // eg1- 1393/10 = 139.3 but java takes it as 139 and doesnt go ahead to put decimal and remainder is 3 // eg2- 1/10 = 0.1 but java takes it as 0 and doesnt go ahead to put decimal and remainder is 1


                          clearing my doubt :- when n=1, 1%10 kaise hota hai:-

             1/10= 0.1 but java me 0 leta hai, so 1/10=0 kiya toh remainder 1 ata hai or java me udr
             process ruk jata hai 0.1 nahi hota to give 0 as remainder hence,
             1%10 = 1
             and end me n/=10 me 0 ata hai ans and acc to while cond n>0 so condn not satisfied and
             loop ends :)


    }
        System.out.println("Ans = " +  count);
         */

    }
}

