//Given a 2D board and a list of words from the dictionary, find all words in th
//e board. 
//
// Each word must be constructed from letters of sequentially adjacent cell, whe
//re "adjacent" cells are those horizontally or vertically neighboring. The same l
//etter cell may not be used more than once in a word. 
//
// 
//
// Example: 
//
// 
//Input: 
//board = [
//  ['o','a','a','n'],
//  ['e','t','a','e'],
//  ['i','h','k','r'],
//  ['i','f','l','v']
//]
//words = ["oath","pea","eat","rain"]
//
//Output: ["eat","oath"]
// 
//
// 
//
// Note: 
//
// 
// All inputs are consist of lowercase letters a-z. 
// The values of words are distinct. 
// 
// Related Topics 字典树 回溯算法 
// 👍 249 👎 0

//题目:[212]word-search-ii  
package demo.leetcode.editor.cn;

import java.util.*;

public class WordSearchIi {
    public static void main(String[] args) {
        Solution solution = new WordSearchIi().new Solution();
        List<String> words = solution.findWords(new char[][]{{'a', 'b', 'c' }, {'a', 'e', 'd' }, {'a', 'f', 'g' }},
                new String[]{"abcdefg", "gfedcbaaa", "eaabcdgfa", "befa", "dgc", "ade"});
        System.out.println(words);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    //时间复杂度O(M*4^k) M为board的格子数，k为单词平均长度
    //空间复杂度：O(N)，N是字典中的字母总数
    class Solution {

        public List<String> findWords(char[][] board, String[] words) {
            List<String> res = new ArrayList<>();
            if (board.length == 0) {
                return res;
            }
            //构建字典树
            Trie trie = new Trie();
            TrieNode root = trie.root;
            for (String s : words) {
                trie.insert(s);
            }
            Set<String> result = new HashSet<>();
            int m = board.length;
            int n = board[0].length;
            boolean[][] visited = new boolean[m][n];
            //遍历整个二维数组
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    dfs(board, visited, i, j, m, n, result, root);
                }
            }
            return new LinkedList<>(result);
        }

        private void dfs(char[][] board, boolean[][] visited, int i, int j, int m, int n, Set<String> result, TrieNode cur) {

            if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j]) {
                return;
            }
            cur = cur.child[board[i][j] - 'a'];
            visited[i][j] = true;
            if (cur == null) {
                //如果单词不匹配，回退
                visited[i][j] = false;
                return;
            }
            //找到单词
            if (cur.isEnd) {
                result.add(cur.val);
            }
            int[] rowOffset = {-1, 0, 1, 0};
            int[] colOffset = {0, 1, 0, -1};
            for (int k = 0; k < 4; k++) {
                dfs(board, visited, i + rowOffset[k], j + colOffset[k], m, n, result, cur);
            }
            visited[i][j] = false;
        }

        class TrieNode {
            TrieNode[] child;
            //记录当前节点是不是一个单词的结束字母
            boolean isEnd;
            String val;

            public TrieNode() {
                child = new TrieNode[26];
                isEnd = false;
            }
        }

        class Trie {
            private TrieNode root;

            /**
             * Initialize your data structure here.
             */
            public Trie() {
                root = new TrieNode();
            }

            /**
             * Inserts a word into the trie.
             */
            public void insert(String word) {
                TrieNode cur = root;
                for (int i = 0; i < word.length(); i++) {
                    char c = word.charAt(i);
                    if (cur.child[c - 'a'] == null) {
                        cur.child[c - 'a'] = new TrieNode();
                    }
                    //指向当前节点
                    cur = cur.child[c - 'a'];
                }
                cur.isEnd = true;
                cur.val = word;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}