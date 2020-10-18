//You are climbing a stair case. It takes n steps to reach to the top. 
//
// Each time you can either climb 1 or 2 steps. In how many distinct ways can yo
//u climb to the top? 
//
// Example 1: 
//
// 
//Input: 2
//Output: 2
//Explanation: There are two ways to climb to the top.
//1. 1 step + 1 step
//2. 2 steps
// 
//
// Example 2: 
//
// 
//Input: 3
//Output: 3
//Explanation: There are three ways to climb to the top.
//1. 1 step + 1 step + 1 step
//2. 1 step + 2 steps
//3. 2 steps + 1 step
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 45 
// 
// Related Topics 动态规划 
// 👍 1255 👎 0

//题目:[70]climbing-stairs  
package demo.leetcode.editor.cn;

public class ClimbingStairs {
    public static void main(String[] args) {
        Solution solution = new ClimbingStairs().new Solution();
        System.out.println(solution.climbStairs(10));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    //动态规划
    //时间复杂度O(n)空间复杂度O(n)
    class Solution1 {
        public int climbStairs(int n) {
            int[] dp = new int[n + 1];
            dp[0] = 1;
            dp[1] = 1;
            for (int i = 2; i <= n; i++) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
            return dp[n];
        }
    }
    //时间复杂度O(n)空间复杂度O(1)
    class Solution {
        public int climbStairs(int n) {
            int p = 0, q = 0, r = 1;
            for (int i = 1; i <= n; ++i) {
                p = q;
                q = r;
                r = p + q;
            }
            return r;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}