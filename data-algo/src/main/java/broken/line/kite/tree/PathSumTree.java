package broken.line.kite.tree;

/**
 * @author: wanjia1
 * @date: 2023/5/5
 * 在二叉树上能否组成路径和
 * Leetcode原题，https://leetcode.com/problems/path-sum
 */
public class PathSumTree {

    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    class Solution {


        public boolean hasPathSum(TreeNode root, int targetSum) {
            if (root == null) {
                return false;
            }
            return process(root, targetSum);
        }

        private boolean process(TreeNode root, int targetSum) {
            if (root.left == null && root.right == null) {
                return root.val == targetSum;
            }
            int rest = targetSum - root.val;
            boolean leftAns = root.left != null && process(root.left, rest);
            boolean rightAns = root.right != null && process(root.right, rest);
            return leftAns | rightAns;
        }


    }


}
