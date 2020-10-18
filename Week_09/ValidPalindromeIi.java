//
//Given a non-empty string s, you may delete at most one character. Judge whethe
//r you can make it a palindrome.
// 
//
// Example 1: 
// 
//Input: "aba"
//Output: True
// 
// 
//
// Example 2: 
// 
//Input: "abca"
//Output: True
//Explanation: You could delete the character 'c'.
// 
// 
//
// Note: 
// 
// The string will only contain lowercase characters a-z.
//The maximum length of the string is 50000. 
// 
// Related Topics 字符串 
// 👍 276 👎 0

//题目:[680]valid-palindrome-ii  
package demo.leetcode.editor.cn;

public class ValidPalindromeIi {
    public static void main(String[] args) {
        Solution solution = new ValidPalindromeIi().new Solution();
        System.out.println(solution.validPalindrome("aba"));
        System.out.println(solution.validPalindrome("abca"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    //双指针
    class Solution {
        public boolean validPalindrome(String s) {
            int front = 0;
            int end = s.length() - 1;
            while (front < end) {
                if (s.charAt(front) != s.charAt(end)) {
                    return validPalindromeHelper(s, front + 1, end) || validPalindromeHelper(s, front, end - 1);
                }
                front++;
                end--;
            }
            return true;
        }

        public boolean validPalindromeHelper(String s, int front, int end) {
            while (front < end) {
                if (s.charAt(front) != s.charAt(end)) {
                    return false;
                }
                front++;
                end--;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}