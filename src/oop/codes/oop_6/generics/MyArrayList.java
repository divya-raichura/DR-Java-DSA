package src.oop.codes.oop_6.generics;


import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

// Custom ArrayList
public class MyArrayList {
    private int[] arr;
    private static int DEFAULT_SIZE = 10;  // since, it doesn't depend on object
    // it will be same for all objects
    int size = 0;

    private boolean isFull() {
        return size == DEFAULT_SIZE;
    }


    public MyArrayList() {
        this.arr = new int[DEFAULT_SIZE];
    }

    public void add(int n) {
        if (this.isFull()) {
            resize();
        }
        arr[size++] = n;
    }

    private void resize() {
        int[] temp = new int[arr.length * 2];
        for (int i = 0; i < arr.length; i++) {
            temp[i] = arr[i];
        }
        arr = temp;
    }

    public int get(int index) {
        return arr[index];
    }

    public void set(int index, int value) {
        arr[index] = value;
    }

    public int remove() {
        return arr[--size];
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

    public static void main(String[] args) {
        MyArrayList list = new MyArrayList();
        for (int i = 0; i < 15; i++) {
            list.add(2 * i);
        }
//        list.add("af");  // we can add only int, if we want for string too
        // then we need to create new class and make write new code for custom
        // list for string and similarly other data types
        // but in og list we can add the data type we want in <> and use same
        // code. This is the use of generics

    }

}
