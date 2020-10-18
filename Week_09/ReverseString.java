//Write a function that reverses a string. The input string is given as an array
// of characters char[]. 
//
// Do not allocate extra space for another array, you must do this by modifying 
//the input array in-place with O(1) extra memory. 
//
// You may assume all the characters consist of printable ascii characters. 
//
// 
//
// 
// Example 1: 
//
// 
//Input: ["h","e","l","l","o"]
//Output: ["o","l","l","e","h"]
// 
//
// 
// Example 2: 
//
// 
//Input: ["H","a","n","n","a","h"]
//Output: ["h","a","n","n","a","H"]
// 
// 
// 
// Related Topics 双指针 字符串 
// 👍 317 👎 0

//题目:[344]reverse-string  
package demo.leetcode.editor.cn;

public class ReverseString {
    public static void main(String[] args) {
        Solution solution = new ReverseString().new Solution();
        char[] s = new char[]{'h', 'e', 'l', 'l', 'o'};
        solution.reverseString(s);
        System.out.println(s);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    //双指针
    //时间复杂度O(n),空间复杂度O(1)
    class Solution {
        public void reverseString(char[] s) {
            int n = s.length;
            for (int left = 0, right = n - 1; left < right; ++left, --right) {
                char tmp = s[left];
                s[left] = s[right];
                s[right] = tmp;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}