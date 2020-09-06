//Let's play the minesweeper game (Wikipedia, online game)! 
//
// You are given a 2D char matrix representing the game board. 'M' represents an
// unrevealed mine, 'E' represents an unrevealed empty square, 'B' represents a re
//vealed blank square that has no adjacent (above, below, left, right, and all 4 d
//iagonals) mines, digit ('1' to '8') represents how many mines are adjacent to th
//is revealed square, and finally 'X' represents a revealed mine. 
//
// Now given the next click position (row and column indices) among all the unre
//vealed squares ('M' or 'E'), return the board after revealing this position acco
//rding to the following rules: 
//
// 
// If a mine ('M') is revealed, then the game is over - change it to 'X'. 
// If an empty square ('E') with no adjacent mines is revealed, then change it t
//o revealed blank ('B') and all of its adjacent unrevealed squares should be reve
//aled recursively. 
// If an empty square ('E') with at least one adjacent mine is revealed, then ch
//ange it to a digit ('1' to '8') representing the number of adjacent mines. 
// Return the board when no more squares will be revealed. 
// 
//
// 
//
// Example 1: 
//
// 
//Input: 
//
//[['E', 'E', 'E', 'E', 'E'],
// ['E', 'E', 'M', 'E', 'E'],
// ['E', 'E', 'E', 'E', 'E'],
// ['E', 'E', 'E', 'E', 'E']]
//
//Click : [3,0]
//
//Output: 
//
//[['B', '1', 'E', '1', 'B'],
// ['B', '1', 'M', '1', 'B'],
// ['B', '1', '1', '1', 'B'],
// ['B', 'B', 'B', 'B', 'B']]
//
//Explanation:
//
// 
//
// Example 2: 
//
// 
//Input: 
//
//[['B', '1', 'E', '1', 'B'],
// ['B', '1', 'M', '1', 'B'],
// ['B', '1', '1', '1', 'B'],
// ['B', 'B', 'B', 'B', 'B']]
//
//Click : [1,2]
//
//Output: 
//
//[['B', '1', 'E', '1', 'B'],
// ['B', '1', 'X', '1', 'B'],
// ['B', '1', '1', '1', 'B'],
// ['B', 'B', 'B', 'B', 'B']]
//
//Explanation:
//
// 
//
// 
//
// Note: 
//
// 
// The range of the input matrix's height and width is [1,50]. 
// The click position will only be an unrevealed square ('M' or 'E'), which also
// means the input board contains at least one clickable square. 
// The input board won't be a stage when game is over (some mines have been reve
//aled). 
// For simplicity, not mentioned rules should be ignored in this problem. For ex
//ample, you don't need to reveal all the unrevealed mines when the game is over, 
//consider any cases that you will win the game or flag any squares. 
// 
// Related Topics 深度优先搜索 广度优先搜索 
// 👍 169 👎 0

//题目:[529]minesweeper  
package demo.leetcode.editor.cn;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Minesweeper {
    public static void main(String[] args) {
        Solution solution = new Minesweeper().new Solution();
        char[][] input = new char[][]{
                {'E', 'E', 'E', 'E', 'E'},
                {'E', 'E', 'M', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E'}
        };
        char[][] out = solution.updateBoard(input, new int[]{3, 0});
        for (int i = 0; i < out.length; i++) {
            System.out.println(Arrays.toString(out[i]));
        }
        System.out.println("-------------------------");
        SolutionBFS solution2 = new Minesweeper().new SolutionBFS();
        char[][] out2 = solution.updateBoard(input, new int[]{3, 0});
        for (int i = 0; i < out.length; i++) {
            System.out.println(Arrays.toString(out2[i]));
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    //DFS
    class Solution {
        // 8个方向
        int[] dx = {-1, 1, 0, 0, -1, 1, -1, 1};
        int[] dy = {0, 0, -1, 1, -1, 1, 1, -1};

        public char[][] updateBoard(char[][] board, int[] click) {
            int x = click[0], y = click[1];
            // 若起点是雷，游戏结束
            if (board[x][y] == 'M') {
                board[x][y] = 'X';
            } else {
                dfs(board, x, y);
            }
            return board;
        }

        private void dfs(char[][] board, int x, int y) {
            // 递归终止条件：判断空地 (x, y) 周围是否有雷，若有，则将该位置修改为雷数，终止该路径的搜索。
            int count = 0;
            for (int k = 0; k < 8; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                if (nx < 0 || nx >= board.length || ny < 0 || ny >= board[0].length) {
                    continue;
                }
                if (board[nx][ny] == 'M') {
                    count++;
                }
            }
            if (count > 0) {
                board[x][y] = (char) (count + '0');
                return;
            }

            // 若空地 (x, y) 周围没有雷，则将该位置修改为 ‘B’，向 8 邻域的空地继续搜索。
            board[x][y] = 'B';
            for (int k = 0; k < 8; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                if (nx < 0 || nx >= board.length || ny < 0 || ny >= board[0].length || board[nx][ny] != 'E') {
                    continue;
                }
                dfs(board, nx, ny);
            }

        }
    }

    //BFS
    class SolutionBFS {
        // 8个方向
        int[] dx = {-1, 1, 0, 0, -1, 1, -1, 1};
        int[] dy = {0, 0, -1, 1, -1, 1, 1, -1};

        public char[][] updateBoard(char[][] board, int[] click) {
            // 若起点是雷，游戏结束
            int x = click[0], y = click[1];
            if (board[x][y] == 'M') {
                board[x][y] = 'X';
                return board;
            }

            int m = board.length, n = board[0].length;
            boolean[][] visited = new boolean[m][n];
            visited[x][y] = true;
            Queue<int[]> queue = new LinkedList<>();
            queue.offer(new int[]{x, y});
            while (!queue.isEmpty()) {
                int[] point = queue.poll();
                x = point[0];
                y = point[1];
                // 判断空地 (x, y) 周围是否有雷
                int cnt = 0;
                for (int k = 0; k < 8; k++) {
                    int nx = x + dx[k];
                    int ny = y + dy[k];
                    if (nx < 0 || nx >= board.length || ny < 0 || ny >= board[0].length) {
                        continue;
                    }
                    if (board[nx][ny] == 'M') {
                        cnt++;
                    }
                }
                // 若空地 (x, y) 周围有雷，则将该位置修改为雷数；否则将该位置更新为 ‘B’，并将其 8 邻域中的空地入队，继续进行 bfs 搜索
                if (cnt > 0) {
                    board[x][y] = (char) (cnt + '0');
                } else {
                    board[x][y] = 'B';
                    for (int k = 0; k < 8; k++) {
                        int nx = x + dx[k];
                        int ny = y + dy[k];
                        if (nx < 0 || nx >= board.length || ny < 0 || ny >= board[0].length
                                || board[nx][ny] != 'E' || visited[nx][ny]) {
                            continue;
                        }
                        visited[nx][ny] = true;
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }
            return board;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}