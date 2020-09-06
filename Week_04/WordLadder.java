//Given two words (beginWord and endWord), and a dictionary's word list, find th
//e length of shortest transformation sequence from beginWord to endWord, such tha
//t: 
//
// 
// Only one letter can be changed at a time. 
// Each transformed word must exist in the word list. 
// 
//
// Note: 
//
// 
// Return 0 if there is no such transformation sequence. 
// All words have the same length. 
// All words contain only lowercase alphabetic characters. 
// You may assume no duplicates in the word list. 
// You may assume beginWord and endWord are non-empty and are not the same. 
// 
//
// Example 1: 
//
// 
//Input:
//beginWord = "hit",
//endWord = "cog",
//wordList = ["hot","dot","dog","lot","log","cog"]
//
//Output: 5
//
//Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog
//" -> "cog",
//return its length 5.
// 
//
// Example 2: 
//
// 
//Input:
//beginWord = "hit"
//endWord = "cog"
//wordList = ["hot","dot","dog","lot","log"]
//
//Output: 0
//
//Explanation: The endWord "cog" is not in wordList, therefore no possible trans
//formation.
// 
//
// 
// 
// Related Topics 广度优先搜索 
// 👍 421 👎 0

//题目:[127]word-ladder  
package demo.leetcode.editor.cn;

import java.util.*;

public class WordLadder {
    public static void main(String[] args) {
        Solution solution = new WordLadder().new Solution();
        ArrayList<String> wordList = new ArrayList<String>(Arrays.asList(new String[]{"hot", "dot", "dog", "lot", "log", "cog"}));
        System.out.println(solution.ladderLength("hit", "cog", wordList));
        System.out.println(solution.ladderLength("hot", "dog", Arrays.asList(new String[]{"hot", "dog"})));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    //BFS
    class Solution {
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            if (!wordList.contains(endWord)) {
                return 0;
            }
            Queue<String> queue = new LinkedList<>();
            queue.offer(beginWord);
            boolean[] visited = new boolean[wordList.size()];
            int count = 0;
            while (!queue.isEmpty()) {
                int currentSize = queue.size();
                ++count;
                for (int i = 0; i < currentSize; i++) {
                    String word = queue.poll();
                    for (int j = 0; j < wordList.size(); j++) {
                        //已访问跳过
                        if (visited[j]) {
                            continue;
                        }
                        // 不能转换的直接跳过
                        if (!canConvert(word, wordList.get(j))) {
                            continue;
                        }
                        if (wordList.get(j).equals(endWord)) {
                            return count + 1;
                        }
                        visited[j] = true;
                        queue.offer(wordList.get(j));
                    }
                }
            }
            return 0;
        }

        private boolean canConvert(String s1, String s2) {
            if (s1.length() != s2.length()) {
                return false;
            }
            int count = 0;
            for (int i = 0; i < s1.length(); ++i) {
                if (s1.charAt(i) != s2.charAt(i)) {
                    ++count;
                    if (count > 1) {
                        return false;
                    }
                }
            }
            return count == 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}