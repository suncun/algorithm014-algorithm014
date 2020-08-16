//Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one
// sorted array. 
//
// Note: 
//
// 
// The number of elements initialized in nums1 and nums2 are m and n respectivel
//y. 
// You may assume that nums1 has enough space (size that is equal to m + n) to h
//old additional elements from nums2. 
// 
//
// Example: 
//
// 
//Input:
//nums1 = [1,2,3,0,0,0], m = 3
//nums2 = [2,5,6],       n = 3
//
//Output: [1,2,2,3,5,6]
// 
//
// 
// Constraints: 
//
// 
// -10^9 <= nums1[i], nums2[i] <= 10^9 
// nums1.length == m + n 
// nums2.length == n 
// 
// Related Topics 数组 双指针 
// 👍 591 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void merge(int num1[], int m, int num2[], int n) {
        for (int i = m + n - 1; i >= 0; i--) {
            if (m > 0 & n > 0) {
                if (num1[m - 1] <= num2[n - 1]) {
                    num1[i] = num2[n - 1];
                    n--;
                } else {
                    num1[i] = num1[m - 1];
                    m--;
                }
            } else {
                if (m > 0) {
                    num1[i] = num1[m - 1];
                    m--;
                }
                if (n > 0) {
                    num1[i] = num2[n - 1];
                    n--;
                }

            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
