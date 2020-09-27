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
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    //双向BFS
    class Solution {
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            //end找begin
            int end = wordList.indexOf(endWord);
            if (end == -1) {
                return 0;
            }
            wordList.add(beginWord);

            int start = wordList.size() - 1;
            Queue<Integer> queue1 = new LinkedList<>();
            Set<Integer> visited1 = new HashSet<>();
            queue1.offer(start);
            visited1.add(start);

            Queue<Integer> queue2 = new LinkedList<>();
            Set<Integer> visited2 = new HashSet<>();
            queue2.offer(end);
            visited2.add(end);

            int count = 0;
            while (!queue1.isEmpty() && !queue2.isEmpty()) {
                count++;
                //交替，优先选择小的
                if (queue1.size() > queue2.size()) {
                    Queue<Integer> tmp = queue1;
                    queue1 = queue2;
                    queue2 = tmp;
                    Set<Integer> t = visited1;
                    visited1 = visited2;
                    visited2 = t;
                }
                int size1 = queue1.size();
                while (size1-- > 0) {
                    String s = wordList.get(queue1.poll());
                    for (int i = 0; i < wordList.size(); ++i) {
                        //已访问跳过
                        if (visited1.contains(i)) {
                            continue;
                        }
                        // 不能转换的直接跳过
                        if (!canConvert(s, wordList.get(i))) {
                            continue;
                        }
                        if (visited2.contains(i)) {
                            return count + 1;
                        }
                        visited1.add(i);
                        queue1.offer(i);
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