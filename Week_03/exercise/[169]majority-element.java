//Given an array of size n, find the majority element. The majority element is t
//he element that appears more than ⌊ n/2 ⌋ times. 
//
// You may assume that the array is non-empty and the majority element always ex
//ist in the array. 
//
// Example 1: 
//
// 
//Input: [3,2,3]
//Output: 3 
//
// Example 2: 
//
// 
//Input: [2,2,1,1,1,2,2]
//Output: 2
// 
// Related Topics 位运算 数组 分治算法 
// 👍 720 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
//排序，数组中间的元素是所找众数
class Solution01 {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        //右移运算符，num >> 1,相当于num除以2
        return nums[nums.length >> 1];
    }
}

//分治法
//将数组分成左右两部分，分别求出左半部分的众数a1以及右半部分的众数a2，之后在a1和a2中选出正确的众数
class Solution02 {
    public int majorityElement(int[] nums) {
        return majorityElementRec(nums, 0, nums.length - 1);
    }

    private int majorityElementRec(int[] nums, int low, int high) {
        if (low == high) {
            return nums[low];
        }
        int middle = (high - low) / 2 + low;
        int left = majorityElementRec(nums, low, middle);
        int right = majorityElementRec(nums, middle + 1, high);

        if (left == right) {
            return left;
        }

        // a1和a2中选出正确的众数
        int leftCount = countInRange(nums, left, low, high);
        int rightCount = countInRange(nums, right, low, high);
        return leftCount > rightCount ? left : right;
    }

    private int countInRange(int[] nums, int num, int low, int high) {
        int count = 0;
        for (int i = low; i <= high; i++) {
            if (nums[i] == num) {
                count++;
            }
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
