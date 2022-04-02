package src.codes.recursion.rec_4_pattern;

public class BubbleKK {
    public static void main(String[] args) {

    }

    static void bubble(int[] arr, int row, int col) {
        if (row <= 0) {
            return;
        }
        if (row == col) {
            bubble(arr, row - 1, 0);
        } else {
            if (arr[col] > arr[col + 1]) {
                int temp = arr[col];
                arr[col] = arr[col + 1];
                arr[col + 1] = temp;
            }
            bubble(arr, row, col + 1);
        }
    }

}
