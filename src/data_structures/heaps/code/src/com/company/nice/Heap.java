package com.company.nice;

import java.util.ArrayList;

public class Heap<T extends Comparable<T>> {

    private final ArrayList<T> list;

    public Heap() {
        list = new ArrayList<>();
    }

    public void insert(T value) {
        list.add(value);
        upheap(list.size() - 1);
    }

    public int size() {
        return list.size();
    }

    private void upheap(int index) {

        if (index == 0) {
            return;
        }

        int p = parent(index);

        // this means if index element is smaller than parent then swap
        // because we are making min heap so min element goes up
        if (list.get(index).compareTo(list.get(p)) < 0) {
            swap(index, p);
            upheap(p);
        }
    }

    public T remove() throws Exception {
        if (list.isEmpty()) {
            throw new Exception("Removing from empty Heap");
        }
        T temp = list.get(0);

        T last = list.remove(list.size() - 1);

        if (!list.isEmpty()) {
            list.set(0, last);

            downheap(0);
        }
        return temp;
    }

    private void downheap(int index) {

        int max = index;
        int left = left(index);
        int right = right(index);

        // check is left < min
        if (left < list.size() && list.get(max).compareTo(list.get(left)) > 0) {
            max = left;
        }
        // check if right < min
        if (right < list.size() && list.get(max).compareTo(list.get(right)) > 0) {
            max = right;
        }

        if (max != index) {
            swap(max, index);

            downheap(max);
        }
    }

    private void swap(int first, int second) {
        T temp = list.get(first);
        list.set(first, list.get(second));
        list.set(second, temp);
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }

    private int left(int index) {
        return index * 2 + 1;
    }

    private int right(int index) {
        return index * 2 + 2;
    }

    public ArrayList<T> heapSort() throws Exception {

        ArrayList<T> data = new ArrayList<>();

        while (!list.isEmpty()) {
            data.add(this.remove());
        }
        return data;
    }

    public void display() {
        System.out.println(this.list);
    }
}