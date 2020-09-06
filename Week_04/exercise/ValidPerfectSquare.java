//Given a positive integer num, write a function which returns True if num is a 
//perfect square else False. 
//
// Follow up: Do not use any built-in library function such as sqrt. 
//
// 
// Example 1: 
// Input: num = 16
//Output: true
// Example 2: 
// Input: num = 14
//Output: false
// 
// 
// Constraints: 
//
// 
// 1 <= num <= 2^31 - 1 
// 
// Related Topics 数学 二分查找 
// 👍 166 👎 0

//题目:[367]valid-perfect-square  
package demo.leetcode.editor.cn;

public class ValidPerfectSquare {
    public static void main(String[] args) {
        Solution solution = new ValidPerfectSquare().new Solution();
        System.out.println(solution.isPerfectSquare(64));
        System.out.println(solution.isPerfectSquare(5));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    //二分查找 时间复杂度O(logN)
    class Solution {
        public boolean isPerfectSquare(int num) {
            if (num < 2) {
                return true;
            }
            long low = 1, high = num / 2, mid;
            long square;
            while (low <= high) {
                mid = low + ((high - low) >> 1);
                square = mid * mid;
                if (square == num) {
                    return true;
                }
                if (square > num) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}