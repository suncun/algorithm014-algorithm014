# Week_03 学习笔记

## 递归

1. 一个问题的解可以分解为几个子问题的解
2. 这个问题与分解之后的子问题，除了数据规模不同，求解思路完全一样
3. 存在递归终止条件

递归的Java代码模版

```java
public void recursion(int level, int param) {
    // terminator
    if (level > MAX_LEVEL) {
        // process result
        return;
    }
    // process current logic
    process(level, param);
    // drill down
    recur(level + 1, newParam);
    // restore current status
}
```

思维要点：重复子问题（找到最近最简方法，将其拆解成可重复解决的问题），数学归纳法思维

## 分治

分治算法（divide and conquer）的核心思想：分而治之 ，也就是将原问题划分成 n 个规模较小，并且结构与原问题相似的子问题，递归地解决这些子问题，然后再合并其结果，就得到原问题的解。

分治算法是一种处理问题的思想，递归是一种编程技巧。分治算法一般都比较适合用递归来实现。分治算法的递归实现中，每一层递归都会涉及这样三个操作：

1. 分解：将原问题分解成一系列子问题；
2. 解决：递归地求解各个子问题，若子问题足够小，则直接求解；
3. 合并：将子问题的结果合并成原问题。

## 回溯

回溯的核心: 试错思想。

回溯（backtracking）算法非常适合用**递归**来实现，在实现的过程中，**剪枝**操作是提高回溯效率的一种技巧。利用剪枝，我们并**不需要穷举**搜索所有的情况，从而提高搜索效率。

在最坏的情况下，回溯法会导致一次复杂度为指数时间的计算。


解决一个回溯问题，实际上就是一个决策树的遍历过程。一般来说，我们需要解决三个问题：

1. 路径：已经做出的选择。

2. 选择列表：当前可以做的选择。

3. 结束条件：到达决策树底层，无法再做选择的条件。

   ```java
   LinkedList result = new LinkedList();
   public void backtrack(路径，选择列表){
       if(满足结束条件){
           result.add(结果);
           return;
       }
       for(选择：选择列表){
           做出选择;
           backtrack(路径，选择列表);
           撤销选择;
       }
   }
   ```

注意：在递归之前做选择，在递归之后撤销选择

## 实战:
| 题目 | 难度 | Related Topics |
| :-----| :----: | :---- |
| [爬楼梯](exercise/[70]climbing-stairs.java) | 简单 | 动态规划 |
| [括号生成](exercise/[22]generate-parentheses.java) | 中等 | 字符串 回溯算法 |
| [翻转二叉树](exercise/[226]invert-binary-tree.java)  | 简单 | 树 |
| [验证二叉搜索树](exercise/[98]validate-binary-search-tree.java) | 中等 | 树 深度优先搜索 |
| [二叉树的最大深度](exercise/[104]maximum-depth-of-binary-tree.java)  | 简单 | 树 深度优先搜索 |
| [二叉树的最小深度](exercise/[111]minimum-depth-of-binary-tree.java) | 简单 | 树 深度优先搜索 广度优先搜索 |
| [二叉树的序列化与反序列化](exercise/[297]serialize-and-deserialize-binary-tree.java) | 困难 | 树 设计 |
| [Pow(x, n) ](exercise/[50]powx-n.java) | 中等 | 数学 二分查找 |
| [子集](exercise/[78]subsets.java) | 中等 | 位运算 数组 回溯算法 |
| [多数元素](exercise/[169]majority-element.java)  | 简单 | 位运算 数组 分治算法 |
| [电话号码的字母组合](exercise/[17]letter-combinations-of-a-phone-number.java) | 中等 | 字符串 回溯算法 |
| [N 皇后](exercise/[51]n-queens.java) | 困难 | 回溯算法        |

## 作业:
| 题目                                                         | 难度 | Related Topics  |
| :-----| :----: | :---- |
| [二叉树的最近公共祖先]([236]lowest-common-ancestor-of-a-binary-tree.java) | 中等 |树|
| [从前序与中序遍历序列构造二叉树]([105]construct-binary-tree-from-preorder-and-inorder-traversal.java) | 中等 | 树 深度优先搜索 数组 |
| [组合]([77]combinations.java) | 中等 | 回溯算法        |
| [全排列]([46]permutations.java)| 中等 | 回溯算法 |
| [全排列II]([47]permutations-ii.java) | 中等 | 回溯算法 |



