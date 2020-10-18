//Given two strings text1 and text2, return the length of their longest common s
//ubsequence. 
//
// A subsequence of a string is a new string generated from the original string 
//with some characters(can be none) deleted without changing the relative order of
// the remaining characters. (eg, "ace" is a subsequence of "abcde" while "aec" is
// not). A common subsequence of two strings is a subsequence that is common to bo
//th strings. 
//
// 
//
// If there is no common subsequence, return 0. 
//
// 
// Example 1: 
//
// 
//Input: text1 = "abcde", text2 = "ace" 
//Output: 3  
//Explanation: The longest common subsequence is "ace" and its length is 3.
// 
//
// Example 2: 
//
// 
//Input: text1 = "abc", text2 = "abc"
//Output: 3
//Explanation: The longest common subsequence is "abc" and its length is 3.
// 
//
// Example 3: 
//
// 
//Input: text1 = "abc", text2 = "def"
//Output: 0
//Explanation: There is no such common subsequence, so the result is 0.
// 
//
// 
// Constraints: 
//
// 
// 1 <= text1.length <= 1000 
// 1 <= text2.length <= 1000 
// The input strings consist of lowercase English characters only. 
// 
// Related Topics 动态规划 
// 👍 259 👎 0

//题目:[1143]longest-common-subsequence  
package demo.leetcode.editor.cn;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        Solution solution = new LongestCommonSubsequence().new Solution();
        System.out.println(solution.longestCommonSubsequence("abcde", "ace"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestCommonSubsequence(String text1, String text2) {
            char[] t1 = text1.toCharArray();
            char[] t2 = text2.toCharArray();
            int length1 = t1.length;
            int length2 = t2.length;
            int[][] dp = new int[length1 + 1][length2 + 1];
            for (int i = 1; i < length1 + 1; i++) {
                for (int j = 1; j < length2 + 1; j++) {
                    //两个元素相同
                    if (t1[i - 1] == t2[j - 1]) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    }
                }
            }
            return dp[length1][length2];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}