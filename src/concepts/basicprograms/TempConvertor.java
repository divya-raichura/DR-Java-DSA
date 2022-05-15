package lectures.basicprograms;

import java.util.Scanner;

public class TempConvertor {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter temperature in Celsius : ");
        float TempC = in.nextFloat();
        System.out.print("Temperature in Fahrenheit is  ");
        float TempF = (TempC * 9/5) + 32;
        System.out.println(TempF);
    }
}
