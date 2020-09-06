//Given an array of non-negative integers, you are initially positioned at the f
//irst index of the array. 
//
// Each element in the array represents your maximum jump length at that positio
//n. 
//
// Determine if you are able to reach the last index. 
//
// 
// Example 1: 
//
// 
//Input: nums = [2,3,1,1,4]
//Output: true
//Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
// 
//
// Example 2: 
//
// 
//Input: nums = [3,2,1,0,4]
//Output: false
//Explanation: You will always arrive at index 3 no matter what. Its maximum jum
//p length is 0, which makes it impossible to reach the last index.
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 3 * 10^4 
// 0 <= nums[i][j] <= 10^5 
// 
// Related Topics 贪心算法 数组 
// 👍 800 👎 0

//题目:[55]jump-game  
package demo.leetcode.editor.cn;

public class JumpGame {
    public static void main(String[] args) {
        Solution solution = new JumpGame().new Solution();
        System.out.println(solution.canJump(new int[]{2, 3, 1, 1, 4}));
        Solution2 solution2 = new JumpGame().new Solution2();
        System.out.println(solution2.canJump(new int[]{2, 3, 1, 1, 4}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    //贪心 倒着推
    class Solution {
        public boolean canJump(int[] nums) {
            int last = nums.length - 1;
            for (int i = last - 1; i >= 0; i--) {
                if (i + nums[i] >= last) {
                    last = i;
                }
            }
            return last <= 0;
        }
    }

    //贪心 顺着推
    //访问最后一个元素之前，边界一定大于等于最后一个位置
    class Solution2 {
        public boolean canJump(int[] nums) {
            int rightmost = 0;
            for (int i = 0; i < nums.length; i++) {
                if (i <= rightmost) {
                    rightmost = Math.max(rightmost, i + nums[i]);
                    if (rightmost >= nums.length - 1) {
                        return true;
                    }
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}