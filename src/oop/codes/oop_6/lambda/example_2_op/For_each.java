package src.oop.codes.oop_6.lambda.example_2_op;

import java.util.ArrayList;
import java.util.List;

public class For_each {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(5);
        list.add(45);
        list.add(56);
        list.add(72);
        list.forEach( (n) -> System.out.println(n) );
        // same as
        list.forEach(System.out::println); // Lambda can be replaced with method reference
    }
}
