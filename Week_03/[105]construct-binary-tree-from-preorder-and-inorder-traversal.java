//Given preorder and inorder traversal of a tree, construct the binary tree. 
//
// Note: 
//You may assume that duplicates do not exist in the tree. 
//
// For example, given 
//
// 
//preorder = [3,9,20,15,7]
//inorder = [9,3,15,20,7] 
//
// Return the following binary tree: 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7 
// Related Topics 树 深度优先搜索 数组 
// 👍 641 👎 0


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
//利用栈进行迭代
//时间复杂度O(N),空间复杂度O(N)
class Solution01 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        int inorderIndex = 0;
        for (int i = 1; i < preorder.length; i++) {
            TreeNode node = stack.peek();
            if (inorder[inorderIndex] == node.val) {
                while (!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]) {
                    node = stack.poll();
                    inorderIndex++;
                }
                node.right = new TreeNode(preorder[i]);
                stack.push(node.right);
            } else {
                node.left = new TreeNode(preorder[i]);
                stack.push(node.left);
            }
        }
        return root;
    }
}

//递归
//时间复杂度O(N),空间复杂度O(N)
class Solution02 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        //用HashMap把中序遍历数组的元素的值和下标存起来
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(preorder, 0, preorder.length, inorder, 0, inorder.length, map);
    }

    private TreeNode helper(int[] preorder, int pStart, int pEnd, int[] inorder, int iStart, int iEnd, HashMap<Integer, Integer> map) {
        //终止条件
        if (pEnd == pStart) {
            return null;
        }
        int rootVal = preorder[pStart];
        TreeNode root = new TreeNode(rootVal);
        //在中序遍历中找到根节点的位置
        int inorderRootIndex = map.get(rootVal);
        //左子数节点数
        int leftNum = inorderRootIndex - iStart;
        //递归构造左子树
        root.left = helper(preorder, pStart + 1, pStart + leftNum + 1, inorder, iStart, inorderRootIndex, map);
        //递归构造右子树
        root.right = helper(preorder, pStart + leftNum + 1, pEnd, inorder, inorderRootIndex + 1, iEnd, map);
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
