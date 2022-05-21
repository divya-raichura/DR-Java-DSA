package com.company;

public class DynamicQueue extends CircularQueue {
    public DynamicQueue() {
        super();
    }

    @Override
    public void insert(int n) {
        if (this.isFull()) {
            int[] temp = new int[arr.length * 2];
            for (int i = 0; i < arr.length; i++) {
                temp[i] = arr[(front + i) % arr.length];
            }
            arr = temp;
        }
        super.insert(n);
    }

    public DynamicQueue(int size) {
        super(size);
    }
}
