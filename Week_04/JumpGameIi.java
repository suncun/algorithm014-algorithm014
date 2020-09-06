//Given an array of non-negative integers, you are initially positioned at the f
//irst index of the array. 
//
// Each element in the array represents your maximum jump length at that positio
//n. 
//
// Your goal is to reach the last index in the minimum number of jumps. 
//
// Example: 
//
// 
//Input: [2,3,1,1,4]
//Output: 2
//Explanation: The minimum number of jumps to reach the last index is 2.
//    Jump 1 step from index 0 to 1, then 3 steps to the last index. 
//
// Note: 
//
// You can assume that you can always reach the last index. 
// Related Topics 贪心算法 数组 
// 👍 685 👎 0

//题目:[45]jump-game-ii  
package demo.leetcode.editor.cn;

public class JumpGameIi {
    public static void main(String[] args) {
        Solution solution = new JumpGameIi().new Solution();
        System.out.println(solution.jump(new int[]{2, 3, 1, 1, 4}));
        Solution2 solution2 = new JumpGameIi().new Solution2();
        System.out.println(solution2.jump(new int[]{2, 3, 1, 1, 4}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    //贪心 倒着推 时间复杂度O(n^2)
    class Solution {
        public int jump(int[] nums) {
            int last = nums.length - 1;
            int steps = 0;
            while (last > 0) {
                //找前一个位置，选择离last最远的i。即满足条件的最小i
                for (int i = 0; i < last; i++) {
                    if (i + nums[i] >= last) {
                        last = i;
                        steps++;
                        break;
                    }
                }
            }
            return steps;
        }
    }

    //贪心 顺着推 时间复杂度O(n)
    class Solution2 {
        public int jump(int[] nums) {
            int end = 0;
            int rightmost = 0;
            int steps = 0;
            for (int i = 0; i < nums.length - 1; i++) {
                //找到跳的最远的
                rightmost = Math.max(rightmost, nums[i] + i);
                //遇到边界，就更新边界，步数加一
                if (i == end) {
                    end = rightmost;
                    steps++;
                }
            }
            return steps;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}