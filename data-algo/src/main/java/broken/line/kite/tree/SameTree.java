package broken.line.kite.tree;

/**
 * @author: wanjia1
 * @date: 2023/5/5
 * 判断两颗树是否结构相同
 * Leetcode原题，https://leetcode.com/problems/same-tree
 */
public class SameTree {

    public static boolean isSameTree(TreeNode node1, TreeNode node2) {
        if (node1 == null ^ node2 == null) {
            return false;
        }
        if (node1 == null && node2 == null) {
            return true;
        }

        return node1.val == node2.val && isSameTree(node1.left, node2.left) && isSameTree(node1.right, node2.right);
    }

    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
    }


}
