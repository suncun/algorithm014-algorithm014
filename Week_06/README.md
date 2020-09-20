#  Week_06 学习笔记

## 动态规划 Dynamic Programming

动态规划比较适合用来求解最优问题，比如求最大值、最小值等等。它可以非常显著地降低时间复杂度，提高代码的执行效率。

动态规划适合解决的问题：**多阶段决策最优解模型**，解决问题的过程，需要经历多个决策阶段。每个决策阶段都对应着一组状态。然后寻找一组决策序列，经过这组决策序列，能够产生最终期望求解的最优值。三个特征：

1. **最优子结构**
2. **无后效性**(前面阶段的状态确定之后，不会被后面阶段的决策所改变)
3. **重复子问题**

动态规划和递归、分治没有根本上的区别（关键看有无最优子结构）

* 共性：找到关键子问题

* 差异性：动态规划有最优子结构（动态规划问题一定会具备最优子结构，才能通过子问题的最值得到原问题的最值），中途可以淘汰次优解

大部分动态规划能解决的问题，都可以通过回溯算法来解决，只不过回溯算法解决起来效率比较低(回溯算法相当于穷举搜索。穷举所有的情况，然后对比得到最优解)，时间复杂度是指数级的。动态规划算法，在执行效率方面，要高很多。尽管执行效率提高了，但是动态规划的空间复杂度也提高了，所以，很多时候，动态规划是一种空间换时间的算法思想。

## Fibonacci数列

* 暴力递归：时间复杂度O(N^2),空间复杂度O(N)

```java
			public int fib(int N) {
            if (N < 2) {
                return N;
            }
            return fib(N - 2) + fib(N - 1);
        }
```

* 记忆化搜索（带备忘录的递归）：时间复杂度O(N),空间复杂度O(N)

```java
			  public int fib(int N) {
            if (N < 2) {
                return N;
            }
            if (N < 1) return 0;
            // 备忘录全初始化为 0
            int[] memo = new int[N + 1];
            // 进行带备忘录的递归
            return helper(N, memo);
        }

        private int helper(int n, int[] memo) {
            if (n == 1 || n == 2) return 1;
            if (memo[n] != 0) return memo[n];
            memo[n] = helper(n - 1, memo) + helper(n - 2, memo);
            return memo[n];
        }
```

* 自低向上循环递推:时间复杂度O(N),空间复杂度O(N)

```java
        public int fib(int N) {
            if (N < 2) {
                return N;
            }
            int[] dp = new int[N + 1];
            dp[0] = 0;
            dp[1] = 1;
            for (int i = 2; i <= N; i++)
                dp[i] = dp[i - 1] + dp[i - 2];
            return dp[N];
        }
```

* 自低向上循环递推-优化:时间复杂度O(N),空间复杂度O(1)

根据斐波那契数列的状态转移方程，当前状态只和之前的两个状态有关，其实并不需要存储所有的状态，只要想办法存储之前的两个状态(空间压缩)

```java
       public int fib(int N) {
            if (N < 2) {
                return N;
            }
            int cur = 0, prev1 = 1, prev2 = 0;
            for (int i = 2; i <= N; i++) {
                cur = prev1 + prev2;
                prev2 = prev1;
                prev1 = cur;
            }
            return cur;
        }
```



## **动态规划关键点**

1. 最优子结构  opt[n] = best_of(opt[n-1], opt[n-2], …)

2. 储存中间状态 opt[i]

3. **递推公式(状态转移方程或者 DP 方程)**

   * Fib: opt[i] = opt[n-1] + opt[n-2] 

   * 二维路径：opt[i,j] = opt[i+1] [j] + opt[i] [j+1] (且判断a[i,j]是否空地）

解题思路：状态转移表法和状态转移方程法。

1. 状态转移表法：回溯算法实现，定义状态，画递归树，找重复子问题，画状态转移表，根据递推关系填表，将填表过程翻译成代码。
2. 状态转移方程法：找最优子结构，写状态转移方程，将状态转移方程翻译成代码

## 作业:
| 题目                                                         | 难度 | Related Topics  |
| :-----| :----: | :---- |
| [最小路径和](MinimumPathSum.java) | 中等 |数组 动态规划|
| [解码方法](DecodeWays.java) | 中等 |字符串 动态规划|
| [最大正方形](MaximalSquare.java) | 中等 |动态规划|
| [任务调度器](TaskScheduler.java) | 中等 |贪心算法 队列 数组|
| [回文子串](PalindromicSubstrings.java) | 中等 |字符串 动态规划 |
| [最长有效括号](LongestValidParentheses.java) | 困难 |字符串 动态规划 |
| [编辑距离](EditDistance.java) | 困难 |字符串 动态规划|