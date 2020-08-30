//
//Given n pairs of parentheses, write a function to generate all combinations of
// well-formed parentheses.
// 
//
// 
//For example, given n = 3, a solution set is:
// 
// 
//[
//  "((()))",
//  "(()())",
//  "(())()",
//  "()(())",
//  "()()()"
//]
// Related Topics 字符串 回溯算法 
// 👍 1256 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
//递归
//套用递归模版
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        _generate(n, 0, 0, "", res);
        return res;
    }

    private void _generate(int n, int left, int right, String s, List<String> res) {
        // terminator
        if (left == n && right == n) {
            // process result
            res.add(s);
            return;
        }
        // process current logic
        // drill down
        if (left < n) _generate(n, left + 1, right, s + "(", res);
        if (right < left) _generate(n, left, right + 1, s + ")", res);

    }
}

//leetcode submit region end(Prohibit modification and deletion)
