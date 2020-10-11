//Given two arrays arr1 and arr2, the elements of arr2 are distinct, and all ele
//ments in arr2 are also in arr1. 
//
// Sort the elements of arr1 such that the relative ordering of items in arr1 ar
//e the same as in arr2. Elements that don't appear in arr2 should be placed at th
//e end of arr1 in ascending order. 
//
// 
// Example 1: 
// Input: arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
//Output: [2,2,2,1,4,3,3,9,6,7,19]
// 
// 
// Constraints: 
//
// 
// arr1.length, arr2.length <= 1000 
// 0 <= arr1[i], arr2[i] <= 1000 
// Each arr2[i] is distinct. 
// Each arr2[i] is in arr1. 
// 
// Related Topics 排序 数组 
// 👍 82 👎 0

//题目:[1122]relative-sort-array  
package demo.leetcode.editor.cn;

public class RelativeSortArray {
    public static void main(String[] args) {
        Solution solution = new RelativeSortArray().new Solution();
        int[] res = solution.relativeSortArray(new int[]{2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19}, new int[]{2, 1, 4, 3, 9, 6});
        for (int n : res) {
            System.out.println(n);
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    //计数排序
    //时间复杂度，为O(N+m+n)，m和n为两个数组的长度，N为数组的取值范围
    class Solution {
        public int[] relativeSortArray(int[] arr1, int[] arr2) {
            int[] count = new int[1001];
            int[] res = new int[arr1.length];
            int index = 0;
            for (int item : arr1) {
                count[item]++;
            }
            for (int item : arr2) {
                while (count[item]-- > 0) {
                    res[index] = item;
                    ++index;
                }
            }
            for (int i = 0; i < 1001; ++i) {
                while (count[i]-- > 0) {
                    res[index] = i;
                    ++index;
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}