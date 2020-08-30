//Given a collection of numbers that might contain duplicates, return all possib
//le unique permutations. 
//
// Example: 
//
// 
//Input: [1,1,2]
//Output:
//[
//  [1,1,2],
//  [1,2,1],
//  [2,1,1]
//]
// 
// Related Topics 回溯算法 
// 👍 383 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

//回溯
//套用回溯算法模版，注意剪枝
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        //track追踪解,记录走过的路径
        LinkedList<Integer> track = new LinkedList<Integer>();
        //排序
        Arrays.sort(nums);
        backtrack(track, nums, new boolean[nums.length], res);
        return res;
    }

    private void backtrack(LinkedList<Integer> track, int[] choises, boolean[] used, List<List<Integer>> res) {
        //递归终止条件
        if (track.size() == choises.length) {
            res.add(new LinkedList<>(track));
            return;
        }

        for (int i = 0; i < choises.length; i++) {
            //排除不合法选择
            if (used[i]) {
                continue;
            }
            //剪枝
            //!used[i - 1]==true,choises[i - 1]刚刚被撤销选择,choises[i]无需继续操作
            if (i > 0 && choises[i] == choises[i - 1] && !used[i - 1]) {
                continue;
            }
            //做选择
            track.push(choises[i]);
            used[i] = true;
            //递归
            backtrack(track, choises, used, res);
            //撤销选择
            track.remove();
            used[i] = false;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
