//
//Assume you are an awesome parent and want to give your children some cookies. 
//But, you should give each child at most one cookie. Each child i has a greed fac
//tor gi, which is the minimum size of a cookie that the child will be content wit
//h; and each cookie j has a size sj. If sj >= gi, we can assign the cookie j to t
//he child i, and the child i will be content. Your goal is to maximize the number
// of your content children and output the maximum number.
// 
//
// Note: 
//You may assume the greed factor is always positive. 
//You cannot assign more than one cookie to one child.
// 
//
// Example 1: 
// 
//Input: [1,2,3], [1,1]
//
//Output: 1
//
//Explanation: You have 3 children and 2 cookies. The greed factors of 3 childre
//n are 1, 2, 3. 
//And even though you have 2 cookies, since their size is both 1, you could only
// make the child whose greed factor is 1 content.
//You need to output 1.
// 
// 
//
// Example 2: 
// 
//Input: [1,2], [1,2,3]
//
//Output: 2
//
//Explanation: You have 2 children and 3 cookies. The greed factors of 2 childre
//n are 1, 2. 
//You have 3 cookies and their sizes are big enough to gratify all of the childr
//en, 
//You need to output 2.
// 
// Related Topics 贪心算法 
// 👍 195 👎 0

//题目:[455]assign-cookies  
package demo.leetcode.editor.cn;

import java.util.Arrays;

public class AssignCookies {
    public static void main(String[] args) {
        Solution solution = new AssignCookies().new Solution();
        System.out.println(solution.findContentChildren(new int[]{1, 2, 3}, new int[]{1, 1}));
        System.out.println(solution.findContentChildren(new int[]{1, 2}, new int[]{1, 2, 3}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    //贪心
    //满足度最小的孩子最容易满足，所以先满足满足度最小的孩子
    class Solution {
        public int findContentChildren(int[] g, int[] s) {
            if (g == null || s == null) {
                return 0;
            }
            Arrays.sort(g);
            Arrays.sort(s);
            int gi = 0;
            int si = 0;
            while (gi < g.length && si < s.length) {
                //因每个孩子最多只能给一块饼干，只判断当前饼干是否满足该小孩
                if (g[gi] <= s[si]) {
                    gi++;
                }
                si++;
            }
            return gi;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}