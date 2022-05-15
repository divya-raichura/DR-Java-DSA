package src.oop.codes.oop_6.generics;

import java.rmi.server.RemoteObjectInvocationHandler;
import java.util.ArrayList;
import java.util.Arrays;

public class MyGenArrayList<T> {
    private Object[] arr;
    private static final int DEFAULT_SIZE = 10;
    int size = 0;

    private boolean isFull() {
        return size == DEFAULT_SIZE;
    }


    public MyGenArrayList() {
//        this.arr = new T[DEFAULT_SIZE];  // can't do this
        // @ see instantiate_typeParameters class
        this.arr = new Object[DEFAULT_SIZE];
    }

    public void add(T n) {
        if (this.isFull()) {
            resize();
        }
        arr[size++] = n;
    }

    private void resize() {
        Object[] temp = new Object[arr.length * 2];
        for (int i = 0; i < arr.length; i++) {
            temp[i] = arr[i];
        }
        arr = temp;
    }

    public T get(int index) {
        return (T) arr[index];
    }

    public void set(int index, T value) {
        arr[index] = value;
    }

    public T remove() {
        return (T) arr[--size];
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "MyArrayList: {" +
                "arr=" + Arrays.toString(arr) +
                ", size=" + size +
                '}';
    }

}

class Main{
    public static void main(String[] args) {

    }
}
