//Given a string, find the first non-repeating character in it and return its in
//dex. If it doesn't exist, return -1. 
//
// Examples: 
//
// 
//s = "leetcode"
//return 0.
//
//s = "loveleetcode"
//return 2.
// 
//
// 
//
// Note: You may assume the string contains only lowercase English letters. 
// Related Topics 哈希表 字符串 
// 👍 277 👎 0

//题目:[387]first-unique-character-in-a-string  
package demo.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharacterInAString {
    public static void main(String[] args) {
        Solution solution = new FirstUniqueCharacterInAString().new Solution();
        System.out.println(solution.firstUniqChar("qqaqwwssw"));
        System.out.println(solution.firstUniqChar("leetcode"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    //HashMap
    //时间复杂度O(n),空间复杂度O(n)
    class Solution {
        public int firstUniqChar(String s) {
            Map<Character, Integer> counter = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                counter.put(c, counter.getOrDefault(c, 0) + 1);
            }
            for (int i = 0; i < s.length(); i++) {
                if (counter.get(s.charAt(i)) == 1) {
                    return i;
                }
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}