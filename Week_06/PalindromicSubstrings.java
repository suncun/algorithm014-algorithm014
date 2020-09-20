//Given a string, your task is to count how many palindromic substrings in this 
//string. 
//
// The substrings with different start indexes or end indexes are counted as dif
//ferent substrings even they consist of same characters. 
//
// Example 1: 
//
// 
//Input: "abc"
//Output: 3
//Explanation: Three palindromic strings: "a", "b", "c".
// 
//
// 
//
// Example 2: 
//
// 
//Input: "aaa"
//Output: 6
//Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
// 
//
// 
//
// Note: 
//
// 
// The input string length won't exceed 1000. 
// 
//
// Related Topics 字符串 动态规划 
// 👍 394 👎 0

//题目:[647]palindromic-substrings  
package demo.leetcode.editor.cn;

public class PalindromicSubstrings {
    public static void main(String[] args) {
        Solution solution = new PalindromicSubstrings().new Solution();
        System.out.println(solution.countSubstrings("abc"));
        //System.out.println(solution.countSubstrings("aaa"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    //动态规划
    //时间复杂度：O(n^2)空间复杂度：O(n^2)
    class Solution {
        public int countSubstrings(String s) {
            int res = 0;
            int len = s.length();

            // dp表示[i,j]的字符是否为回文子串
            boolean[][] dp = new boolean[len][len];

            // 计算dp[i][j]需要知道dp[i+1][j-1]
            for (int i = len - 1; i >= 0; i--) {
                for (int j = i; j < len; j++) {
                    if (s.charAt(i) == s.charAt(j) && (j - i <= 2 || dp[i + 1][j - 1])) {
                        dp[i][j] = true;
                        res++;
                    }
                }
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}