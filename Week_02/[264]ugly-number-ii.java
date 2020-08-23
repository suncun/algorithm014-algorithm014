//Write a program to find the n-th ugly number. 
//
// Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. 
//
// Example: 
//
// 
//Input: n = 10
//Output: 12
//Explanation: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ug
//ly numbers. 
//
// Note: 
//
// 
// 1 is typically treated as an ugly number. 
// n does not exceed 1690. 
// Related Topics 堆 数学 动态规划 
// 👍 366 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
//1.动态规划
//递推：丑数 = 某较小丑数 * 某因子
class Solution01 {
    public int nthUglyNumber(int n) {
        int p2 = 0, p3 = 0, p5 = 0;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            int n2 = dp[p2] * 2;
            int n3 = dp[p3] * 3;
            int n5 = dp[p5] * 5;
            dp[i] = Math.min(Math.min(n2, n3), n5);
            if (dp[i] == n2) p2++;
            if (dp[i] == n3) p3++;
            if (dp[i] == n5) p5++;
        }
        return dp[n - 1];
    }
}

//2 利用小根堆/优先队列
class Solution {
    public int nthUglyNumber(int n) {
        int[] primes = {2, 3, 5};
        //创建小根堆
        Queue<Long> heap = new PriorityQueue<>();
        HashSet<Long> seen = new HashSet<>();
        heap.add(1L);
        seen.add(1L);
        //记录出堆丑数个数
        int count = 0;
        while (!heap.isEmpty()) {
            long currentUgly = heap.poll();
            if (++count >= n) {
                return (int) currentUgly;
            }
            for (int num : primes) {
                long nextUgly = currentUgly * num;
                //忽略重复
                if (!seen.contains(nextUgly)) {
                    seen.add(nextUgly);
                    heap.add(nextUgly);
                }
            }

        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
