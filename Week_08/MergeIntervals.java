//Given a collection of intervals, merge all overlapping intervals. 
//
// Example 1: 
//
// 
//Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
//Output: [[1,6],[8,10],[15,18]]
//Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
// 
//
// Example 2: 
//
// 
//Input: intervals = [[1,4],[4,5]]
//Output: [[1,5]]
//Explanation: Intervals [1,4] and [4,5] are considered overlapping. 
//
// NOTE: input types have been changed on April 15, 2019. Please reset to defaul
//t code definition to get new method signature. 
//
// 
// Constraints: 
//
// 
// intervals[i][0] <= intervals[i][1] 
// 
// Related Topics 排序 数组 
// 👍 641 👎 0

//题目:[56]merge-intervals  
package demo.leetcode.editor.cn;

import java.util.Arrays;

public class MergeIntervals {
    public static void main(String[] args) {
        Solution solution = new MergeIntervals().new Solution();
        int[][] res = solution.merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}});
        for (int[] nums : res) {
            System.out.println(nums[0] + "," + nums[1]);
        }

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    //排序
    //时间复杂度：O(nlogn)(排序)，空间复杂度：O(logn)
    class Solution {
        public int[][] merge(int[][] intervals) {
            // 先按照区间起始位置排序
            Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);

            int[][] res = new int[intervals.length][2];
            int idx = -1;
            for (int[] interval : intervals) {
                if (idx == -1 || interval[0] > res[idx][1]) {
                    res[++idx] = interval;
                } else {
                    res[idx][1] = Math.max(res[idx][1], interval[1]);
                }
            }
            return Arrays.copyOf(res, idx + 1);

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}