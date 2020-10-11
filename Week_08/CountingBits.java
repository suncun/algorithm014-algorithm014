//Given a non negative integer number num. For every numbers i in the range 0 ≤ 
//i ≤ num calculate the number of 1's in their binary representation and return th
//em as an array. 
//
// Example 1: 
//
// 
//Input: 2
//Output: [0,1,1] 
//
// Example 2: 
//
// 
//Input: 5
//Output: [0,1,1,2,1,2]
// 
//
// Follow up: 
//
// 
// It is very easy to come up with a solution with run time O(n*sizeof(integer))
//. But can you do it in linear time O(n) /possibly in a single pass? 
// Space complexity should be O(n). 
// Can you do it like a boss? Do it without using any builtin function like __bu
//iltin_popcount in c++ or in any other language. 
// Related Topics 位运算 动态规划 
// 👍 425 👎 0

//题目:[338]counting-bits  
package demo.leetcode.editor.cn;

import java.util.Arrays;

public class CountingBits {
    public static void main(String[] args) {
        Solution solution = new CountingBits().new Solution();
        for (int n : solution.countBits(5)) {
            System.out.println(n);
        }

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    //动态规划 + 最后设置位(最后设置位是从右到左第一个为1的位)
    //时间复杂度：O(n),空间复杂度：O(n)
    class Solution {
        public int[] countBits(int num) {
            int[] bits = new int[num + 1];
            for (int i = 1; i <= num; i++) {
                //X & (X-1) 清零最低位的 1 
                bits[i] += bits[i & (i - 1)] + 1;
            }
            return bits;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}