package com.company;

import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        LinkedList<Integer> l = new LinkedList<>();

//        LL list = new LL();  // whenever we create new linked list, initially,
//        // 3 things will be initialized -> size, head and a tail will be there
//        // size = 0, head and tail = null
//        list.insertFirst(1);
//        list.insertFirst(42);
//        list.insertFirst(21);
//        list.insertFirst(39);
//        list.display();
//
//        list.insertLast(5);
//        list.insertLast(12);
//        list.display();
//
//        list.insertMid(50, 3);
//        list.display();
//        list.insertMid2(100,3);
//        list.display();
//
//        list.removeFirst();
//        list.removeLast();
//        list.remove(3);
//        list.insertLast(22);
//        list.display();

//        DoublyLL list = new DoublyLL();
//        list.addFirst(4);
//        list.addFirst(27);
//        list.addFirst(14);
//        list.addFirst(31);
//        list.display();
//        list.addLast(12);
//        list.display();
//
//        list.addAfter(27, 34);
//        list.display();

        CircularLL list = new CircularLL();
        list.insert(4);
//        list.insert(64);
//        list.insert(24);
//        list.insert(98);
//        list.insert(31);
        list.display();

        list.delete(4);
        list.display();
    }
}
