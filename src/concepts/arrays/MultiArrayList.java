package src.codes.basicTopics.arrays;

import java.util.ArrayList;
import java.util.Scanner;

public class MultiArrayList {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        Scanner in = new Scanner(System.in);

        // initialisation
        // if u don't initialize, by default value of every single index will be null and it will give error
        // cause starting me arraylist ke andar ref var hai which are null
        // by initializing we will make that point to 3 arraylist
        for (int i = 0; i < 3; i++) {
            list.add(new ArrayList<>());
        }

        // add elements
        // it works as :- list.get(i), eg- when i=0 pehle, first array me enter karega
        // then 2nd for loop me woh array me individually 4 nos input karega fir 2nd array e start and so on

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                list.get(i).add(in.nextInt()); // this means, get that 3 arrayist and add elements in them one by one
            }
        }

        System.out.println(list);
    }
}
