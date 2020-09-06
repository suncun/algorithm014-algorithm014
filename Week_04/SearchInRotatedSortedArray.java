//You are given an integer array nums sorted in ascending order, and an integer 
//target. 
//
// Suppose that nums is rotated at some pivot unknown to you beforehand (i.e., [
//0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]). 
//
// If target is found in the array return its index, otherwise, return -1. 
//
// 
// Example 1: 
// Input: nums = [4,5,6,7,0,1,2], target = 0
//Output: 4
// Example 2: 
// Input: nums = [4,5,6,7,0,1,2], target = 3
//Output: -1
// Example 3: 
// Input: nums = [1], target = 0
//Output: -1
// 
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 5000 
// -10^4 <= nums[i] <= 10^4 
// All values of nums are unique. 
// nums is guranteed to be rotated at some pivot. 
// -10^4 <= target <= 10^4 
// 
// Related Topics 数组 二分查找 
// 👍 930 👎 0

//题目:[33]search-in-rotated-sorted-array  
package demo.leetcode.editor.cn;

public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        Solution solution = new SearchInRotatedSortedArray().new Solution();
        System.out.println(solution.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
        System.out.println(solution.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    //二分查找 时间复杂度O(logN)
    class Solution {
        public int search(int[] nums, int target) {
            int low = 0, high = nums.length - 1, mid;
            while (low <= high) {
                mid = low + ((high - low) >> 1);
                if (target == nums[mid]) {
                    return mid;
                }
                //前半部分有序
                if (nums[low] <= nums[mid]) {
                    //target在前半部分
                    if (target >= nums[low] && target < nums[mid]) {
                        high = mid - 1;
                    } else {
                        low = mid + 1;
                    }
                } else {
                    if (target <= nums[high] && target > nums[mid]) {
                        low = mid + 1;
                    } else {
                        high = mid - 1;
                    }
                }
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}