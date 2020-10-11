//Given an integer n, write a function to determine if it is a power of two. 
//
// 
// Example 1: 
//
// 
//Input: n = 1
//Output: true
//Explanation: 20 = 1
// 
//
// Example 2: 
//
// 
//Input: n = 16
//Output: true
//Explanation: 24 = 16
// 
//
// Example 3: 
//
// 
//Input: n = 3
//Output: false
// 
//
// Example 4: 
//
// 
//Input: n = 4
//Output: true
// 
//
// Example 5: 
//
// 
//Input: n = 5
//Output: false
// 
//
// 
// Constraints: 
//
// 
// -231 <= n <= 231 - 1 
// 
// Related Topics 位运算 数学 
// 👍 254 👎 0

//题目:[231]power-of-two  
package demo.leetcode.editor.cn;

public class PowerOfTwo {
    public static void main(String[] args) {
        Solution solution = new PowerOfTwo().new Solution();
        System.out.println(solution.isPowerOfTwo(14));
        System.out.println(solution.isPowerOfTwo(16));
        System.out.println(solution.isPowerOfTwo(-2147483648));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPowerOfTwo(int n) {
            //n & (n-1) 清零最低位的 1
            return n > 0 && (n & (n - 1)) == 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}