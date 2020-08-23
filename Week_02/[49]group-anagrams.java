//Given an array of strings, group anagrams together. 
//
// Example: 
//
// 
//Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
//Output:
//[
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//] 
//
// Note: 
//
// 
// All inputs will be in lowercase. 
// The order of your output does not matter. 
// 
// Related Topics 哈希表 字符串 


//使用HashMap，区别在于构造键的方法
//leetcode submit region begin(Prohibit modification and deletion)

//1.排序后的字符串为HashMap的key
//时间复杂度O(NKLogK),空间复杂度O(NK)，N为strs长度，K为strs中字符串中最大长度
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
//时间复杂度O(NK),空间复杂度O(NK)，N为strs长度，K为strs中字符串中最大长度
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
//时间复杂度O(NK),空间复杂度O(NK)，N为strs长度，K为strs中字符串中最大长度
//累乘后得到key，可能存在溢出
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
