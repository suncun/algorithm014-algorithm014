//A gene string can be represented by an 8-character long string, with choices f
//rom "A", "C", "G", "T". 
//
// Suppose we need to investigate about a mutation (mutation from "start" to "en
//d"), where ONE mutation is defined as ONE single character changed in the gene s
//tring. 
//
// For example, "AACCGGTT" -> "AACCGGTA" is 1 mutation. 
//
// Also, there is a given gene "bank", which records all the valid gene mutation
//s. A gene must be in the bank to make it a valid gene string. 
//
// Now, given 3 things - start, end, bank, your task is to determine what is the
// minimum number of mutations needed to mutate from "start" to "end". If there is
// no such a mutation, return -1. 
//
// Note: 
//
// 
// Starting point is assumed to be valid, so it might not be included in the ban
//k. 
// If multiple mutations are needed, all mutations during in the sequence must b
//e valid. 
// You may assume start and end string is not the same. 
// 
//
// 
//
// Example 1: 
//
// 
//start: "AACCGGTT"
//end:   "AACCGGTA"
//bank: ["AACCGGTA"]
//
//return: 1
// 
//
// 
//
// Example 2: 
//
// 
//start: "AACCGGTT"
//end:   "AAACGGTA"
//bank: ["AACCGGTA", "AACCGCTA", "AAACGGTA"]
//
//return: 2
// 
//
// 
//
// Example 3: 
//
// 
//start: "AAAAACCC"
//end:   "AACCCCCC"
//bank: ["AAAACCCC", "AAACCCCC", "AACCCCCC"]
//
//return: 3
// 
//
// 
// 👍 49 👎 0

//题目:[433]minimum-genetic-mutation  
package demo.leetcode.editor.cn;

import java.util.HashSet;
import java.util.LinkedList;

public class MinimumGeneticMutation {
    public static void main(String[] args) {
        Solution solution = new MinimumGeneticMutation().new Solution();
        int res = solution.minMutation("AACCGGTT", "AACCGGTA", new String[]{"AACCGGTA"});
        System.out.println(res);
        int res2 = solution.minMutation("AACCGGTT", "AAACGGTA", new String[]{"AACCGGTA", "AACCGCTA", "AAACGGTA"});
        System.out.println(res2);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    //BFS
    class Solution {
        public int minMutation(String start, String end, String[] bank) {
            LinkedList<String> queue = new LinkedList<>();
            HashSet<String> visited = new HashSet<>();
            int count = 0;
            queue.offer(start);
            while (!queue.isEmpty()) {
                int levelSize = queue.size();
                for (int i = 0; i < levelSize; i++) {
                    String tmp = queue.poll();
                    if (tmp.equals(end)) {
                        return count;
                    }
                    //遍历整个基因库,访问未标记的基因；找到某个字符变异的基因添加标记，进入队列
                    for (int j = 0; j < bank.length; j++) {
                        if (visited.contains(bank[j])) {
                            continue;
                        }
                        int diff = 0;
                        for (int k = 0; k < tmp.length(); k++) {
                            if (tmp.charAt(k) != bank[j].charAt(k)) {
                                diff++;
                            }
                            if (diff > 1) {
                                diff = 0;
                                break;
                            }
                        }
                        if (diff == 1) {
                            visited.add(bank[j]);
                            queue.offer(bank[j]);
                        }

                    }
                }
                count++;
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}