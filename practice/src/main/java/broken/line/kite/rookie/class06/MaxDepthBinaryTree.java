package broken.line.kite.rookie.class06;

/**
 * @author: wanjia1
 * @date: 2023/10/17
 * https://leetcode.com/problems/maximum-depth-of-binary-tree
 */
public class MaxDepthBinaryTree {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int rightLength = maxDepth(root.right);
        int leftLength = maxDepth(root.left);
        // 错误答案差了一个大括号
//        return rightLength >= leftLength ? rightLength : leftLength + 1;
        return (rightLength >= leftLength ? rightLength : leftLength) + 1;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }


    }

}
