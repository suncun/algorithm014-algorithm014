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
// 👍 1278 👎 0

//题目:[22]generate-parentheses  
package demo.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public static void main(String[] args) {
        Solution solution = new GenerateParentheses().new Solution();
        System.out.println(solution.generateParenthesis(3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    //DFS
    class Solution {
        public List<String> generateParenthesis(int n) {
            List<String> res = new ArrayList<>();
            dfs(n, 0, 0, "", res);
            return res;
        }

        private void dfs(int n, int left, int right, String s, List<String> res) {
            // terminator
            if (left == n && right == n) {
                // process result
                res.add(s);
                return;
            }
            if (left < n) dfs(n, left + 1, right, s + "(", res);
            if (left > right) dfs(n, left, right + 1, s + ")", res);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}