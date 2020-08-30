//Given a collection of distinct integers, return all possible permutations. 
//
// Example: 
//
// 
//Input: [1,2,3]
//Output:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//]
// 
// Related Topics 回溯算法 
// 👍 857 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
//回溯
//套用回溯算法模版
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        //track追踪解
        LinkedList<Integer> track = new LinkedList<Integer>();
        backtrack(track, nums, res);
        return res;
    }

    private void backtrack(LinkedList<Integer> track, int[] choises, List<List<Integer>> res) {
        //递归终止条件
        if (track.size() == choises.length) {
            res.add(new LinkedList<>(track));
            return;
        }
        for (int choice : choises) {
            //排除不合法选择
            if (track.contains(choice)) {
                continue;
            }
            //做选择
            track.push(choice);
            //递归
            backtrack(track, choises, res);
            //撤销选择
            track.remove();
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
