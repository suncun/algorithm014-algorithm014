//Given a 2d grid map of '1's (land) and '0's (water), count the number of islan
//ds. An island is surrounded by water and is formed by connecting adjacent lands 
//horizontally or vertically. You may assume all four edges of the grid are all su
//rrounded by water. 
//
// 
// Example 1: 
//
// 
//Input: grid = [
//  ["1","1","1","1","0"],
//  ["1","1","0","1","0"],
//  ["1","1","0","0","0"],
//  ["0","0","0","0","0"]
//]
//Output: 1
// 
//
// Example 2: 
//
// 
//Input: grid = [
//  ["1","1","0","0","0"],
//  ["1","1","0","0","0"],
//  ["0","0","1","0","0"],
//  ["0","0","0","1","1"]
//]
//Output: 3
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 
// 👍 744 👎 0

//题目:[200]number-of-islands  
package demo.leetcode.editor.cn;

public class NumberOfIslands {
    public static void main(String[] args) {
        Solution solution = new NumberOfIslands().new Solution();
        char[][] grid1 = {
                {'1', '1', '1', '1', '0' },
                {'1', '1', '0', '1', '0' },
                {'1', '1', '0', '0', '0' },
                {'0', '0', '0', '0', '0' }};
        int numIslands1 = solution.numIslands(grid1);
        System.out.println(numIslands1);

        char[][] grid2 = {
                {'1', '1', '0', '0', '0' },
                {'1', '1', '0', '0', '0' },
                {'0', '0', '1', '0', '0' },
                {'0', '0', '0', '1', '1' }};
        int numIslands2 = solution.numIslands(grid2);
        System.out.println(numIslands2);

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    //并查集
    class Solution {
        public int numIslands(char[][] grid) {
            if (grid == null || grid.length == 0) {
                return 0;
            }

            int m = grid.length;
            int n = grid[0].length;
            UnionFind uf = new UnionFind(grid);
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == '1') {
                        //下侧是否有陆地
                        if (i + 1 < m && grid[i + 1][j] == '1') {
                            uf.union(i * n + j, (i + 1) * n + j);
                        }
                        //右侧是否有陆地
                        if (j + 1 < n && grid[i][j + 1] == '1') {
                            uf.union(i * n + j, i * n + j + 1);
                        }
                    }
                }
            }
            return uf.count;
        }

        class UnionFind {
            private int[] parent;
            private int count = 0;

            public UnionFind(char[][] grid) {
                int m = grid.length;
                int n = grid[0].length;
                parent = new int[m * n];
                for (int i = 0; i < m; ++i) {
                    for (int j = 0; j < n; ++j) {
                        if (grid[i][j] == '1') {
                            //二维变一维
                            parent[i * n + j] = i * n + j;
                            count++;
                        }
                    }
                }
            }

            public int find(int p) {
                while (p != parent[p]) {
                    //压缩路径
                    parent[p] = parent[parent[p]];
                    p = parent[p];
                }
                return p;
            }

            public void union(int p, int q) {
                int rootP = find(p);
                int rootQ = find(q);
                if (rootP == rootQ) return;
                parent[rootP] = rootQ;
                count--;
            }

        }
    }

    //DFS
    class Solution2 {
        private int n;
        private int m;

        public int numIslands(char[][] grid) {
            int count = 0;
            if (grid == null || grid.length == 0) return 0;
            n = grid.length;
            m = grid[0].length;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    //陆地，且没有被访问过，就可以DFS继续访问，并标记（访问过变0）
                    if (grid[i][j] == '1') {
                        dfs(grid, i, j);
                        ++count;
                    }
                }
            }
            return count;
        }

        private void dfs(char[][] grid, int i, int j) {
            if (i < 0 || j < 0 || i >= n || j >= m || grid[i][j] == '0') return;
            //陆地访问过变水
            grid[i][j] = '0';
            dfs(grid, i + 1, j);
            dfs(grid, i, j + 1);
            dfs(grid, i - 1, j);
            dfs(grid, i, j - 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}