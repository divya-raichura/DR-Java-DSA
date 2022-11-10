package src.data_structures.stacksNqueues.code.src.com.company.queue;

public class CircularQueue {
     int[] arr;
     static final int Default_Size = 10;
     int end = 0;

     int front = 0;
     int size = 0;
    public CircularQueue(int size) {
        this.arr = new int[size];
    }

    public CircularQueue() {
        this(Default_Size);
    }

     boolean isFull() {
        return size == arr.length;
    }

     boolean isEmpty() {
        return size == 0;
    }

    public void insert(int n) {
        if (isFull()) {
            System.out.println("full");
            return;
        }
        arr[end++] = n;
        end = end % arr.length;
        size++;
    }

    // no need to shift elements
    public int remove() throws Exception {
        if (isEmpty()) {
            throw new Exception("empty");
        }
        int removed = arr[front++];
        front = front % arr.length;
        size--;
        return removed;
    }

    public int front() throws Exception {
        if (isEmpty()) {
            throw new Exception("Empty Queue");
        }
        return arr[front];
    }

    public void display() {
        int i = front;
        do {
            System.out.print(arr[i] + " -> ");
            i++;
            i %= arr.length;
        } while (i != end);
        System.out.println("END");
    }
}
