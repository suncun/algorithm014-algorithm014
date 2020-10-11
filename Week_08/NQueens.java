//The n-queens puzzle is the problem of placing n queens on an n×n chessboard su
//ch that no two queens attack each other. 
//
// 
//
// Given an integer n, return all distinct solutions to the n-queens puzzle. 
//
// Each solution contains a distinct board configuration of the n-queens' placem
//ent, where 'Q' and '.' both indicate a queen and an empty space respectively. 
//
// Example: 
//
// 
//Input: 4
//Output: [
// [".Q..",  // Solution 1
//  "...Q",
//  "Q...",
//  "..Q."],
//
// ["..Q.",  // Solution 2
//  "Q...",
//  "...Q",
//  ".Q.."]
//]
//Explanation: There exist two distinct solutions to the 4-queens puzzle as show
//n above.
// 
// Related Topics 回溯算法 
// 👍 629 👎 0

//题目:[51]n-queens  
package demo.leetcode.editor.cn;

import java.util.*;

public class NQueens {
    public static void main(String[] args) {
        Solution solution = new NQueens().new Solution();
        Solution2 solution2 = new NQueens().new Solution2();
        System.out.println(solution.solveNQueens(4));
        System.out.println(solution2.solveNQueens(4));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    //位运算
    class Solution {
        private List<List<String>> res = new LinkedList<>();
        char[][] board;
        private int size;
        List<String> item = new ArrayList<>();

        public List<List<String>> solveNQueens(int n) {
            board = new char[n][n];
            for (int i = 0; i < n; i++) {
                Arrays.fill(board[i], '.');

            }
            size = (1 << n) - 1;
            solve(0, 0, 0, 0, n);
            return res;
        }

        private void solve(int row, int ld, int rd, int k, int n) {
            // row的所有位都为1，即找到了一个成功的布局
            if (row == size) {
                res.add(new ArrayList<>(item));
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
                int index = n - (int) (Math.log(p) / Math.log(2)) - 1;
                board[k][index] = 'Q';
                item.add(new String(board[k]));
                //x & (x - 1) 将最后一位 1 变成 0
                //获取下一次的最右可用列使用做准备,将来会回溯到这个位置继续试探
                pos &= pos - 1;
                // (ld + p) << 1，标记当前皇后左边相邻的列不允许下一个皇后放置
                // (ld + p) >> 1，标记当前皇后右边相邻的列不允许下一个皇后放置
                solve(row | p, (ld | p) << 1, (rd | p) >> 1, k + 1, n);
                board[k][index] = '.';
                item.remove(item.size() - 1);
            }
        }
    }

    //回溯算法
    class Solution2 {
        private List<List<String>> res = new LinkedList<>();
        private Set<Integer> colSet = new HashSet<>();
        private Set<Integer> masterSet = new HashSet<>();
        private Set<Integer> slaveSet = new HashSet<>();

        public List<List<String>> solveNQueens(int n) {
            char[][] board = new char[n][n];
            for (char[] chars : board) Arrays.fill(chars, '.');
            backtrack(board, 0);
            return res;
        }

        private void backtrack(char[][] board, int row) {
            if (row == board.length) {
                res.add(charToString(board));
                return;
            }
            for (int col = 0; col < board[row].length; col++) {
                //排除不合法的选择
                if (!isValid(board, row, col)) {
                    continue;
                }
                //做选择
                updateRecords(board, row, col);
                backtrack(board, row + 1);
                //撤销选择
                updateRecords(board, row, col);
            }
        }

        private void updateRecords(char[][] board, int row, int col) {
            if (colSet.contains(col)) {
                board[row][col] = '.';
                colSet.remove(col);
                masterSet.remove(row - col);
                slaveSet.remove(row + col);
            } else {
                board[row][col] = 'Q';
                colSet.add(col);
                masterSet.add(row - col);
                slaveSet.add(row + col);
            }
        }

        private boolean isValid(char[][] board, int row, int col) {
            return !colSet.contains(col) && !masterSet.contains(row - col) && !slaveSet.contains(row + col);
        }

        private List<String> charToString(char[][] boardChar) {
            List<String> board = new ArrayList<>();
            for (int i = 0; i < boardChar.length; i++) {
                StringBuilder temp = new StringBuilder();
                for (int j = 0; j < boardChar.length; j++) {
                    temp.append(boardChar[i][j]);
                }
                board.add(temp.toString());
            }
            return board;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}