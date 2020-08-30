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
// 👍 517 👎 0


import java.util.ArrayList;

//leetcode submit region begin(Prohibit modification and deletion)
//回溯
class Solution {

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
            if (!isValide(board, row, col)) {
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

    private boolean isValide(char[][] board, int row, int col) {
        return !colSet.contains(col) && !masterSet.contains(row - col) && !slaveSet.contains(row + col);
    }

}
//leetcode submit region end(Prohibit modification and deletion)
