//Given two words (beginWord and endWord), and a dictionary's word list, find al
//l shortest transformation sequence(s) from beginWord to endWord, such that: 
//
// 
// Only one letter can be changed at a time 
// Each transformed word must exist in the word list. Note that beginWord is not
// a transformed word. 
// 
//
// Note: 
//
// 
// Return an empty list if there is no such transformation sequence. 
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
//Output:
//[
//  ["hit","hot","dot","dog","cog"],
//  ["hit","hot","lot","log","cog"]
//]
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
//Output: []
//
//Explanation: The endWord "cog" is not in wordList, therefore no possible trans
//formation.
// 
//
// 
// 
// Related Topics 广度优先搜索 数组 字符串 回溯算法 
// 👍 318 👎 0

//题目:[126]word-ladder-ii  
package demo.leetcode.editor.cn;

import java.util.*;

public class WordLadderIi {
    public static void main(String[] args) {
        Solution solution = new WordLadderIi().new Solution();
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
        List<String> wordList = new ArrayList<>();
        Collections.addAll(wordList, words);
        String beginWord = "hit";
        String endWord = "cog";
        List<List<String>> res = solution.findLadders(beginWord, endWord, wordList);
        System.out.println(res);

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    //BFS
    class Solution {
        public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
            List<List<String>> res = new ArrayList<>();
            Set<String> distSet = new HashSet<>(wordList);
            if (distSet.isEmpty() || !distSet.contains(endWord)) {
                return res;
            }

            //已经访问过的单词集合
            Set<String> visited = new HashSet<>();
            // 累积每一层的结果队列
            Queue<List<String>> queue = new LinkedList<>();
            List<String> list = new ArrayList<>(Arrays.asList(beginWord));
            queue.add(list);
            visited.add(beginWord);
            // 是否到达有目标单词的层
            boolean flag = false;
            while (!queue.isEmpty() && !flag) {
                int size = queue.size();
                // 该层添加的所有元素：每层必须在所有结果都添加完新的单词之后，再将这些单词统一添加到已使用单词集合
                // 如果直接添加到 visited 中，会导致该层本次结果添加之后的其他路径失败
                Set<String> subVisited = new HashSet<>();
                for (int i = 0; i < size; i++) {
                    List<String> path = queue.poll();
                    // 获取该路径上一层的单词
                    String word = path.get(path.size() - 1);
                    char[] chars = word.toCharArray();
                    // 寻找该单词的下一个符合条件的单词
                    for (int j = 0; j < chars.length; j++) {
                        char temp = chars[j];
                        for (char ch = 'a'; ch <= 'z'; ch++) {
                            chars[j] = ch;
                            if (temp == ch) {
                                continue;
                            }
                            String str = new String(chars);
                            // 在wordList中且之前的层没有使用过
                            if (distSet.contains(str) && !visited.contains(str)) {
                                // 生成新的路径
                                List<String> pathList = new ArrayList<>(path);
                                pathList.add(str);
                                if (str.equals(endWord)) {
                                    flag = true;
                                    res.add(pathList);
                                }
                                queue.add(pathList);
                                // 将该单词添加到该层已访问的单词集合中
                                subVisited.add(str);
                            }
                        }
                        chars[j] = temp;
                    }
                }
                // 将该层所有访问的单词添加到总的已访问集合中
                visited.addAll(subVisited);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}