package src.oop.codes.oop_6.toString_;

import src.oop.codes.oop_6.compares.comparable.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Students elon = new Students("Elon Musk", 31, 3);
        Students jeff = new Students("Jeffrey Bezos", 24, 24);
        Students steve = new Students("Steve Jobs", 84, 35);

        List<Students> list = new ArrayList<>();
        Students[] arr = {elon, steve, jeff};

        list.add(elon);
        list.add(jeff);
        list.add(steve);


        // all this objects ref vars print random hashcode values
        // hence these lists and arrays also store random hashcode values, to
        // print something meaning full,
        // we override toString and make it print whatever we want to, when we call
        // these ref vars, or store these ref vars of objects somewhere

        System.out.println(list);
        System.out.println(Arrays.toString(arr));

        Collections.sort(list);
        Arrays.sort(arr);

        System.out.println(list);
        System.out.println(Arrays.toString(arr));
    }
}
