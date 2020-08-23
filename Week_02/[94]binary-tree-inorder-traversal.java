//Given a binary tree, return the inorder traversal of its nodes' values. 
//
// Example: 
//
// 
//Input: [1,null,2,3]
//   1
//    \
//     2
//    /
//   3
//
//Output: [1,3,2] 
//
// Follow up: Recursive solution is trivial, could you do it iteratively? 
// Related Topics 栈 树 哈希表 
// 👍 632 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
//1.递归算法
//时间复杂度:O(N),空间复杂度:最坏O(N),平均O(logN)
class Solution01 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    private void helper(TreeNode root, List<Integer> res) {
        if (root == null) return;
        helper(root.left, res);
        res.add(root.val);
        helper(root.right, res);
    }
}

//2.借助栈的迭代
//时间复杂度:O(N),空间复杂度:O(N)
class Solution02 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode tmp = stack.pop();
            res.add(tmp.val);
            cur = tmp.right;
        }
        return res;
    }
}

//3.莫里斯遍历，利用叶子节点左右空域存储遍历前驱和后继(利用线索二叉树的特性进行遍历)
// 时间复杂度O(N)，空间复杂度O(1)
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        TreeNode cur = root;
        TreeNode pre;
        while (cur != null) {
            if (cur.left == null) {
                res.add(cur.val);
                //进入右子树继续
                cur = cur.right;
            } else {
                pre = cur.left;
                //找到当前左结构中最右侧的子节点
                while (pre.right != null) {
                    pre = pre.right;
                }
                //将当前节点及其右子树全部挂到,左结构的最右子树下面
                pre.right = cur;
                TreeNode tmp = cur;
                cur = cur.left;
                tmp.left = null;
            }
        }
        return res;
    }
}

//leetcode submit region end(Prohibit modification and deletion)
