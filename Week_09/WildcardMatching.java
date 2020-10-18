//Given an input string (s) and a pattern (p), implement wildcard pattern matchi
//ng with support for '?' and '*' where: 
//
// 
// '?' Matches any single character. 
// '*' Matches any sequence of characters (including the empty sequence). 
// 
//
// The matching should cover the entire input string (not partial). 
//
// 
// Example 1: 
//
// 
//Input: s = "aa", p = "a"
//Output: false
//Explanation: "a" does not match the entire string "aa".
// 
//
// Example 2: 
//
// 
//Input: s = "aa", p = "*"
//Output: true
//Explanation: '*' matches any sequence.
// 
//
// Example 3: 
//
// 
//Input: s = "cb", p = "?a"
//Output: false
//Explanation: '?' matches 'c', but the second letter is 'a', which does not mat
//ch 'b'.
// 
//
// Example 4: 
//
// 
//Input: s = "adceb", p = "*a*b"
//Output: true
//Explanation: The first '*' matches the empty sequence, while the second '*' ma
//tches the substring "dce".
// 
//
// Example 5: 
//
// 
//Input: s = "acdcb", p = "a*c?b"
//Output: false
// 
//
// 
// Constraints: 
//
// 
// 0 <= s.length, p.length <= 2000 
// s contains only lowercase English letters. 
// p contains only lowercase English letters, '?' or '*'. 
// 
// Related Topics 贪心算法 字符串 动态规划 回溯算法 
// 👍 544 👎 0

//题目:[44]wildcard-matching  
package demo.leetcode.editor.cn;

public class WildcardMatching {
    public static void main(String[] args) {
        Solution solution = new WildcardMatching().new Solution();
        System.out.println(solution.isMatch("aa", "a"));
        System.out.println(solution.isMatch("aa", "*"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    //动态规划
    class Solution {
        public boolean isMatch(String s, String p) {
            int m = s.length();
            int n = p.length();
            boolean[][] dp = new boolean[m + 1][n + 1];
            dp[0][0] = true;
            for (int i = 1; i <= n; ++i) {
                if (p.charAt(i - 1) == '*') {
                    dp[0][i] = true;
                } else {
                    break;
                }
            }
            for (int i = 1; i <= m; ++i) {
                for (int j = 1; j <= n; ++j) {
                    if (p.charAt(j - 1) == '*') {
                        dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                    } else if (p.charAt(j - 1) == '?' || s.charAt(i - 1) == p.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                }
            }
            return dp[m][n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}