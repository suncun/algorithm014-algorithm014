# Week_09 学习笔记

## 高级动态规划
### 递归、分治、回溯、动态规划
动态规划和递归、分治没有根本上的区别（关键看有无最优子结构）
* 共性：找到关键子问题
* 差异性：动态规划有最优子结构（动态规划问题一定会具备最优子结构，才能通过子问题的最值得到原问题的最值），中途可以淘汰次优解

大部分动态规划能解决的问题，都可以通过回溯算法来解决，只不过回溯算法解决起来效率比较低，时间复杂度是指数级的。动态规划算法，在执行效率方面要高很多，但是动态规划的空间复杂度也提高了，所以，很多时候，动态规划是一种**空间换时间**的算法思想。

### 常见的DP题目和状态方程
#### 爬楼梯

[爬楼梯](ClimbingStairs.java)  `dp[i] = dp[i - 1] + dp[i - 2]`

[使用最小花费爬楼梯](MinCostClimbingStairs.java) `f[i] = cost[i] + min(f[i+1], f[i+2])`
#### 不同路径

[不同路径](UniquePaths.java)  `dp[i][j] = dp[i-1][j] + dp[i][j-1]`,`dp[i][j]` 是到达 i, j 最多路径

[不同路径2](UniquePathsIi.java) s(i,j)上有障碍物时`dp[i][j] = 0`，(i,j)上无障碍物时`dp[i][j] = dp[i-1][j] + dp[i][j-1]`

#### 打家劫舍

[打家劫舍](HouseRobber.java) `dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1])`

#### 最小路径和

[最小路径和](MinimumPathSum.java) `dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j]`

#### 股票买卖

[买卖股票的最佳时机](BestTimeToBuyAndSellStock.java) 

`dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i])`

`dp[i][1] = Math.max(dp[i - 1][1], -prices[i])`

[买卖股票的最佳时机 II](BestTimeToBuyAndSellStockIi.java)

` dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i])`

`dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i])`

## 字符串

### 字符串相关算法

* [字符串中的第一个唯一字符](FirstUniqueCharacterInAString.java)
* [反转字符串](ReverseString.java)
* [反转字符串 II ](ReverseStringIi.java)
* [有效的字母异位词](ValidAnagram.java)
* [字母异位词分组](GroupAnagrams.java)
* [验证回文串](ValidPalindrome.java)
* [验证回文字符串 Ⅱ](ValidPalindromeIi.java)

### 高级字符串算法

* 最长子串、子序列

  - [最长公共子序列](LongestCommonSubsequence.java) 

    典型的二维动态规划

    ```java
    if (t1[i - 1] == t2[j - 1]) {
        dp[i][j] = dp[i - 1][j - 1] + 1;
    } else {
        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
    }
    ```

  - [编辑距离](EditDistance.java)

    ```java
    if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
        dp[i][j] = dp[i - 1][j - 1];
    } else {
        dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i][j - 1]), dp[i - 1][j]) + 1;
    }
    ```

  - [最长回文子串](LongestPalindromicSubstring.java)

    暴力：O(N^3) 

    中间向两边扩张法：O(N^2) 

    动态规划：O(N^2)  `dp[i][j] = (s[i] == s[j]) && dp[i + 1][j - 1]`

* 字符串+递归 / DP

  - [正则表达式匹配](RegularExpressionMatching.java)
  - [通配符匹配](WildcardMatching.java)
  - [不同的子序列](DistinctSubsequences.java)

### 字符串匹配算法

* 暴力法（Brute Force） O(mn)
  暴力匹配算法，也叫朴素匹配算法
  时间复杂度是 O(n*m)

  ```java
  public static int forceSearch(String txt, String pat) {
      int M = txt.length();
      int N = pat.length();
      for (int i = 0; i <= M - N; i++) {
          int j;
          for (j = 0; j < N; j++) {
              if (txt.charAt(i + j) != pat.charAt(j))
                  break;
          }
          if (j == N)
              return i;
      }
      return -1;
  }
  ```

  

* Robin-Karp算法

  RK 算法是借助哈希算法对 BF 算法进行改造，即对每个子串分别求哈希值，然后拿子串的哈希值与模式串的哈希值比较，减少了比较的时间。所以，理想情况下，RK 算法的时间复杂度是 O(n)，跟 BF 算法相比，效率提高了很多。不过这样的效率取决于哈希算法的设计方法，如果存在冲突的情况下，时间复杂度可能会退化。极端情况下，哈希算法大量冲突，时间复杂度就退化为 O(n*m)。

  如果模式串长度为 m，主串长度为 n，那在主串中，就会有 n-m+1 个长度为 m 的子串，RK 算法的思路是：通过哈希算法对主串中的 n-m+1 个子串分别求哈希值，然后逐个与模式串的哈希值比较大小

  ```java
  //Java
  public final static int D = 256;
  public final static int Q = 9997;
  
  static int RabinKarpSerach(String txt, String pat) {
      int M = pat.length();
      int N = txt.length();
      int i, j;
      int patHash = 0, txtHash = 0;
  
      for (i = 0; i < M; i++) {
          patHash = (D * patHash + pat.charAt(i)) % Q;
          txtHash = (D * txtHash + txt.charAt(i)) % Q;
      }
  
      int highestPow = 1;  // pow(256, M-1)
      for (i = 0; i < M - 1; i++) 
          highestPow = (highestPow * D) % Q;
  
      for (i = 0; i <= N - M; i++) { // 枚举起点
          if (patHash == txtHash) {
              for (j = 0; j < M; j++) {
                  if (txt.charAt(i + j) != pat.charAt(j))
                      break;
              }
              if (j == M)
                  return i;
          }
          if (i < N - M) {
              txtHash = (D * (txtHash - txt.charAt(i) * highestPow) + txt.charAt(i + M)) % Q;
              if (txtHash < 0)
                  txtHash += Q;
          }
      }
  
      return -1;
  }
  ```

  

* KMP算法

  Knuth-Morris-Pratt算法（简称KMP）

  KMP 算法的核心思想，假设主串是 a，模式串是 b。在模式串与主串匹配的过程中，当遇到不可匹配的字符的时候，我们希望找到一些规律，可以将模式串往后多滑动几位，跳过那些肯定不会匹配的情况。

  ```java
  
  // a, b分别是主串和模式串；n, m分别是主串和模式串的长度。
  public static int kmp(char[] a, int n, char[] b, int m) {
    int[] next = getNexts(b, m);
    int j = 0;
    for (int i = 0; i < n; ++i) {
      while (j > 0 && a[i] != b[j]) { // 一直找到a[i]和b[j]
        j = next[j - 1] + 1;
      }
      if (a[i] == b[j]) {
        ++j;
      }
      if (j == m) { // 找到匹配模式串的了
        return i - m + 1;
      }
    }
    return -1;
  }
  
  // b表示模式串，m表示模式串的长度
  private static int[] getNexts(char[] b, int m) {
    int[] next = new int[m];
    next[0] = -1;
    int k = -1;
    for (int i = 1; i < m; ++i) {
      while (k != -1 && b[k + 1] != b[i]) {
        k = next[k];
      }
      if (b[k + 1] == b[i]) {
        ++k;
      }
      next[i] = k;
    }
    return next;
  }
  ```

* Boyer-Moore算法

  BM 算法核心思想是，利用模式串本身的特点，在模式串中某个字符与主串不能匹配的时候，将模式串往后多滑动几位，以此来减少不必要的字符比较，提高匹配的效率。

  BM 算法构建的规则有两类，坏字符规则和好后缀规则。好后缀规则可以独立于坏字符规则使用。因为坏字符规则的实现比较耗内存，为了节省内存，我们可以只用好后缀规则来实现 BM 算法。
