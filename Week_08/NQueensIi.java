//The n-queens puzzle is the problem of placing n queens on an n×n chessboard su
//ch that no two queens attack each other. 
//
// 
//
// Given an integer n, return the number of distinct solutions to the n-queens p
//uzzle. 
//
// Example: 
//
// 
//Input: 4
//Output: 2
//Explanation: There are two distinct solutions to the 4-queens puzzle as shown 
//below.
//[
// [".Q..",  // Solution 1
//  "...Q",
//  "Q...",
//  "..Q."],
//
// ["..Q.",  // Solution 2
//  "Q...",
//  "...Q",
//  ".Q.."]
//]
// 
// Related Topics 回溯算法 
// 👍 152 👎 0

//题目:[52]n-queens-ii  
package demo.leetcode.editor.cn;

public class NQueensIi {
    public static void main(String[] args) {
        Solution solution = new NQueensIi().new Solution();
        System.out.println(solution.totalNQueens(4));
        System.out.println(solution.totalNQueens(8));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    //位运算+DFS
    class Solution {
        private int size;
        private int count;

        private void solve(int row, int ld, int rd) {
            // row的所有位都为1，即找到了一个成功的布局
            if (row == size) {
                count++;
                return;
            }
            // 求取当前哪些列可以放置皇后:
            // row，ld，rd进行“或”运算，求得所有可以放置皇后的列,对应位为0，
            // 然后再取反后“与”上全1的数，求得当前所有可以放置皇后的位置，对应列改为1
            int pos = size & (~(row | ld | rd));
            while (pos != 0) {
                //x & -x 除最后一位 1 保留，其它位全部为 0
                //取得可以放皇后的最右边的列
                int p = pos & (-pos);
                //x & (x - 1) 将最后一位 1 变成 0
                //获取下一次的最右可用列使用做准备,将来会回溯到这个位置继续试探
                pos &= pos - 1;
                // (ld + p) << 1，标记当前皇后左边相邻的列不允许下一个皇后放置
                // (ld + p) >> 1，标记当前皇后右边相邻的列不允许下一个皇后放置
                solve(row | p, (ld | p) << 1, (rd | p) >> 1);
            }
        }

        public int totalNQueens(int n) {
            count = 0;
            //生成n个1组成的二进制数
            size = (1 << n) - 1;
            solve(0, 0, 0);
            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}