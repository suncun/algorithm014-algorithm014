//Given a string S and a string T, count the number of distinct subsequences of 
//S which equals T. 
//
// A subsequence of a string is a new string which is formed from the original s
//tring by deleting some (can be none) of the characters without disturbing the re
//lative positions of the remaining characters. (ie, "ACE" is a subsequence of "AB
//CDE" while "AEC" is not). 
//
// It's guaranteed the answer fits on a 32-bit signed integer. 
//
// Example 1: 
//
// 
//Input: S = "rabbbit", T = "rabbit"
//Output: 3
//Explanation:
//As shown below, there are 3 ways you can generate "rabbit" from S.
//(The caret symbol ^ means the chosen letters)
//
//rabbbit
//^^^^ ^^
//rabbbit
//^^ ^^^^
//rabbbit
//^^^ ^^^
// 
//
// Example 2: 
//
// 
//Input: S = "babgbag", T = "bag"
//Output: 5
//Explanation:
//As shown below, there are 5 ways you can generate "bag" from S.
//(The caret symbol ^ means the chosen letters)
//
//babgbag
//^^ ^
//babgbag
//^^    ^
//babgbag
//^    ^^
//babgbag
//  ^  ^^
//babgbag
//    ^^^
// 
// Related Topics 字符串 动态规划 
// 👍 273 👎 0

//题目:[115]distinct-subsequences  
package demo.leetcode.editor.cn;

public class DistinctSubsequences {
    public static void main(String[] args) {
        Solution solution = new DistinctSubsequences().new Solution();
        System.out.println(solution.numDistinct("rabbbit", "rabbit"));
        System.out.println(solution.numDistinct("babgbag", "bag"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    //动态规划
    class Solution {
        public int numDistinct(String s, String t) {
            int[][] dp = new int[t.length() + 1][s.length() + 1];
            for (int j = 0; j < s.length() + 1; j++) {
                dp[0][j] = 1;
            }
            for (int i = 1; i < t.length() + 1; i++) {
                for (int j = 1; j < s.length() + 1; j++) {
                    if (t.charAt(i - 1) == s.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
                    } else {
                        dp[i][j] = dp[i][j - 1];
                    }
                }
            }
            return dp[t.length()][s.length()];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}