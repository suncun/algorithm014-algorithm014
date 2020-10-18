//Say you have an array for which the ith element is the price of a given stock 
//on day i. 
//
// If you were only permitted to complete at most one transaction (i.e., buy one
// and sell one share of the stock), design an algorithm to find the maximum profi
//t. 
//
// Note that you cannot sell a stock before you buy one. 
//
// Example 1: 
//
// 
//Input: [7,1,5,3,6,4]
//Output: 5
//Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 
//6-1 = 5.
//             Not 7-1 = 6, as selling price needs to be larger than buying pric
//e.
// 
//
// Example 2: 
//
// 
//Input: [7,6,4,3,1]
//Output: 0
//Explanation: In this case, no transaction is done, i.e. max profit = 0.
// 
// Related Topics 数组 动态规划 
// 👍 1243 👎 0

//题目:[121]best-time-to-buy-and-sell-stock  
package demo.leetcode.editor.cn;

public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        Solution solution = new BestTimeToBuyAndSellStock().new Solution();
        System.out.println(solution.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        Solution2 solution2 = new BestTimeToBuyAndSellStock().new Solution2();
        System.out.println(solution2.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    //时间复杂度O(n) 空间时间复杂度O(n)
    class Solution {
        public int maxProfit(int[] prices) {
            if (prices == null || prices.length == 0) {
                return 0;
            }
            int length = prices.length;
            int[][] dp = new int[length][2];
            dp[0][0] = 0;
            dp[0][1] = -prices[0];
            for (int i = 1; i < length; i++) {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
                dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
            }
            return dp[length - 1][0];
        }
    }

    //时间复杂度O(n) 空间时间复杂度O(1)
    class Solution2 {
        public int maxProfit(int[] prices) {
            if (prices == null || prices.length == 0) {
                return 0;
            }
            int profit0 = 0, profit1 = -prices[0];
            int length = prices.length;
            for (int i = 1; i < length; i++) {
                profit0 = Math.max(profit0, profit1 + prices[i]);
                profit1 = Math.max(profit1, -prices[i]);
            }
            return profit0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}