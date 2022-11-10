package src.data_structures.stacksNqueues.code.src.com.company.queue;

public class CustomQueue {
    private int[] arr;
    private static final int Default_Size = 10;
    private int end = 0;
    public CustomQueue(int size) {
        this.arr = new int[size];
    }

    public CustomQueue() {
        this(Default_Size);
    }

    private boolean isFull() {
        return end == arr.length;
    }

    private boolean isEmpty() {
        return end == 0;
    }

    public void insert(int n) throws Exception {
        if (isFull()) {
            throw new Exception("Full Queue");
        }
        arr[end++] = n;
    }

    // the shifting of elements takes O(n) time complexity
    // we can solve this using circular queues
    public int remove() throws Exception {
        if (isEmpty()) {
            throw new Exception("Empty Queue");
        }

        int removed = arr[0];
        // shift the elements
        for (int i = 1; i < end; i++) {
            arr[i - 1] = arr[i];
        }
        end--;
        return removed;
    }

    public void display() {
        for (int i = 0; i < end; i++) {
            System.out.print(arr[i] + " <- ");
        }
        System.out.println("END");
    }

    public int front() throws Exception {
        if (isEmpty()) {
            throw new Exception("Empty Queue");
        }
        return arr[0];
    }
}
