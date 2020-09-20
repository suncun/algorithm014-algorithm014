//Given a m x n grid filled with non-negative numbers, find a path from top left
// to bottom right which minimizes the sum of all numbers along its path. 
//
// Note: You can only move either down or right at any point in time. 
//
// Example: 
//
// 
//Input:
//[
//  [1,3,1],
//  [1,5,1],
//  [4,2,1]
//]
//Output: 7
//Explanation: Because the path 1→3→1→1→1 minimizes the sum.
// 
// Related Topics 数组 动态规划 
// 👍 674 👎 0

//题目:[64]minimum-path-sum  
package demo.leetcode.editor.cn;

public class MinimumPathSum {
    public static void main(String[] args) {
        Solution solution = new MinimumPathSum().new Solution();
        System.out.println(solution.minPathSum(new int[][]{{1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    //时间复杂度O(mn)，空间复杂度O(mn)
    //DP方程grid[i][j] += Math.min( grid[i - 1][j], grid[i][j - 1] )
    class Solution {
        public int minPathSum(int[][] grid) {
            if (grid == null || grid.length == 0 || grid[0].length == 0) {
                return 0;
            }
            int rows = grid.length, columns = grid[0].length;
            int[][] dp = new int[rows][columns];
            //边界处理
            dp[0][0] = grid[0][0];
            for (int i = 1; i < rows; i++) {
                dp[i][0] = dp[i - 1][0] + grid[i][0];
            }
            for (int i = 1; i < columns; i++) {
                dp[0][i] = dp[0][i - 1] + grid[0][i];
            }
            //DP方程
            for (int i = 1; i < rows; i++) {
                for (int j = 1; j < columns; j++) {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
                }
            }
            return dp[rows - 1][columns - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}