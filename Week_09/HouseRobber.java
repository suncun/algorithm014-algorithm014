//You are a professional robber planning to rob houses along a street. Each hous
//e has a certain amount of money stashed, the only constraint stopping you from r
//obbing each of them is that adjacent houses have security system connected and i
//t will automatically contact the police if two adjacent houses were broken into 
//on the same night. 
//
// Given a list of non-negative integers representing the amount of money of eac
//h house, determine the maximum amount of money you can rob tonight without alert
//ing the police. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,2,3,1]
//Output: 4
//Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
//             Total amount you can rob = 1 + 3 = 4.
// 
//
// Example 2: 
//
// 
//Input: nums = [2,7,9,3,1]
//Output: 12
//Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 
//(money = 1).
//             Total amount you can rob = 2 + 9 + 1 = 12.
// 
//
// 
// Constraints: 
//
// 
// 0 <= nums.length <= 100 
// 0 <= nums[i] <= 400 
// 
// Related Topics 动态规划 
// 👍 1117 👎 0

//题目:[198]house-robber  
package demo.leetcode.editor.cn;

public class HouseRobber {
    public static void main(String[] args) {
        Solution solution = new HouseRobber().new Solution();
        System.out.println(solution.rob(new int[]{1, 2, 3, 1}));
        System.out.println(solution.rob(new int[]{2, 7, 9, 3, 1}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int rob(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int length = nums.length;
            if (length == 1) {
                return nums[0];
            }
            int[] dp = new int[length];
            dp[0] = nums[0];
            dp[1] = Math.max(nums[0], nums[1]);
            for (int i = 2; i < length; i++) {
                dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
            }
            return dp[length - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}