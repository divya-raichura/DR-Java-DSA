package com.recursion.array_rec_lec2;

import java.util.ArrayList;

public class How_addAllWorks {
    public static void main(String[] args) {

        ArrayList<Integer> listMain = new ArrayList<>();

        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(11);
        list1.add(12);
        list1.add(13);
        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(21);
        list2.add(22);
        list2.add(23);
        ArrayList<Integer> list3 = new ArrayList<>();
        list3.add(31);
        list3.add(32);
        list3.add(33);

        ArrayList<Integer> list4 = new ArrayList<>();
        list4.add(41);
        list4.add(42);
        list4.add(43);

        listMain.addAll(list4);
        listMain.addAll(list2);
        listMain.addAll(list3);
        System.out.println(listMain);

        // this proves that list.addAll() adds all the elements
        // of an array at the end of the asked array

    }
}
