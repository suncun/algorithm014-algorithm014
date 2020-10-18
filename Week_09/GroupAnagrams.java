//Given an array of strings strs, group the anagrams together. You can return th
//e answer in any order. 
//
// An Anagram is a word or phrase formed by rearranging the letters of a differe
//nt word or phrase, typically using all the original letters exactly once. 
//
// 
// Example 1: 
// Input: strs = ["eat","tea","tan","ate","nat","bat"]
//Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
// Example 2: 
// Input: strs = [""]
//Output: [[""]]
// Example 3: 
// Input: strs = ["a"]
//Output: [["a"]]
// 
// 
// Constraints: 
//
// 
// 1 <= strs.length <= 104 
// 0 <= strs[i].length <= 100 
// strs[i] consists of lower-case English letters. 
// 
// Related Topics 哈希表 字符串 
// 👍 490 👎 0

//题目:[49]group-anagrams  
package demo.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
    public static void main(String[] args) {

        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        Solution solution = new GroupAnagrams().new Solution();
        System.out.println(solution.groupAnagrams(strs));
        Solution01 solution1 = new GroupAnagrams().new Solution01();
        System.out.println(solution1.groupAnagrams(strs));
        Solution02 solution2 = new GroupAnagrams().new Solution02();
        System.out.println(solution2.groupAnagrams(strs));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    // 1.排序后的字符串为HashMap的key
    // 时间复杂度O(NKLogK),空间复杂度O(NK)，N为strs长度，K为strs中字符串中最大长度
    class Solution01 {
        public List<List<String>> groupAnagrams(String[] strs) {
            HashMap<String, List<String>> res = new HashMap<String, List<String>>();
            for (int i = 0; i < strs.length; i++) {
                char[] chars = strs[i].toCharArray();
                //排序
                Arrays.sort(chars);
                String key = String.valueOf(chars);
                if (res.containsKey(key)) {
                    res.get(key).add(strs[i]);
                } else {
                    List<String> value = new ArrayList<String>();
                    value.add(strs[i]);
                    res.put(key, value);
                }

            }
            return new ArrayList(res.values());
        }
    }

    //2.前提：所有输入均为小写字母，借助字符计数，字符计数相同时为异位词
    // 时间复杂度O(NK),空间复杂度O(NK)，N为strs长度，K为strs中字符串中最大长度
    class Solution02 {
        public List<List<String>> groupAnagrams(String[] strs) {
            HashMap<String, List<String>> res = new HashMap<String, List<String>>();
            //假定所有输入均为小写字母
            int[] count = new int[26];
            for (int i = 0; i < strs.length; i++) {

                Arrays.fill(count, 0);
                for (char c : strs[i].toCharArray()) {
                    count[c - 'a']++;
                }
                StringBuffer sb = new StringBuffer();
                for (int j = 0; j < 26; j++) {
                    sb.append("#");
                    sb.append(count[j]);
                }

                String key = sb.toString();
                if (res.containsKey(key)) {
                    res.get(key).add(strs[i]);
                } else {
                    List<String> value = new ArrayList<String>();
                    value.add(strs[i]);
                    res.put(key, value);
                }

            }
            return new ArrayList(res.values());
        }
    }

    //3.使用质数相乘构造键。因质数不能分解，相乘后必然也是唯一的
    // 时间复杂度O(NK),空间复杂度O(NK)，N为strs长度，K为strs中字符串中最大长度
    // 累乘后得到key，可能存在溢出
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            HashMap<Integer, List<String>> res = new HashMap<Integer, List<String>>();
            //26个字母质数表
            int[] prime = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103};
            for (int i = 0; i < strs.length; i++) {

                int key = 1;
                //累乘得到key
                for (char c : strs[i].toCharArray()) {
                    key = key * prime[c - 'a'];
                }

                if (res.containsKey(key)) {
                    res.get(key).add(strs[i]);
                } else {
                    List<String> value = new ArrayList<String>();
                    value.add(strs[i]);
                    res.put(key, value);
                }
            }

            return new ArrayList(res.values());
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}