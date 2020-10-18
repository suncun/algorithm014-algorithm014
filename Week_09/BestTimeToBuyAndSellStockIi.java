//Say you have an array prices for which the ith element is the price of a given
// stock on day i. 
//
// Design an algorithm to find the maximum profit. You may complete as many tran
//sactions as you like (i.e., buy one and sell one share of the stock multiple tim
//es). 
//
// Note: You may not engage in multiple transactions at the same time (i.e., you
// must sell the stock before you buy again). 
//
// Example 1: 
//
// 
//Input: [7,1,5,3,6,4]
//Output: 7
//Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 
//5-1 = 4.
//             Then buy on day 4 (price = 3) and sell on day 5 (price = 6), prof
//it = 6-3 = 3.
// 
//
// Example 2: 
//
// 
//Input: [1,2,3,4,5]
//Output: 4
//Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 
//5-1 = 4.
//             Note that you cannot buy on day 1, buy on day 2 and sell them lat
//er, as you are
//             engaging multiple transactions at the same time. You must sell be
//fore buying again.
// 
//
// Example 3: 
//
// 
//Input: [7,6,4,3,1]
//Output: 0
//Explanation: In this case, no transaction is done, i.e. max profit = 0. 
//
// 
// Constraints: 
//
// 
// 1 <= prices.length <= 3 * 10 ^ 4 
// 0 <= prices[i] <= 10 ^ 4 
// 
// Related Topics 贪心算法 数组 
// 👍 836 👎 0

//题目:[122]best-time-to-buy-and-sell-stock-ii  
package demo.leetcode.editor.cn;

public class BestTimeToBuyAndSellStockIi {
    public static void main(String[] args) {
        Solution solution = new BestTimeToBuyAndSellStockIi().new Solution();
        System.out.println(solution.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(solution.maxProfit(new int[]{1, 2, 3, 4, 5}));
        Solution2 solution2 = new BestTimeToBuyAndSellStockIi().new Solution2();
        System.out.println(solution2.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(solution2.maxProfit(new int[]{1, 2, 3, 4, 5}));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    //贪心算法
    class Solution {
        public int maxProfit(int[] prices) {
            int profit = 0;
            for (int i = 0; i < prices.length - 1; i++) {
                int diff = prices[i + 1] - prices[i];
                //今天的股价 - 昨天的股价
                //贪心算法的模型：只加正数。
                if (diff > 0) {
                    profit += diff;
                }
            }
            return profit;
        }
    }
    
    //动态规划
    //二维矩阵 dp[i][j] i:第i天，j:0持有现金/1持有股票
    class Solution2 {
        public int maxProfit(int[] prices) {
            if (prices.length < 2) {
                return 0;
            }
            //int[i][0] 持有现金
            //int[i][1] 持有股票
            int[][] dp = new int[prices.length][2];
            dp[0][0] = 0;
            dp[0][1] = -prices[0];
            for (int i = 1; i < prices.length; i++) {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            }
            return dp[prices.length - 1][0];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}