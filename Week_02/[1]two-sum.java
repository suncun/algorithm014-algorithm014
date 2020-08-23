//Given an array of integers, return indices of the two numbers such that they a
//dd up to a specific target. 
//
// You may assume that each input would have exactly one solution, and you may n
//ot use the same element twice. 
//
// Example: 
//
// 
//Given nums = [2, 7, 11, 15], target = 9,
//
//Because nums[0] + nums[1] = 2 + 7 = 9,
//return [0, 1].
// 
// Related Topics 数组 哈希表 
// 👍 8875 👎 0

import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
//暴力 时间复杂度O(N^2) 空间复杂度O(1)
class Solution01 {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1 ; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if(nums[j] == target - nums[i]){
                    return new int[] { i, j };
                }
            }
        }
        return null;
    }
}
//哈希表 时间复杂度O(N) 空间复杂度O(N)
class Solution02 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(target - nums[i])) {
                return new int[]{hashMap.get(target - nums[i]), i};
            }
            hashMap.put(nums[i], i);
        }
        return null;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
