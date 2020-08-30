//Given two integers n and k, return all possible combinations of k numbers out 
//of 1 ... n. 
//
// You may return the answer in any order. 
//
// 
// Example 1: 
//
// 
//Input: n = 4, k = 2
//Output:
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//]
// 
//
// Example 2: 
//
// 
//Input: n = 1, k = 1
//Output: [[1]]
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 20 
// 1 <= k <= n 
// 
// Related Topics 回溯算法 
// 👍 338 👎 0


import java.util.ArrayList;

//leetcode submit region begin(Prohibit modification and deletion)
//回溯
//套用回溯算法模版
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (k <= 0 || n <= 0) return res;
        //track追踪解,记录走过的路径
        ArrayList<Integer> track = new ArrayList<Integer>();
        backtrack(track, n, k, 1, res);
        return res;
    }

    private void backtrack(ArrayList<Integer> track, int n, int k, int start, List<List<Integer>> res) {
        //递归终止条件
        if (track.size() == k) {
            res.add(new ArrayList<>(track));
        }
        // 遍历选择
        for (int i = start; i <= n; i++) {
            //做选择
            track.add(i);
            //递归
            backtrack(track, n, k, i + 1, res);
            //撤销选择
            track.remove(track.size() - 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
