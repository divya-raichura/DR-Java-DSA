package src.data_structures.stacksNqueues.code.src.com.company.queue;

import java.util.Arrays;
import java.util.LinkedList;

public class MainDynamicQ {
    public static void main(String[] args) throws Exception {
        DynamicQueue queue = new DynamicQueue();
        queue.insert(1);
        queue.insert(2);
        queue.insert(3);
        queue.insert(4);
        queue.remove();
        queue.remove();
        queue.insert(5);
        queue.insert(6);
        queue.insert(7);
        queue.insert(8);
        queue.insert(9);
        queue.insert(10);
        queue.insert(11);
        queue.insert(12);
        queue.display();
        queue.insert(13);
        queue.display();
        //        for (int i = 1; i <= 11; i++) {
//            queue.insert(i);
//        }
//        queue.display();
    }
}
