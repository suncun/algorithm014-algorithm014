# 毕业总结

近三个月算法训练营的学习，没有完成LeetCode300题的目标，但也基本按照切题方法完成了实战题目和课后作业，学习了不少高质量的题解，整理了常用算法的解题模板。学习数据结构和算法的过程，是非常好的思维训练的过程，通过训练营了解了有效学习数据结构和算法的方法，即五步刷题法。

## 数据结构

* 线性表
  * 数组
  * 链表
    * 单链表、双向链表、循环链表、双向循环链表、静态链表
  * 栈
    * 顺序栈、链式栈
  * 队列
    * 普通队列、双端队列、优先级队列
* 散列表
    * 散列函数
    * 冲突解决
      * 链表法、开放寻址、其他
    * 动态扩容
* 跳表
    * 一种动态的数据结构，链表加多级索引数据，升维思想+空间换时间，通过构建多级索引提高查询效率
* 树
    * 二叉树
      * 遍历：广度优先、深度优先
      * 形态：平衡二叉树、二叉查找树、平衡二叉查找树（AVL树、红黑树）、满二叉树、完全二叉树、Trie 树
    * 多路查找树
      * B树、B+树、2-3树、2-3-4树
    * 堆
      * 大顶堆、小顶堆
* 图
    * 存储
      * 邻接矩阵、邻接表
    * 拓扑排序
    * 最短路径
      * Dijkstra算法、Floyd算法
    * 关键路径
    * 最小生成树
    * 二分图
    * 最大流
* 特殊结构
    * 位运算 Bitwise
    * 布隆过滤器 BloomFilter
    * LRU Cache
## 复杂度分析
学会复杂度分析是学习数据结构和算法的基石，知道怎么去分析复杂度，才能作出正确的判断。

|Data Structure|Time  - Average - Access	|Search	|Insertion	|Deletion	|Time  - Worst - Access	|Search	|Insertion	|Deletion|Space  - Worst|
| -------- | ---- | ---- | ---- | ---- | ---- | ---- | ---- | ---- | ---- |
|Array	|O(1)|	O(n)|	O(n)|	O(n)|	O(1)|	O(n)|	O(n)|	O(n)|	O(n)|
|Stack	| O(n)	| O(n)	| O(1)	| O(1)	| O(n)	| O(n)	| O(1)	| O(1)	| O(n)|
|Queue	| O(n)	| O(n)	| O(1)	| O(1)	| O(n)	| O(n)	| O(1)	| O(1)	| O(n)|
|Singly-Linked List	| O(n)	| O(n)	| O(1)	| O(1)	| O(n)	| O(n)	| O(1)	| O(1)	| O(n)|
|Doubly-Linked List	| O(n)	| O(n)	| O(1)	| O(1)	| O(n)	| O(n)	| O(1)	| O(1)	| O(n)|
|Skip List	| O(log(n))	| O(log(n))	| O(log(n))	| O(log(n))	| O(n)	| O(n)	| O(n)	| O(n)	| O(nlog(n))|
|Hash Table	| N/A	| O(1)	| O(1)	| O(1)	| N/A	| O(n)	| O(n)	| O(n)	| O(n)|
|Binary Search Tree	| O(log(n))	| O(log(n))	| O(log(n))	| O(log(n))	| O(n)	| O(n)	| O(n)	| O(n)	| O(n)|
|Cartesian Tree	| N/A	| O(log(n))	| O(log(n))	| O(log(n))	| N/A	| O(n)	| O(n)	| O(n)	| O(n)|
|B-Tree	| O(log(n))	| O(log(n))	| O(log(n))	| O(log(n))	| O(log(n))	| O(log(n))	| O(log(n))	| O(log(n))	| O(n)|
|Red-Black Tree	| O(log(n))	| O(log(n))	| O(log(n))	| O(log(n))	| O(log(n))	| O(log(n))	| O(log(n))	| O(log(n))	| O(n)|
|Splay Tree	| N/A	| O(log(n))	| O(log(n))	| O(log(n))	| N/A	| O(log(n))	| O(log(n))	| O(log(n))	| O(n)|
|AVL Tree	| O(log(n))	| O(log(n))	| O(log(n))	| O(log(n))	| O(log(n))	| O(log(n))	| O(log(n))	| O(log(n))	| O(n)|
|KD Tree	| O(log(n))	| O(log(n))	| O(log(n))	| O(log(n))	| O(n)	| O(n)	| O(n)	| O(n)	| O(n)|

## 算法思想

* 基本算法思想
  贪心算法、分治算法、回溯算法、动态规划，枚举算法，其中最难最重要的是动态规划

  动态规划的解题思路：状态转移表法、状态转移方程法

* 排序
  初级排序O(n^2): 冒泡排序、选择排序、插入排序、希尔排序
  高级排序O(nlogn): 归并排序、快速排序、堆排序
  非比较类排序O(n): 基数排序、计数排序、桶排序
  
* 查找
  线性表查找、树结构查找、散列表查找
  
* 搜索
  深度优先搜索、广度优先搜索、A*启发式搜索
  
* 字符串匹配
  朴素、Knuth-Morris-Pratt（KMP）、Robin-Karp、Boyer-Moore、Trie树、AC自动机、后缀数组
  
## 结束语

训练营的课程告一段落，但是算法学习不能停止，训练营新开通了训练场功能，正好可以继续进行算法训练，同时参照毕业刷题路线持续学习，练好基本功。
