package lectures.linearsearch;
    // https://leetcode.com/problems/richest-customer-wealth/
public class MaxWealth {
    public static void main(String[] args) {

    }
        /*
            {
            {1,2,3}, // this is first person and 1,2,3 are bank balance in different banks, he has money in three banks
            {2,8} // this is another person and 2,8 are bank balance in different banks, he has money in two banks
            };
            // 1+2+3=6 is total balance of first person
             */
    static int maximumwealth(int[][] accounts) {
        // person = row
        // account = col
        // accounts[person][bank balance]
        int ans = Integer.MIN_VALUE;
        for (int person = 0; person < accounts.length; person++) {
            // this loop is going through all rows which are arrays themselves inside that big array
            // when you start a new col, take a new sum for that row
            int sum = 0;
            for (int account = 0; account < accounts[person].length; account++) {
            // this for loop is going through each column in that small arrays ie woh chote arrays ka har ek element
                sum = sum + accounts[person][account];
                // this will give total balance of person, adding amount in all banks
            }
            if (sum > ans) {
                ans = sum;
            }
        }
        return ans;
    }

}
