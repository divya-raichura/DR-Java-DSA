package com.company;

public class DynamicStack extends CustomStack { // in dynamic, everything is
    // same like in CustomStack. Only, push is different cause this is dynamic
    // so, we override it

    public DynamicStack() {
        super(); // calls CustomStack()
    }

    public DynamicStack(int size) {
        super(size); // calls CustomStack(int size)
    }

    @Override
    public void push(int n) throws StackException {
        if (this.isFull()) {
            int[] temp = new int[arr.length * 2];
            for (int i = 0; i < arr.length; i++) {
                temp[i] = arr[i];
            }
            arr = temp;
        }

        super.push(n);
    }
}
