package broken.line.kite.tree;

/**
 * @author: wanjia1
 * @date: 2023/5/6
 * https://leetcode.com/problems/balanced-binary-tree
 */
public class BBTree {

    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static class Info {
        public boolean isBalanced;
        public int height;

        public Info(boolean i, int h) {
            isBalanced = i;
            height = h;
        }
    }

    static class Solution {


        public static boolean isBalanced(TreeNode root) {
            return process(root).isBalanced;
        }

        private static Info process(TreeNode root) {
            if (root == null) {
                return new Info(true, 0);
            }
            Info left = process(root.left);
            Info right = process(root.right);
            int height = Math.max(left.height, right.height) + 1;
            boolean isBalanced = left.isBalanced && right.isBalanced && (Math.abs(left.height - right.height) < 2);
            return new Info(isBalanced, height);
        }


    }


}
