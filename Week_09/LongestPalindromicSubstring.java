//Given a string s, return the longest palindromic substring in s. 
//
// 
// Example 1: 
//
// 
//Input: s = "babad"
//Output: "bab"
//Note: "aba" is also a valid answer.
// 
//
// Example 2: 
//
// 
//Input: s = "cbbd"
//Output: "bb"
// 
//
// Example 3: 
//
// 
//Input: s = "a"
//Output: "a"
// 
//
// Example 4: 
//
// 
//Input: s = "ac"
//Output: "a"
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 1000 
// s consist of only digits and English letters (lower-case and/or upper-case), 
//
// 
// Related Topics 字符串 动态规划 
// 👍 2812 👎 0

//题目:[5]longest-palindromic-substring  
package demo.leetcode.editor.cn;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        Solution solution = new LongestPalindromicSubstring().new Solution();
        System.out.println(solution.longestPalindrome("babad"));
        System.out.println(solution.longestPalindrome("cbbd"));
        Solution2 solution2 = new LongestPalindromicSubstring().new Solution2();
        System.out.println(solution2.longestPalindrome("babad"));
        System.out.println(solution2.longestPalindrome("cbbd"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    //DP
    //时间复杂度：O(N^2) 空间复杂度：O(N^2)
    class Solution {
        public String longestPalindrome(String s) {
            int length = s.length();
            String res = "";
            boolean[][] dp = new boolean[length][length];
            for (int i = length - 1; i >= 0; i--) {
                for (int j = i; j < length; j++) {
                    //j - i < 2 长度为1或0的字符串
                    dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 2 || dp[i + 1][j - 1]);
                    if (dp[i][j] && j - i + 1 > res.length()) {
                        res = s.substring(i, j + 1);
                    }
                }
            }
            return res;
        }
    }

    //中间向两边扩张法
    //遍历每一个索引，以这个索引为中心，利用“回文串”中心对称的特点，往两边扩散，看最多能扩散多远
    //时间复杂度：O(N^2) 空间复杂度：O(N^2)
    class Solution2 {
        public String longestPalindrome(String s) {
            int length = s.length();
            if (length < 2) {
                return s;
            }
            int maxLen = 1;
            String res = s.substring(0, 1);
            // 中心位置枚举到 len - 2 即可
            for (int i = 0; i < length - 1; i++) {
                //分别考虑回文串在长度为奇数和偶数
                String oddStr = centerSpread(s, i, i);
                String evenStr = centerSpread(s, i, i + 1);
                String maxLenStr = oddStr.length() > evenStr.length() ? oddStr : evenStr;
                if (maxLenStr.length() > maxLen) {
                    maxLen = maxLenStr.length();
                    res = maxLenStr;
                }
            }
            return res;
        }

        private String centerSpread(String s, int left, int right) {
            // left = right 的时候，此时回文中心是一个字符，回文串的长度是奇数
            // right = left + 1 的时候，此时回文中心是一个空隙，回文串的长度是偶数
            int len = s.length();
            int i = left;
            int j = right;
            while (i >= 0 && j < len) {
                if (s.charAt(i) == s.charAt(j)) {
                    i--;
                    j++;
                } else {
                    break;
                }
            }
            return s.substring(i + 1, j);
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}