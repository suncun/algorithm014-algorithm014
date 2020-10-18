//Given two strings s and t , write a function to determine if t is an anagram o
//f s. 
//
// Example 1: 
//
// 
//Input: s = "anagram", t = "nagaram"
//Output: true
// 
//
// Example 2: 
//
// 
//Input: s = "rat", t = "car"
//Output: false
// 
//
// Note: 
//You may assume the string contains only lowercase alphabets. 
//
// Follow up: 
//What if the inputs contain unicode characters? How would you adapt your soluti
//on to such case? 
// Related Topics 排序 哈希表 
// 👍 249 👎 0

//题目:[242]valid-anagram  
package demo.leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;

public class ValidAnagram {
    public static void main(String[] args) {
        Solution solution = new ValidAnagram().new Solution();
        System.out.println(solution.isAnagram("ewqr", "ewrq"));
        System.out.println(solution.isAnagram("ewqrw", "ewrqe"));
        System.out.println(solution.isAnagram("ewqrw", "ewrqe"));
        Solution2 solution2 = new ValidAnagram().new Solution2();
        System.out.println(solution2.isAnagram("ewqr", "ewrq"));
        System.out.println(solution2.isAnagram("ewqrw", "ewrqe"));
        System.out.println(solution2.isAnagram("ewqrw", "ewrqe"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    //排序
    //时间复杂度：O(nlogn)
    class Solution {
        public boolean isAnagram(String s, String t) {
            if (s.length() != t.length()) {
                return false;
            }
            char[] str1 = s.toCharArray();
            char[] str2 = t.toCharArray();
            Arrays.sort(str1);
            Arrays.sort(str2);
            return Arrays.equals(str1, str2);
        }
    }

    //哈希表
    //时间复杂度：O(n)
    class Solution2 {
        public boolean isAnagram(String s, String t) {
            HashMap<Character, Integer> map = new HashMap<>();
            if (s.length() != t.length()) return false;
            for (char c : s.toCharArray()) {
                int count = 0;
                if (map.containsKey(c)) {
                    count = map.get(c);
                }
                map.put(c, ++count);
            }
            for (char c : t.toCharArray()) {

                if (map.containsKey(c)) {
                    int count = map.get(c);
                    if (count == 1) {
                        map.remove(c);
                    } else {
                        map.put(c, count - 1);
                    }
                }
            }
            if (map.isEmpty()) return true;
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}