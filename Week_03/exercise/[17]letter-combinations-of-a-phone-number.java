//Given a string containing digits from 2-9 inclusive, return all possible lette
//r combinations that the number could represent. 
//
// A mapping of digit to letters (just like on the telephone buttons) is given b
//elow. Note that 1 does not map to any letters. 
//
// 
//
// Example: 
//
// 
//Input: "23"
//Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
// 
//
// Note: 
//
// Although the above answer is in lexicographical order, your answer could be i
//n any order you want. 
// Related Topics 字符串 回溯算法 
// 👍 896 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
//借助队列求解
class Solution01 {
    public List<String> letterCombinations(String digits) {
        //而且使用LinkedList，申请新空间方便，不会像ArrayList那样频繁扩容导致的性能低下
        LinkedList<String> res = new LinkedList<>();
        if (digits.isEmpty()) return res;
        String[] phone = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        res.add("");
        for (int i = 0; i < digits.length(); i++) {
            int num = Character.getNumericValue(digits.charAt(i));
            while (res.peek().length() == i) {
                //将之前的字符串出队，拼接的字/符
                String pre = res.poll();
                for (char s : phone[num].toCharArray()) {
                    res.add(pre + s);
                }
            }
        }
        return res;
    }
}

//回溯
class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return res;
        }
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        backTrack(new StringBuilder(), digits, map, 0, res);
        return res;
    }

    private void backTrack(StringBuilder sb, String digits, Map<Character, String> map, int index, List<String> res) {
        //递归终止
        if (sb.length() == digits.length()) {
            res.add(sb.toString());
            return;
        }

        String value = map.get(digits.charAt(index));
        for (int j = 0; j < value.length(); j++) {
            //做选择
            sb.append(value.charAt(j));
            //递归
            backTrack(sb, digits, map, index + 1, res);
            //撤销选择
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
