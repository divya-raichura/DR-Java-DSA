package src.codes.myPractice.prac2;

import java.util.Arrays;

// https://www.javatpoint.com/java-string-substring
public class SameSurnameSubstringQ {
    public static void main(String[] args) {
        String[] names = {"Rahul Singh", "Dhoni Singh", "Kunal Kushwaha", "Divya Raichura", "Vikas Rajpurohit", "Bhaugafuahf Singh"};
        print(names);
        printSingh(names);
    }


    // my try
    static void print(String[] names) {
        int index = 0;
        while (index < names.length) {
            String name = names[index];
            if (name.substring(name.length() - 5).equals("Singh")) {
                System.out.println(name);
            }
            index++;
        }
    }

    static void printSingh(String[] str) {
        String surName = "Singh";
        int surNameSize = surName.length();

        int size = str.length;

        for(int j = 0; j < size; j++)
        {
            int length = str[j].length();
            // extracting the surname
            String subStr = str[j].substring(length - surNameSize);

            // checks whether the surname is equal to "Singh" or not
            if(subStr.equals(surName))
            {
                System.out.println(str[j]);
            }
        }
    }
}
