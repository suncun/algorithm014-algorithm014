//Given a string, determine if it is a palindrome, considering only alphanumeric
// characters and ignoring cases. 
//
// Note: For the purpose of this problem, we define empty string as valid palind
//rome. 
//
// Example 1: 
//
// 
//Input: "A man, a plan, a canal: Panama"
//Output: true
// 
//
// Example 2: 
//
// 
//Input: "race a car"
//Output: false
// 
//
// 
// Constraints: 
//
// 
// s consists only of printable ASCII characters. 
// 
// Related Topics 双指针 字符串 
// 👍 283 👎 0

//题目:[125]valid-palindrome  
package demo.leetcode.editor.cn;

public class ValidPalindrome {
    public static void main(String[] args) {
        Solution solution = new ValidPalindrome().new Solution();
        System.out.println(solution.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(solution.isPalindrome("race a car"));
        Solution2 solution2 = new ValidPalindrome().new Solution2();
        System.out.println(solution2.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(solution2.isPalindrome("race a car"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    //双指针
    class Solution {
        public boolean isPalindrome(String s) {
            StringBuffer stringBuffer = new StringBuffer();
            int length = s.length();
            for (int i = 0; i < length; i++) {
                char ch = s.charAt(i);
                if (Character.isLetterOrDigit(ch)) {
                    stringBuffer.append(Character.toLowerCase(ch));
                }
            }
            int n = stringBuffer.length();
            int left = 0, right = n - 1;
            while (left < right) {
                if (Character.toLowerCase(stringBuffer.charAt(left)) != Character.toLowerCase(stringBuffer.charAt(right))) {
                    return false;
                }
                ++left;
                --right;
            }
            return true;
        }
    }

    //在原字符串上直接判断
    class Solution2 {
        public boolean isPalindrome(String s) {
            int n = s.length();
            int left = 0, right = n - 1;
            while (left < right) {
                while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                    ++left;
                }
                while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                    --right;
                }
                if (left < right) {
                    if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                        return false;
                    }
                    ++left;
                    --right;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}