package com.company.revision;

public class Main {
    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();

        list.addFirst(20);
        list.addFirst(67);
        list.addFirst(53);
        list.display();

        list.addLast(40);
        list.addLast(6);
        list.addLast(24);
        list.display();

        list.add(2,1);
        list.add(4,3);
        list.display();

        list.removeFirst();
        list.removeLast();
        list.remove(3);
        list.addLast(22);
        list.display();

    }
}
