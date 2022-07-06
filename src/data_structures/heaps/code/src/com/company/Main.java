package com.company;

import com.company.nice.Heap;

import java.util.ArrayList;
import java.util.Arrays;

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
        my.insert(50);
        my.insert(30);
        my.insert(20);
        my.insert(15);
        my.insert(10);
        my.insert(8);
        my.insert(16);
        my.insert(60);
        my.display();
        my.remove();
        my.display();
        int[] ans = my.heapsort();
        System.out.println("heapsort: " + Arrays.toString(ans));
    }
}
