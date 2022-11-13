package com.company.implementations;

import java.util.ArrayList;
import java.util.Collections;

public class GenericPQ<T extends Comparable<T>> {

    ArrayList<T> list;

    public GenericPQ() {
        list = new ArrayList<>();
    }

    // heapify (build heap in o(n))
    public GenericPQ(T[] arr) {
        list = new ArrayList<>();
        Collections.addAll(list, arr);

        for (int i = list.size() / 2 - 1; i >= 0; i--) {
            downHeap(i);
        }
    }

    public void add(T val) {
        list.add(val);
        upHeap(list.size() - 1);
    }

    public void upHeap(int i) {
        if (i == 0) return;

        int p = (i - 1) / 2;

        if (list.get(i).compareTo(list.get(p)) < 0) {
            swap(i, p);
            upHeap(p);
        }
    }

    public T remove() {
        if (list.isEmpty()) {
            System.out.println("empty!");
            return null;
        }

        T temp = list.get(0);
        T last = list.remove(list.size() - 1);

        list.set(0, last);

        downHeap(0);

        return temp;
    }

    private void downHeap(int i) {
        int min = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < list.size() && list.get(l).compareTo(list.get(min)) < 0) {
            min = l;
        }
        if (r < list.size() && list.get(r).compareTo(list.get(min)) < 0) {
            min = r;
        }

        if (min != i) {
            swap(min, i);
            downHeap(min);
        }
    }

    public ArrayList<T> heapsort(T[] arr) {
        ArrayList<T> data = new ArrayList<>();

        for (T n : arr) {
            data.add(this.remove());
        }

        return data;
    }

    private void swap(int i, int p) {
        T temp = list.get(p);
        list.set(p, list.get(i));
        list.set(i, temp);
    }

    public int size() {
        return list.size();
    }
}
