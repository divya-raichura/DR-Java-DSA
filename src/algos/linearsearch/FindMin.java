package lectures.linearsearch;

public class FindMin {
    public static void main(String[] args) {
        int[] arr = {2, 1, 44, 52, 22, -54, 78, 14};
        System.out.println(min(arr));
    }

    static int min(int[] arr) {
//        int min = Integer.MAX_VALUE;
        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            int element = arr[i];
            if (min > element) {
                min = element;
            }
        }
        return min;
    }
}
