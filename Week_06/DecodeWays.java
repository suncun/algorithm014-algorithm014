//A message containing letters from A-Z is being encoded to numbers using the fo
//llowing mapping: 
//
// 
//'A' -> 1
//'B' -> 2
//...
//'Z' -> 26
// 
//
// Given a non-empty string containing only digits, determine the total number o
//f ways to decode it. 
//
// Example 1: 
//
// 
//Input: "12"
//Output: 2
//Explanation: It could be decoded as "AB" (1 2) or "L" (12).
// 
//
// Example 2: 
//
// 
//Input: "226"
//Output: 3
//Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6)
//. 
// Related Topics 字符串 动态规划 
// 👍 502 👎 0

//题目:[91]decode-ways  
package demo.leetcode.editor.cn;

public class DecodeWays {
    public static void main(String[] args) {
        Solution solution = new DecodeWays().new Solution();
        System.out.println(solution.numDecodings("12"));
        System.out.println(solution.numDecodings("226"));
        System.out.println(solution.numDecodings("20"));
        System.out.println(solution.numDecodings("202"));
        System.out.println(solution.numDecodings("110"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    //时间复杂度O(n)，空间复杂度O(n)
    //根据字符串结尾的两个字符，推导状态方程
    class Solution {
        public int numDecodings(String s) {
            if (s == null || s.length() == 0) {
                return 0;
            }
            int[] dp = new int[s.length()];
            char[] charArray = s.toCharArray();
            if (charArray[0] == '0') {
                return 0;
            }
            dp[0] = 1;
            for (int i = 1; i < s.length(); i++) {
                if (charArray[i] != '0') {
                    dp[i] = dp[i - 1];
                }
                //[10,26]当前字符和它前一个字符，能够解码
                int num = 10 * (charArray[i - 1] - '0') + charArray[i] - '0';
                if (num >= 10 && num <= 26) {
                    if (i == 1) {
                        dp[i]++;
                    } else {
                        dp[i] += dp[i - 2];
                    }
                }
            }
            return dp[s.length() - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}