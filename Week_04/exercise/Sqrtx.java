//Implement int sqrt(int x). 
//
// Compute and return the square root of x, where x is guaranteed to be a non-ne
//gative integer. 
//
// Since the return type is an integer, the decimal digits are truncated and onl
//y the integer part of the result is returned. 
//
// Example 1: 
//
// 
//Input: 4
//Output: 2
// 
//
// Example 2: 
//
// 
//Input: 8
//Output: 2
//Explanation: The square root of 8 is 2.82842..., and since 
//             the decimal part is truncated, 2 is returned.
// 
// Related Topics 数学 二分查找 
// 👍 492 👎 0

//题目:[69]sqrtx  
package demo.leetcode.editor.cn;

public class Sqrtx {
    public static void main(String[] args) {
        Solution solution = new Sqrtx().new Solution();
        System.out.println(solution.mySqrt(64));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    //二分查找
    //y=x^2,x>0
    //时间复杂度O(logN)
    class Solution {
        public int mySqrt(int x) {
            if (x == 0 || x == 1) {
                return x;
            }
            long low = 1, high = x, mid;
            while (low <= high) {
                //除以 2 操作转化成位运算 low+((high-low)>>1)。因为相比除法运算来说，计算机处理位运算要快得多
                mid = low + ((high - low) >> 1);
                if (mid * mid > x) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            return (int) high;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}