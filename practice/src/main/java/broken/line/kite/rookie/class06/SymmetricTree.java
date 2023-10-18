package broken.line.kite.rookie.class06;

/**
 * @author: wanjia1
 * @date: 2023/10/16
 * https://leetcode.cn/problems/symmetric-tree/
 */
public class SymmetricTree {

    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    private boolean isMirror(TreeNode root1, TreeNode root2) {
        // exception case
        if (root1 == null ^ root2 == null) {
            return false;
        }
        if (root1 == null && root2 == null) {
            return true;
        }
        return root1.val == root2.val && isMirror(root1.left, root2.right) && isMirror(root1.right, root2.left);
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
