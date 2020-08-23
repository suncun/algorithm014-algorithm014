//Given a non-empty array of integers, return the k most frequent elements. 
//
// Example 1: 
//
// 
//Input: nums = [1,1,1,2,2,3], k = 2
//Output: [1,2]
// 
//
// 
// Example 2: 
//
// 
//Input: nums = [1], k = 1
//Output: [1] 
// 
//
// Note: 
//
// 
// You may assume k is always valid, 1 ≤ k ≤ number of unique elements. 
// Your algorithm's time complexity must be better than O(n log n), where n is t
//he array's size. 
// It's guaranteed that the answer is unique, in other words the set of the top 
//k frequent elements is unique. 
// You can return the answer in any order. 
// 
// Related Topics 堆 哈希表 
// 👍 441 👎 0



//leetcode submit region begin(Prohibit modification and deletion)
//1.最小堆
//时间复杂度O(nlog⁡k) 空间复杂度O(n)
class Solution01 {
    public int[] topKFrequent(int[] nums, int k) {
        //HashMap字典，统计每个元素出现的次数
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        //遍历map，构造最小堆
        Queue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o1) - map.get(o2);
            }
        });
        for (Integer key : map.keySet()) {
            priorityQueue.add(key);
            //维护堆的大小为K即可
            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }

        //取出最小堆的元素
        int[] res = new int[k];
        int i = 0;
        while (!priorityQueue.isEmpty()) {
            res[i++] = priorityQueue.remove();
        }
        return res;
    }
}

//2.桶排序
//时间复杂度O(n) 空间复杂度O(n)
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        //HashMap字典，统计每个元素出现的次数
        HashMap<Integer, Integer> map = new HashMap<>(nums.length);
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        //桶排序
        //将元素频率作为数组下标
        List<Integer>[] countList = new List[nums.length + 1];
        for (Integer key : map.keySet()) {
            int i = map.get(key);
            if (countList[i] == null) {
                countList[i] = new ArrayList<>();
            }
            countList[i].add(key);
        }

        //倒序输出k个元素
        int[] res = new int[k];
        int j = 0;
        for (int i = countList.length - 1; i >= 0 && j < k; i--) {
            if (countList[i] != null) {
                for (int l = 0; l < countList[i].size(); l++) {
                    res[j++] = countList[i].get(l);
                }
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
