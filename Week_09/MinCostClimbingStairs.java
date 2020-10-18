//
//On a staircase, the i-th step has some non-negative cost cost[i] assigned (0 i
//ndexed).
// 
//Once you pay the cost, you can either climb one or two steps. You need to find
// minimum cost to reach the top of the floor, and you can either start from the s
//tep with index 0, or the step with index 1.
// 
//
// Example 1: 
// 
//Input: cost = [10, 15, 20]
//Output: 15
//Explanation: Cheapest is start on cost[1], pay that cost and go to the top.
// 
// 
//
// Example 2: 
// 
//Input: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
//Output: 6
//Explanation: Cheapest is start on cost[0], and only step on 1s, skipping cost[
//3].
// 
// 
//
// Note: 
// 
// cost will have a length in the range [2, 1000]. 
// Every cost[i] will be an integer in the range [0, 999]. 
// 
// Related Topics 数组 动态规划 
// 👍 391 👎 0

//题目:[746]min-cost-climbing-stairs  
package demo.leetcode.editor.cn;

public class MinCostClimbingStairs {
    public static void main(String[] args) {
        Solution solution = new MinCostClimbingStairs().new Solution();
        System.out.println(solution.minCostClimbingStairs(new int[]{
                1, 100, 1, 1, 1, 100, 1, 1, 100, 1
        }));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    //时间复杂度O(n)空间复杂度O(1)s
    class Solution {
        public int minCostClimbingStairs(int[] cost) {
            int f1 = 0, f2 = 0;
            for (int i = cost.length - 1; i >= 0; --i) {
                int f0 = cost[i] + Math.min(f1, f2);
                f2 = f1;
                f1 = f0;
            }
            return Math.min(f1, f2);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}