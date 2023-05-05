package broken.line.kite.tree;

/**
 * @author: wanjia1
 * @date: 2023/5/5
 * 返回一棵树的最大深度
 * Leetcode原题，https://leetcode.com/problems/maximum-depth-of-binary-tree
 */
public class BinaryTreeMaxDepth {


    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
    }
}
