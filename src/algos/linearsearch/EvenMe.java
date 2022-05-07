package lectures.linearsearch;

 // return how many elements in arr contains even no of digits
public class EvenMe {
     public static void main(String[] args) {
         int[][] arr = {
                 {1, 2, 3},
                 {2, 4, 1},
                 {3, 1}
         };
         System.out.println(maxWealth(arr));
     }

     static int maxWealth(int[][] arr) {
         /*
          its like
          {1,2,3}  -> 0th index row
          {4,5,6}  -> 1st index row
          // so rows array are different persons
          // and that individual elements(col) are there wealth in diff accounts
          // we need to give max wealth
         */
         int max = 0;
         for (int person = 0; person < arr.length; person++) {
             int sum = 0;
             for (int account = 0; account < arr[person].length; account++) {
                 sum = sum + arr[person][account];
             }
             if (sum > max) {
                 max = sum;
             }
         }
         return max;
     }
}
