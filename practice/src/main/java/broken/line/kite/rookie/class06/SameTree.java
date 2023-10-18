package broken.line.kite.rookie.class06;

/**
 * @author: wanjia1
 * @date: 2023/10/16
 * https://leetcode.cn/problems/same-tree/
 */
public class SameTree {

//    public boolean isSameTree(TreeNode p, TreeNode q) {
//        if (p == null ^ q == null) {
//            return false;
//        }
//        if (p == null && q == null) {
//            return true;
//        }
//        if (p.val == q.val) {
//            return true;
//        }
//
//        return p.val == q.val && isSameTree(p.left, p.left) && isSameTree(p.right, q.right);
//    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        // exception case
        if (p == null ^ q == null) {
            return false;
        }
        // exception case
        if (p == null && q == null) {
            return true;
        }
        // normal case
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
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
