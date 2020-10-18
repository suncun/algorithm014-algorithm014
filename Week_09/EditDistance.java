//Given two words word1 and word2, find the minimum number of operations require
//d to convert word1 to word2. 
//
// You have the following 3 operations permitted on a word: 
//
// 
// Insert a character 
// Delete a character 
// Replace a character 
// 
//
// Example 1: 
//
// 
//Input: word1 = "horse", word2 = "ros"
//Output: 3
//Explanation: 
//horse -> rorse (replace 'h' with 'r')
//rorse -> rose (remove 'r')
//rose -> ros (remove 'e')
// 
//
// Example 2: 
//
// 
//Input: word1 = "intention", word2 = "execution"
//Output: 5
//Explanation: 
//intention -> inention (remove 't')
//inention -> enention (replace 'i' with 'e')
//enention -> exention (replace 'n' with 'x')
//exention -> exection (replace 'n' with 'c')
//exection -> execution (insert 'u')
// 
// Related Topics 字符串 动态规划 
// 👍 1147 👎 0

//题目:[72]edit-distance  
package demo.leetcode.editor.cn;

public class EditDistance {
    public static void main(String[] args) {
        Solution solution = new EditDistance().new Solution();
        System.out.println(solution.minDistance("intention", "execution"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    //动态规划-自底向上
    // 时间O(mn) 空间O(mn) m为word1长度，n为word2长度
    class Solution {
        public int minDistance(String word1, String word2) {
            int m = word1.length(), n = word2.length();
            // dp[i][j] 代表 word1 到 i 位置转换成 word2 到 j 位置需要最少步数
            // 空字符处理,增加dp[0][1],dp[1][0]
            int[][] dp = new int[m + 1][n + 1];
            //边界 第一行
            for (int i = 1; i <= n; i++) {
                dp[0][i] = dp[0][i - 1] + 1;
            }
            //边界 第一列
            for (int i = 1; i <= m; i++) {
                dp[i][0] = dp[i - 1][0] + 1;
            }
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else {
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i][j - 1]), dp[i - 1][j]) + 1;
                    }
                }
            }
            return dp[m][n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}