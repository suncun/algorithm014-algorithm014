//Suppose an array sorted in ascending order is rotated at some pivot unknown to
// you beforehand. 
//
// (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]). 
//
// Find the minimum element. 
//
// You may assume no duplicate exists in the array. 
//
// Example 1: 
//
// 
//Input: [3,4,5,1,2] 
//Output: 1
// 
//
// Example 2: 
//
// 
//Input: [4,5,6,7,0,1,2]
//Output: 0
// 
// Related Topics 数组 二分查找 
// 👍 248 👎 0

//题目:[153]find-minimum-in-rotated-sorted-array  
package demo.leetcode.editor.cn;

public class FindMinimumInRotatedSortedArray {
    public static void main(String[] args) {
        Solution solution = new FindMinimumInRotatedSortedArray().new Solution();
        System.out.println(solution.findMin(new int[]{4, 5, 6, 7, 0, 1, 2}));
        System.out.println(solution.findMin(new int[]{4, 5, 6, 7}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    //二分查找 时间复杂度O(logN)
    class Solution {
        public int findMin(int[] nums) {
            int left = 0, right = nums.length - 1, mid;
            while (left < right) {
                mid = left + ((right - left) >> 1);
                if (nums[mid] > nums[right]) {
                    // mid不可能最小值
                    left = mid + 1;
                } else {
                    // mid可能是最小值
                    right = mid;
                }
            }
            return nums[left];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}