//Given an input string (s) and a pattern (p), implement regular expression matc
//hing with support for '.' and '*' where: 
//
// 
// '.' Matches any single character. 
// '*' Matches zero or more of the preceding element. 
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
//Input: s = "aa", p = "a*"
//Output: true
//Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, 
//by repeating 'a' once, it becomes "aa".
// 
//
// Example 3: 
//
// 
//Input: s = "ab", p = ".*"
//Output: true
//Explanation: ".*" means "zero or more (*) of any character (.)".
// 
//
// Example 4: 
//
// 
//Input: s = "aab", p = "c*a*b"
//Output: true
//Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore, i
//t matches "aab".
// 
//
// Example 5: 
//
// 
//Input: s = "mississippi", p = "mis*is*p*."
//Output: false
// 
//
// 
// Constraints: 
//
// 
// 0 <= s.length <= 20 
// 0 <= p.length <= 30 
// s contains only lowercase English letters. 
// p contains only lowercase English letters, '.', and '*'. 
// 
// Related Topics 字符串 动态规划 回溯算法 
// 👍 1619 👎 0

//题目:[10]regular-expression-matching  
package demo.leetcode.editor.cn;

public class RegularExpressionMatching {
    public static void main(String[] args) {
        Solution solution = new RegularExpressionMatching().new Solution();
        System.out.println(solution.isMatch("aab", "c*a*b"));
        System.out.println(solution.isMatch("aa", "a"));
        System.out.println(solution.isMatch("aa", "*a"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isMatch(String text, String pattern) {
            if (text == null || pattern == null) {
                return false;
            }
            int m = text.length();
            int n = pattern.length();
            boolean[][] dp = new boolean[m + 1][n + 1];
            dp[0][0] = true;

            for (int i = 0; i <= m; ++i) {
                for (int j = 1; j <= n; ++j) {
                    if (pattern.charAt(j - 1) == '*') {
                        if (j >= 2) {
                            dp[i][j] = dp[i][j - 2];
                        }
                        if (matches(text, pattern, i, j - 1)) {
                            dp[i][j] = dp[i][j] || dp[i - 1][j];
                        }
                    } else {
                        if (matches(text, pattern, i, j)) {
                            dp[i][j] = dp[i - 1][j - 1];
                        }
                    }
                }
            }
            return dp[m][n];
        }

        public boolean matches(String s, String p, int i, int j) {
            if (i == 0 || j == 0) {
                return false;
            }
            if (p.charAt(j - 1) == '.') {
                return true;
            }
            return s.charAt(i - 1) == p.charAt(j - 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}