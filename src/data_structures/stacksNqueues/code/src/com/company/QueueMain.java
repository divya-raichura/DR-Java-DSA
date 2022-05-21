package com.company;

public class QueueMain {
    public static void main(String[] args) throws Exception {
//        CustomQueue queue = new CustomQueue();
//        queue.insert(1);
//        queue.insert(2);
//        queue.insert(3);
//        queue.insert(4);
//        queue.insert(5);
//        queue.display();
//
//        System.out.println(queue.remove());
////        queue.insert(6);
//        queue.display();


        CircularQueue queue = new CircularQueue();
        queue.insert(5);
        queue.insert(4);
        queue.insert(3);
        queue.insert(2);
        queue.insert(1);
        queue.display();
        queue.remove();
        queue.remove();
        queue.display();
    }
}
