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
// 👍 240 👎 0



//leetcode submit region begin(Prohibit modification and deletion)
//1 暴力 排序 O(NlogN)
 class Solution01 {
     public boolean isAnagram(String s, String t) {
         if(s.length()!=t.length()){
             return false;
         }
         char[] char1 = s.toCharArray();
         char[] char2 = t.toCharArray();
         Arrays.sort(char1);
         Arrays.sort(char2);
         return Arrays.equals(char1,char2);
     }
 }
//2 hash Map 统计每个字符的频次-假设字符串只包含小写字母
class Solution02 {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        int[] counter = new int[26];
        for(int i = 0; i < s.length(); i++ ){
            counter[s.charAt(i) - 'a']++;
        }
        for(int i = 0; i < t.length(); i++ ){
            counter[t.charAt(i) - 'a']--;
            if(counter[t.charAt(i) - 'a'] < 0){
                return false;
            }
        }
        return true;
    }
}
//hash Map 统计每个字符的频次
class Solution03 {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> counter = new HashMap<>();
        for (char ch : s.toCharArray()) {
            counter.put(ch, counter.getOrDefault(ch, 0) + 1);
        }
        for (char ch : t.toCharArray()) {
            Integer count = counter.get(ch);
            if (count == null) {
                return false;
            } else if (count > 1) {
                counter.put(ch, count - 1);
            } else {
                counter.remove(ch);
            }
        }
        return counter.isEmpty();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
