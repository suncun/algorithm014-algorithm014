//Given a set of distinct integers, nums, return all possible subsets (the power
// set). 
//
// Note: The solution set must not contain duplicate subsets. 
//
// Example: 
//
// 
//Input: nums = [1,2,3]
//Output:
//[
//  [3],
//  [1],
//  [2],
//  [1,2,3],
//  [1,3],
//  [2,3],
//  [1,2],
//  []
//] 
// Related Topics 位运算 数组 回溯算法 
// 👍 724 👎 0


import java.util.ArrayList;

//leetcode submit region begin(Prohibit modification and deletion)
//迭代
class Solution01 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<Integer>());
        for (int num : nums) {
            List<List<Integer>> subsets = new ArrayList<>();
            for (List<Integer> cur : res) {
                List<Integer> subset = new ArrayList<>(cur);
                subset.add(num);
                subsets.add(subset);
            }
            for (List<Integer> subset : subsets) {
                res.add(subset);
            }
        }
        return res;
    }
}

//回溯
class Solution {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(new ArrayList<>(), nums, 0, res);
        return res;
    }

    public void backtrack(List<Integer> track, int[] nums, int index, List<List<Integer>> res) {
        res.add(new ArrayList<>(track));
        for (int i = index; i < nums.length; i++) {
            track.add(nums[i]);
            backtrack(track, nums, i + 1, res);
            track.remove(track.size() - 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
