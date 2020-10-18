//
//Given a string and an integer k, you need to reverse the first k characters fo
//r every 2k characters counting from the start of the string. If there are less t
//han k characters left, reverse all of them. If there are less than 2k but greate
//r than or equal to k characters, then reverse the first k characters and left th
//e other as original.
// 
//
// Example: 
// 
//Input: s = "abcdefg", k = 2
//Output: "bacdfeg"
// 
// 
//
//Restrictions: 
// 
// The string consists of lower English letters only. 
// Length of the given string and k will in the range [1, 10000] 
// Related Topics 字符串 
// 👍 98 👎 0

//题目:[541]reverse-string-ii  
package demo.leetcode.editor.cn;

public class ReverseStringIi {
    public static void main(String[] args) {
        Solution solution = new ReverseStringIi().new Solution();
        System.out.println(solution.reverseStr("abcdefg", 2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    //时间复杂度O(n),空间复杂度O(n)
    class Solution1 {
        public String reverseStr(String s, int k) {
            char[] chars = s.toCharArray();
            for (int i = 0; i < chars.length; i += 2 * k) {
                int subStart = i, subEnd = Math.min(i + k - 1, chars.length - 1);
                while (subStart < subEnd) {
                    char tmp = chars[subStart];
                    chars[subStart++] = chars[subEnd];
                    chars[subEnd--] = tmp;
                }
            }
            return new String(chars);

        }
    }

    class Solution {
        public void reverse(char[] a, int begin, int end) {
            while (begin < end) {
                a[begin] ^= a[end];
                a[end] ^= a[begin];
                a[begin] ^= a[end];
                begin++;
                end--;
            }
        }
        public String reverseStr(String s, int k) {
            new StringBuffer(s).reverse();
            char[] chars = s.toCharArray();
            for (int i = 0; i < chars.length; i = i + 2 * k) {
                reverse(chars, i, Math.min(i + k - 1, chars.length - 1));
            }
            return new String(chars);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}