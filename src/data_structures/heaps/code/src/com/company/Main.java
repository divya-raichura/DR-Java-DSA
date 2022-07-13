package com.company;

import com.company.nice.Heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) throws Exception {
        Heap<Integer> heap = new Heap<>();
        heap.insert(50);
        heap.insert(30);
        heap.insert(20);
        heap.insert(15);
        heap.insert(10);
        heap.insert(8);
        heap.insert(16);
        heap.insert(60);
        heap.display();
        heap.remove();
        heap.display();
        System.out.println("heapsort: "+heap.heapSort());
        System.out.println();
        HeapsArr my = new HeapsArr();
        my.iterativeInsert(50);
        my.iterativeInsert(30);
        my.iterativeInsert(20);
        my.iterativeInsert(15);
        my.iterativeInsert(10);
        my.insert(8);
        my.iterativeInsert(16);
        my.iterativeInsert(60);
        my.display();
        my.remove();
        my.display();
        int[] ans = my.heapsort();
        System.out.println("heapsort: " + Arrays.toString(ans));
    }
}
