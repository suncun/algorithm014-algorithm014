//Write a function that takes an unsigned integer and return the number of '1' b
//its it has (also known as the Hamming weight). 
//
// 
//
// Example 1: 
//
// 
//Input: 00000000000000000000000000001011
//Output: 3
//Explanation: The input binary string 00000000000000000000000000001011 has a to
//tal of three '1' bits.
// 
//
// Example 2: 
//
// 
//Input: 00000000000000000000000010000000
//Output: 1
//Explanation: The input binary string 00000000000000000000000010000000 has a to
//tal of one '1' bit.
// 
//
// Example 3: 
//
// 
//Input: 11111111111111111111111111111101
//Output: 31
//Explanation: The input binary string 11111111111111111111111111111101 has a to
//tal of thirty one '1' bits. 
//
// 
//
// Note: 
//
// 
// Note that in some languages such as Java, there is no unsigned integer type. 
//In this case, the input will be given as signed integer type and should not affe
//ct your implementation, as the internal binary representation of the integer is 
//the same whether it is signed or unsigned. 
// In Java, the compiler represents the signed integers using 2's complement not
//ation. Therefore, in Example 3 above the input represents the signed integer -3.
// 
// 
//
// 
//
// Follow up: 
//
// If this function is called many times, how would you optimize it? 
// Related Topics 位运算 
// 👍 221 👎 0

//题目:[191]number-of-1-bits  
package demo.leetcode.editor.cn;

public class NumberOf1Bits {
    public static void main(String[] args) {
        Solution solution = new NumberOf1Bits().new Solution();
        System.out.println(solution.hammingWeight(1));
        System.out.println(solution.hammingWeight(5));
        Solution2 solution2 = new NumberOf1Bits().new Solution2();
        System.out.println(solution2.hammingWeight(1));
        System.out.println(solution2.hammingWeight(5));
        Solution3 solution3 = new NumberOf1Bits().new Solution3();
        System.out.println(solution3.hammingWeight(1));
        System.out.println(solution3.hammingWeight(5));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    //把n往右移32次，每次都和1进行与运算
    //比较32次
    public class Solution {
        // you need to treat n as an unsigned value
        public int hammingWeight(int n) {
            int count = 0;
            for (int i = 0; i < 32; i++) {
                //无符号右移,无论是正数还是负数，高位通通补0
                if ((n >>> i & 1) == 1) {
                    count++;
                }
            }
            return count;
        }
    }

    //1每次往左移一位，再和n进行与运算
    //比较32次
    public class Solution2 {
        // you need to treat n as an unsigned value
        public int hammingWeight(int n) {
            int count = 0;
            for (int i = 0; i < 32; i++) {
                if ((n & (1 << i)) != 0) {
                    count++;
                }
            }
            return count;
        }
    }

    // n和n−1与运算,清零最低位的 1
    // 比较<=32次
    public class Solution3 {
        // you need to treat n as an unsigned value
        public int hammingWeight(int n) {
            int count = 0;
            while (n != 0) {
                //n和n−1与运算,清零最低位的 1
                n &= (n - 1);
                count++;
            }
            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}