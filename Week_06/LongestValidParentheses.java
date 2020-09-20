//Given a string containing just the characters '(' and ')', find the length of 
//the longest valid (well-formed) parentheses substring. 
//
// Example 1: 
//
// 
//Input: "(()"
//Output: 2
//Explanation: The longest valid parentheses substring is "()"
// 
//
// Example 2: 
//
// 
//Input: ")()())"
//Output: 4
//Explanation: The longest valid parentheses substring is "()()"
// 
// Related Topics 字符串 动态规划 
// 👍 979 👎 0

//题目:[32]longest-valid-parentheses  
package demo.leetcode.editor.cn;

public class LongestValidParentheses {
    public static void main(String[] args) {
        Solution solution = new LongestValidParentheses().new Solution();
        System.out.println(solution.longestValidParentheses(")()())"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    //动态规划 时间O(n) 空间O(n)
    class Solution {
        public int longestValidParentheses(String s) {
            int maxLen = 0;
            int dp[] = new int[s.length()];
            for (int i = 1; i < s.length(); i++) {
                //s[i]是'('，以它为结尾的子串肯定不是有效括号子串,dp[i] = 0
                //s[i]是')'，考察前一个子问题的末尾s[i-1]
                if (s.charAt(i) == ')') {
                    if (s.charAt(i - 1) == '(') {
                        //s[i-1]是'('，s[i-1]和s[i]结成一对，考察s[i-2]
                        dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                    } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                        //s[i-1]是')'，跨域dp[i-1],考察s[i-dp[i-1]-1]这个字符，为'）'则dp[i]=0
                        dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                    }
                    maxLen = Math.max(maxLen, dp[i]);
                }
            }
            return maxLen;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}