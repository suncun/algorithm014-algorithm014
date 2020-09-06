package demo.leetcode.editor.cn;
//找一个半有序数组 [4, 5, 6, 7, 0, 1, 2] 中间无序的地方
public class FindIndexRotatedSortedArray {
    public static void main(String[] args) {
        Solution solution = new FindIndexRotatedSortedArray().new Solution();
        System.out.println(solution.searchMinValueIndex(new int[]{4, 5, 6, 7, 0, 1, 2}));
        System.out.println(solution.searchMinValueIndex(new int[]{4, 5, 6, 7, 0}));
        System.out.println(solution.searchMinValueIndex(new int[]{8, 4, 5, 6, 7}));
        System.out.println(solution.searchMinValueIndex(new int[]{4, 5, 6, 7}));
        Solution2 solution2 = new FindIndexRotatedSortedArray().new Solution2();
        System.out.println(solution2.searchMinValueIndex(new int[]{4, 5, 6, 7, 0, 1, 2}));
        System.out.println(solution2.searchMinValueIndex(new int[]{4, 5, 6, 7, 0}));
        System.out.println(solution2.searchMinValueIndex(new int[]{8, 4, 5, 6, 7}));
        System.out.println(solution2.searchMinValueIndex(new int[]{4, 5, 6, 7}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    //暴力 时间复杂度O(N)
    class Solution {
        public int searchMinValueIndex(int[] nums) {
            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i] > nums[i + 1]) {
                    return i + 1;
                }
            }
            return 0;
        }
    }

    //二分查找 时间复杂度O(logN)
    class Solution2 {
        public int searchMinValueIndex(int[] nums) {
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
            return left;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}