# Week_08 学习笔记

## 位运算

### 位运算符

|   含义   | 运算符 |        示例         |
| :------: | :----: | :-----------------: |
|   左移   |   <<   |    0011 <<  0110    |
|   右移   |   >>   |    0110 >> 0011     |
|  按位或  |   \|   | 0011 \| 1011 = 1011 |
|  按位与  |   &    | 0011 & 1011 = 0011  |
| 按位取反 |   ～   |    ~0011 = 1100     |
| 按位异或 |   ^    | 0011 ^ 1011 = 1000  |

异或：相同为0，不同为1

### 指定位置的位运算

1. 将 x 最右边的 n 位清零：x & (~0 << n)
2. 获取 x 的第 n 位值（0 或者 1）： (x >> n) & 1
3. 获取 x 的第 n 位的幂值：x & (1 << n)
4. 仅将第 n 位置为 1：x | (1 << n)
5. 仅将第 n 位置为 0：x & (~ (1 << n))
6. 将 x 最高位至第 n 位（含）清零：x & ((1 << n) - 1)

### 位运算的应用

* 判断奇偶：

  x % 2 == 1 ==> (x & 1) == 1

  x % 2 == 0 ==> (x & 1) == 0

* x >> 1 ==> x / 2. 

  x = x / 2; ==> x = x >> 1;

  mid = (left + right) / 2; ==> mid = (left + right) >> 1;

* X = X & (X-1) 清零最低位的 1 
* X & -X => 得到最低位的 1 
* X & ~X => 0

## 布隆过滤器

布隆过滤器（Bloom Filter）是1970年由布隆提出的。它实际上是一个很长的二进制向量和一系列随机映射函数。布隆过滤器可以用于检索一个元素是否在一个集合中。它的优点是空间效率和查询时间都比一般的算法要好的多，缺点是有一定的误识别率和删除困难。

- 优点：由于存放的不是完整的数据，所以占用的内存很少，而且新增，查询速度够快；
- 缺点：随着数据的增加，误判率随之增加；无法做到删除数据；只能判断数据是否一定不存在，而无法判断数据是否一定存在。

布隆过滤器（Bloom Filter）的核心实现是一个超大的位数组和几个哈希函数。

* 案例

  1. 比特币网络

  2. 分布式系统（Map-Reduce）-- Hadoop、search engine

  3. Redis 缓存

  4. 垃圾邮件、评论等的过滤

## LRU Cache

LRU：Least recently use ,最近最少使用

经典的使用场景:**CPU的高速缓存**

实现LRU Cache需要两个数据结构:**双向链表+哈希表**

Java可用LinkedHashMap实现LRU Cache

## 排序算法

| 排序算法 | 时间复杂度（平均） | 时间复杂度（最坏） | 时间复杂度（最好） | 空间复杂度 | 稳定性 |
| -------- | ------------------ | ------------------ | ------------------ | ---------- | ------ |
| 插入排序 | O(n^2) | O(n^2) | O(n) | O(1) | 稳定 |
| 希尔排序 | O(n^1.3) | O(n^2) | O(n) | O(1) | 不稳定 |
| 选择排序 | O(n^2) | O(n^2) | O(n^2) | O(1) | 不稳定 |
| 堆排序   | O(nlogn) | O(nlogn) | O(nlogn) | O(1) | 不稳定 |
| 冒泡排序 | O(n^2) | O(n^2) | O(n) | O(1) | 稳定 |
| 快速排序 | O(nlogn) | O(n^2) | O(nlogn) | O(nlogn) | 不稳定   |
| 归并排序 | O(nlogn) | O(nlogn) | O(nlogn) | O(n) | 稳定   |
|          |                    |                    |                    |            |        |
| 计数排序 | O(n+k) | O(n+k) | O(n+k) | O(n+k) | 稳定   |
| 桶排序   | O(n+k) | O(n^2) | O(n) | O(n+k) | 稳定   |
| 基数排序 | O(n*k) | O(n*k) | O(n*k) | O(n+k) | 稳定   |

### 比较类排序

通过比较来决定元素间的相对次序，由于其时间复杂度不能突破O(nlogn)，因此也称为非线性时间比较类排序。

* 交换排序
  * 冒泡排序
  * 快速排序
* 插入排序
  * 简单插入排序
  * 希尔排序
* 选择排序
  * 简单选择排序
  * 堆排序
* 归并排序
  * 二路归并排序
  * 多路归并排序

#### 初级排序O(n^2)

* 选择排序（Selection Sort）
  每次找最小值，然后放到待排序数组的起始位置。

  ```java
      public static void selectionSort(int[] arr) {
          for (int i = 0; i < arr.length - 1; i++) {
              int minIndex = i;
              for (int j = i + 1; j < arr.length; j++) {
                  if (arr[j] < arr[minIndex]) {
                      minIndex = j;
                  }
              }
              int temp = arr[i];
              arr[i] = arr[minIndex];
              arr[minIndex] = temp;
          }
      }
  ```

* 插入排序（Insertion Sort）
  从前到后逐步构建有序序列；对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入。

  ```java
  public static void insertionSort(int[] a) {
          if (a.length <= 1) return;
          for (int i = 1; i < a.length; ++i) {
              int value = a[i];
              int j = i - 1;
              // 查找插入的位置
              for (; j >= 0; --j) {
                  if (a[j] > value) {
                      a[j + 1] = a[j];  // 数据移动
                  } else {
                      break;
                  }
              }
              a[j + 1] = value; // 插入数据
          }
      }
  ```

* 冒泡排序（Bubble Sort）
  嵌套循环，每次查看相邻的元素如果逆序，则交换。

  ```java
      public static void bubbleSort(int[] a) {
          if (a.length <= 1) return;
          for (int i = 0; i < a.length; ++i) {
              // 提前退出冒泡循环的标志位
              boolean flag = false;
              for (int j = 0; j < a.length - i - 1; ++j) {
                  if (a[j] > a[j + 1]) { // 交换
                      int tmp = a[j];
                      a[j] = a[j + 1];
                      a[j + 1] = tmp;
                      flag = true;
                  }
              }
              if (!flag) break;
          }
      }
  ```

#### 高级排序O(nlogn)

* 快速排序（Quick Sort）

  数组取标杆 pivot，将小元素放 pivot左边，大元素放右侧，然后依次对右边和右边的子数组继续快排；以达到整个序列有序。

  ```java
      public static void quickSort(int[] array, int begin, int end) {
          if (end <= begin) return;
          int pivot = partition(array, begin, end);
          quickSort(array, begin, pivot - 1);
          quickSort(array, pivot + 1, end);
      }
  
      static int partition(int[] a, int begin, int end) {
          // pivot: 标杆位置，counter: 小于pivot的元素的个数
          int pivot = end, counter = begin;
          for (int i = begin; i < end; i++) {
              if (a[i] < a[pivot]) {
                  int temp = a[counter];
                  a[counter] = a[i];
                  a[i] = temp;
                  counter++;
              }
          }
          int temp = a[pivot];
          a[pivot] = a[counter];
          a[counter] = temp;
          return counter;
      }
  ```

* 归并排序（Merge Sort）

  分治;

  * 把长度为n的输入序列分成两个长度为n/2的子序列； 
  * 对这两个子序列分别采用归并排序；
  *  将两个排序好的子序列合并成一个最终的排序序列。

  归并：先排序左右子数组，然后合并两个有序子数组快排：先调配出左右子数组，然后对于左右子数组进行排序 

  ```java
      public static void mergeSort(int[] array, int left, int right) {
          if (right <= left) return;
          int mid = (left + right) >> 1;
          mergeSort(array, left, mid);
          mergeSort(array, mid + 1, right);
          merge(array, left, mid, right);
      }
  
      public static void merge(int[] arr, int left, int mid, int right) {
          int[] temp = new int[right - left + 1];
          int i = left, j = mid + 1, k = 0;
  
          while (i <= mid && j <= right) {
              temp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
          }
  
          while (i <= mid) temp[k++] = arr[i++];
          while (j <= right) temp[k++] = arr[j++];
  
          for (int p = 0; p < temp.length; p++) {
              arr[left + p] = temp[p];
          }
      }
  ```

* 堆排序（Heap Sort） 

  堆插入 O(logN)，取最大/小值 O(1)

  * 数组元素依次建立小顶堆
  * 依次取堆顶元素，并删除

  ```java
      public static void heapSort(int[] array) {
          if (array.length == 0) return;
          int length = array.length;
          for (int i = length / 2 - 1; i >= 0; i--) {
              heapify(array, length, i);
          }
          for (int i = length - 1; i >= 0; i--) {
              int temp = array[0];
              array[0] = array[i];
              array[i] = temp;
              heapify(array, i, 0);
          }
      }
      public static void heapify(int[] array, int length, int i) {
          int left = 2 * i + 1, right = 2 * i + 2;
          int largest = i;
          if (left < length && array[left] > array[largest]) {
              largest = left;
          }
          if (right < length && array[right] > array[largest]) {
              largest = right;
          }
          if (largest != i) {
              int temp = array[i];
              array[i] = array[largest];
              array[largest] = temp;
              heapify(array, length, largest);
          }
      }
  ```

### 非比较类排序

不通过比较来决定元素间的相对次序，它可以突破基于比较排序的时间下界，以线性时间运行，因此也称为线性时间非比较类排序。

* 计数排序（Counting Sort）

  计数排序要求输入的数据必须是有确定范围的整数。将输入的数据值转化为键存储在额外开辟的数组空间中；然后依次把计数大于 1 的填充回原数组
  
* 桶排序（Bucket Sort）

  桶排序 (Bucket sort)的工作的原理：假设输入数据服从均匀分布，将数据分到有限数量的桶里，每个桶再分别排序（有可能再使用别的排序算法或是以递归方式继续使用桶排序进行排）。
  
* 基数排序（Radix Sort）
基数排序是按照低位先排序，然后收集；再按照高位排序，然后再收集；依次类推，直到最高位。有时候有些属性是有优先级顺序的，先按低优先级排序，再按高优先级排序。