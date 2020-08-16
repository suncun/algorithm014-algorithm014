学习笔记
# Week_01 学习笔记
## 如何高效学习算法训练营课程
职业训练：拆分知识点、刻意练习、反馈  
五步刷题法

---
## 复杂度分析
大O复杂度表示法  
O(1): Constant Complexity 常数复杂度  
O(log n): Logarithmic Complexity 对数复杂度  
O(n): Linear Complexity 线性时间复杂度  
O(n^2): N square Complexity 平方  
O(n^3): N cubic Complexity 立方  
O(2^n): Exponential Growth 指数  
O(n!): Factorial 阶乘  

---
## 数组 链表 跳表
* 数组

    数组（Array）是一种线性表数据结构。它用一组连续的内存空间，来存储一组具有相同类型的数据。  
    最大的特点就是支持随机访问,时间复杂度O(1)，但插入、删除操作也因此变得比较低效，平均情况时间复杂度为 O(n)。

* 链表

    和数组相比，链表更适合插入时间复杂度O(1)、删除操作频繁的场景，查询的时间复杂度较高，为 O(n)。

* 跳表

    跳表:升维思想+空间换时间，通过构建多级索引提高查询效率。  
    跳表是一种动态的数据结构，支持快速的插入、删除、查找操作，时间复杂度均为O(logn)。跳表的空间复杂度是O(n)。

---
## 栈 队列  
* Stack：先入后出；添加、删除皆为 O(1)  
* Queue：先入先出；添加、删除皆为 O(1)  
* Deque: Double-End Queue 添加、删除皆为 O(1)

## 作业

### 分析 Queue 和 Priority Queue 的源码
 
1. Queue接口  

基于JDK 1.8，Queue接口定义了6个方法，归纳为新增、删除、查询三种不同操作
* 新增
    - boolean add(E e) 往队列添加一个元素，如果队列已满抛出IllegalStateException异常
    - boolean offer(E e) 往队列添加一个元素，true成功，false失败，和add区别在与不会因为队列已满抛异常
* 查询
    - E element()  返回队列头部元素（没有删除），如果队列为空抛出NoSuchElementException异常
    - E peek() 返回队列头部元素（没有删除），如果队列为空返回null。
* 删除
    - E remove() 删除队列头元素并返回该元素，如果队列为空抛出NoSuchElementException异常
    - E poll() 删除队列头元素并返回该元素，如果队列为空返回null（与remove不同）

2. PriorityQueue

PriorityQueue是Queue的一种实现，PriorityQueue继承了AbstractQueue，AbstractQueue实现Queue接口，即PriorityQueue拥有Queue的方法和特征。  
PriorityQueue是基于二叉堆形式实现的无界队列。队列中元素类型必须是可比较的，构造函数如果没有传入Comparator默认是自然排序。
* 入队元素必须实现Comparator比较器接口，或者用户自己提供比较器，否则无法使用
* PriorityQueue通过数组实现，数组长度虽然固定，但可以扩容，
* 因为可以扩容add不会存在容器长度问题报异常，而remove和element仍然存在此问题
* PriorityQueue是非线程安全的，新增、删除操作没有加锁操作

### leetcode题
| 题目 | 难度 | Related Topics |
| :-----| :----: | :---- |
| [删除排序数组中的重复项]([26]remove-duplicates-from-sorted-array.java)  | 简单 | 数组 双指针  |  
| [旋转数组]([189]rotate-array.java)  | 简单 | 数组  | 
| [合并两个有序链表]([21]merge-two-sorted-lists.java)  | 简单 | 链表   |  
| [合并两个有序数组]([88]merge-sorted-array.java)  | 简单 | 数组 双指针   | 
| [两数之和]([1]two-sum.java)  | 简单 | 数组 哈希表  |  
| [移动零]([283]move-zeroes.java)  | 简单 | 数组 双指针   |  
| [加一]([66]plus-one.java)  | 简单 | 数组  |  
| [设计循环双端队列]([641]design-circular-deque.java)  | 中等 | 设计 队列   |  
| [接雨水]([42]trapping-rain-water.java)  | 困难 | 栈 数组 双指针   |

## 总结

理清思路，多次练习，直到掌握