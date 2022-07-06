package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class HeapsArr {
    int[] arr;
    int size;
    private int capacity;

    public HeapsArr() {
        this.capacity = 100;

        size = 0;
        arr = new int[this.capacity];
    }

    public HeapsArr(int[] arr) {
        this.arr = arr;
        heapifyArr(this.arr);
    }

    // o(1)
    public int getMaxElement() {
        if (this.size <= 0) return -1;
        return this.arr[0];
    }

    private int getParent(int index) {
        return (index - 1) / 2;
    }

    private int getLeftChild(int index) {
        int l = 2 * index + 1;
        if (l >= this.size) {
            return -1;
        }
        return l;
    }

    private int getRightChild(int index) {
        int r = 2 * index + 2;
        if (r >= this.size) {
            return -1;
        }
        return r;
    }

    public void display() {
        System.out.println(Arrays.toString(this.arr));
    }

    private void swap(int a, int b) {
        int temp = arr[b];
        arr[b] = arr[a];
        arr[a] = temp;
    }

    //
    public void insert(int element) {
        arr[size] = element;
        // compare this index's element with parent's and increase size
        recursiveInsert(size++);
    }

    //    o(log N)
    public void iterativeInsert(int element) {
        this.size++; // increased the size but didn't add element before increasing, why?
        // see this...
        int curr = this.size - 1; // place which is empty for new element
        while (curr >= 0 && arr[curr] > arr[getParent(curr)]) {
            // so, while parent element is smaller keep bringing it down
            arr[curr] = arr[getParent(curr)];
            curr = getParent(curr);
        }
        // loop stops when parent is greater or when curr reaches at top(root)
        // in both cases curr points to correct position of inserted element
        arr[curr] = element;
    }

    // go upwards algo -> height of complete bt: o(log N)
    private void recursiveInsert(int index) {
        int parent = getParent(index);
        if (index == 0 || arr[parent] >= arr[index]) {
            return;
        }
        // swap with parent node
        swap(parent, index);
        // compare with parent's parents
        recursiveInsert(parent);
    }

    public int remove() {
        if (this.size == 0) {
            return -1;
        }
        int result = arr[0];
        arr[0] = arr[--size];
        arr[size] = 0;
        downheap(0);
        return result;
    }

    // go down by comparing children -> o(log N)
    private void downheap(int index) {
        int max = index;
        int l = getLeftChild(index);
        int r = getRightChild(index);

        // find max of lhs and rhs children and swap curr element with the max child
        if (l != -1 && arr[max] < arr[l]) {
            max = l;
        }
        if (r != -1 && arr[max] < arr[r]) {
            max = r;
        }
        // if both l and r are -1 or both are smaller than index
        // then max is index (parent) itself so no need to do anything
        if (max != index) {
            swap(max, index);
            downheap(max);
        }
    }

    /*
        heapify is method to build a heap using o(n) time complexity
        when we have an array/list of elements

        cause normal inserting elements using above insert method takes o(n log n)
        cause each insertion is o(logN) and there are N elements, hence o(NlogN)

     */
    // goes from down to up as a whole, and up to down at each step to heapify elements
    // same algo as delete max
    // o(n)
    private void heapifyArr(int[] arr) {
        this.arr = arr;
        this.size = arr.length;
        for (int i = arr.length - 1; i >= 0; i--) {
            downheap(i);
        }
    }
 
    public int[] heapsort() {
        int[] nums = new int[this.size];
        for (int i = 0; i < nums.length; i++) {
            nums[nums.length - i - 1] = this.remove();
        }
        return nums;
    }
}
