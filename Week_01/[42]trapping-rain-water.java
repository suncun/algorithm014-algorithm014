//Given n non-negative integers representing an elevation map where the width of
// each bar is 1, compute how much water it is able to trap after raining. 
//
// 
//The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In 
//this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos
// for contributing this image! 
//
// Example: 
//
// 
//Input: [0,1,0,2,1,0,1,3,2,1,2,1]
//Output: 6 
// Related Topics 栈 数组 双指针 
// 👍 1550 👎 0

import java.util.ArrayDeque;
import java.util.Deque;

// stack
// 当前高度小于等于栈顶高度，入栈，指针后移。
// 当前高度大于栈顶高度出栈，计算，再判断新栈顶高度与当前高度，重复，直到空栈或当前高度小于等于栈顶高度，入栈，指针后移
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int trap(int[] height) {
        Deque<Integer> stack = new ArrayDeque<>();
        int sum = 0;

        for (int i = 0; i < height.length; i++) {
            //当栈不空且当前高度大与栈顶高度，循环
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                //出栈高度
                int h = height[stack.poll()];
                //栈空，结束循环
                if (stack.isEmpty()) {
                    break;
                }
                int distance = i - stack.peek() - 1;
                int min = Math.min(height[stack.peek()], height[i]);
                sum = sum + distance * (min - h);
            }
            //当前高度位置入栈
            stack.push(i);
        }
        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
