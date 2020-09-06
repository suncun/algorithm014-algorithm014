# Week_03 学习笔记

## 深度优先搜索DFS

深度优先模版-递归

```java
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> allResults = new ArrayList<>();
        if (root == null) {
            return allResults;
        }
        travel(root, 0, allResults);
        return allResults;
    }

    private void travel(TreeNode root, int level, List<List<Integer>> results) {
        if (results.size() == level) {
            results.add(new ArrayList<>());
        }
        results.get(level).add(root.val);
        if (root.left != null) {
            travel(root.left, level + 1, results);
        }
        if (root.right != null) {
            travel(root.right, level + 1, results);
        }
    }
```

深度优先模版-非递归

```java
    //借助堆栈
    public static void dfs(TreeNode root){
        Stack<TreeNode> stack = new Stack<TreeNode>(); 
        if(root == null)
            return;
        stack.push(root);
        while(!stack.isEmpty()){ //若栈非空
            TreeNode node = stack.pop();
            System.out.print(node.val + " ");
            if(node.right != null) //先将右孩子结点压入堆栈
                stack.push(node.right);
            if(node.left != null) //然后将左孩子结点压入堆栈
                stack.push(node.left);
        }
    }
```

## 广度优先搜索BFS

广度优先模版

```java
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
//借助队列
public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> allResults = new ArrayList<>();
    if (root == null) {
        return allResults;
    }
    Queue<TreeNode> nodes = new LinkedList<>();
    nodes.add(root);
    while (!nodes.isEmpty()) {
        int size = nodes.size();
        List<Integer> results = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            TreeNode node = nodes.poll();
            results.add(node.val);
            if (node.left != null) {
                nodes.add(node.left);
            }
            if (node.right != null) {
                nodes.add(node.right);
            }
        }
        allResults.add(results);
    }
    return allResults;
}
```



## 贪心算法

贪心算法（Greedy）是一种在每一步选择中都采取在当前状态下最好或最优（即最有利）的选择，从而希望导致结果是全局最好或最优的算法。 

区分贪心算法与动态规划

* 贪心：当下做局部最优判断
* 回溯：能够回退
* 动态规划：最优判断 + **回退**

贪心算法经典的应用：霍夫曼编码（Huffman Coding）、Prim 和 Kruskal 最小生成树算法、 Dijkstra 单源最短路径算法。简单地说，问题能够分解成子问题来解决，子问题的最优解能递推到最终问题的最优解。这种子问题最优解称为最优子结构。当我们看到这类问题的时候，首先要联想到贪心算法；尝试看下这个问题是否可以用贪心算法解决；举几个例子看下贪心算法产生的结果是否是最优的。（从实践的角度来说，大部分能用贪心算法解决的问题，贪心算法的正确性都是显而易见的，也不需要严格的数学推导证明。）

贪心算法的最难的是如何将要解决的问题抽象成贪心算法模型。**多练习**

## 二分查找

二分查找前提：

1. 目标函数单调性（单调递增或者递减）
2. 存在上下界（bounded）
3. 能够通过索引访问（index accessible)

二分查找的核心思想理解起来非常简单，有点类似分治思想。即每次都通过跟区间中的中间元素对比，将待查找的区间缩小为一半，直到找到要查找的元素，或者区间被缩小为 0。二分查找时间复杂度是 O(logn)

二分查找代码模版（有序数组中不存在重复元素，找到要查找元素）：

```java
public int bsearch(int[] a, int n, int value) {
  int low = 0;
  int high = n - 1;
  while (low <= high) {
    //int mid = (low + high) / 2;
    //除以 2 操作转化成位运算 low+((high-low)>>1)。因为相比除法运算来说，计算机处理位运算要快得多
    int mid = low + ((high - low) >> 1);
    if (a[mid] == value) {
      return mid;
    } else if (a[mid] < value) {
      low = mid + 1;
    } else {
      high = mid - 1;
    }
  }

  return -1;
}
```

掌握它的三个容易出错的地方：**循环退出条件、mid 的取值，low 和 high 的更新**

### 找一个半有序数组 [4, 5, 6, 7, 0, 1, 2] 中间无序的地方

前提：该数组为半升序数组

思路：旋转的第一个元素一定是最小的元素，而它的前一个元素则是最大的元素，它也是唯一一个前一个元素大于当前的，其他都是按升序排列。

[代码](FindIndexRotatedSortedArray.java)

**暴力法**
中间无序的地方，前一个元素大于当前的。遍历半有序数组元素，然后对元素i及后边一个元素i+1比较。时间复杂度O(N)

**二分查找**

不断收缩左边界或右边界，时间复杂度O(logN)

```java
        public int searchMinValueIndex(int[] nums) {
            int left = 0, right = nums.length - 1, mid;
            while (left < right) {
                mid = left + ((right - left) >> 1);
                //while循环内nums[mid]要么大于要么小于nums[right]，不会等于
                if (nums[mid] > nums[right]) {
                    // 中值 > 右值，最小值在右半边，收缩左边界
                    // 中值 > 右值，mid不可能最小值，left可以跨过mid，为mid+1
                    left = mid + 1;
                } else if (nums[mid] < nums[right]) {
                    // 中值 < 右值，最小值在左半边，收缩右边界
                    // 中值 < 右值，mid可能是最小值，right不能阔过mid，right取边界到mid
                    right = mid;
                }
            }
            return left;
```

## 实战
| 题目 | 难度 | Related Topics |
| :-----| :----: | :---- |
| [二叉树的层序遍历](exercise/BinaryTreeLevelOrderTraversal.java) | 简单 | 树 广度优先搜索 |
| [最小基因变化](exercise/MinimumGeneticMutation.java) | 中等 | 广度优先搜索 |
| [括号生成](exercise/GenerateParentheses.java) | 中等 | 字符串 回溯算法 |
| [在每个树行中找最大值](exercise/FindLargestValueInEachTreeRow.java) | 中等 | 树 深度优先搜索 广度优先搜索 |
| [x 的平方根](exercise/Sqrtx.java) | 简单 | 数学 二分查找 |
| [有效的完全平方数](exercise/ValidPerfectSquare.java) | 简单 | 数学 二分查找 |

## 作业
| 题目 | 难度 | Related Topics |
| :-----| :----: | :---- |
| [单词接龙](WordLadder.java) | 中等 | 广度优先搜索 |
| [单词接龙 II](WordLadderIi.java) | 困难 | 广度优先搜索 数组 字符串 回溯算法 |
| [岛屿数量](NumberOfIslands.java) | 中等 | 深度优先搜索 广度优先搜索 并查集 |
| [扫雷游戏](Minesweeper.java) | 中等 | 深度优先搜索 广度优先搜索 |
| [柠檬水找零](LemonadeChange.java) | 简单 | 贪心算法 |
| [买卖股票的最佳时机 II](BestTimeToBuyAndSellStockIi.java) | 简单 | 贪心算法 数组 |
| [分发饼干](AssignCookies.java) | 简单 | 贪心算法 |
| [模拟行走机器人](WalkingRobotSimulation.java) | 简单 | 贪心算法 |
| [跳跃游戏](JumpGame.java) | 中等 | 贪心算法 数组 |
| [跳跃游戏 II](JumpGameIi.java) | 困难 | 贪心算法 数组 |
| [搜索旋转排序数组](SearchInRotatedSortedArray.java) | 中等 | 数组 二分查找 |
| [搜索二维矩阵](SearchA2dMatrix.java) | 中等 | 数组 二分查找 |
| [寻找旋转排序数组中的最小值](FindMinimumInRotatedSortedArray.java) | 中等 | 数组 二分查找 |
