package broken.line.kite.tree;

/**
 * @author: wanjia1
 * @date: 2023/5/5
 * 判断一棵树是否是镜面树
 * Leetcode原题，https://leetcode.com/problems/symmetric-tree
 * 对于树中的任意两个对称节点L、R，必然有：
 * <p>
 * L 和 R 节点的值相等；
 * L 的左节点和 R 的右节点对称
 * L 的右节点和 R 的左节点对称
 * 所以知道对称二叉树的定义后，可以看出来对称二叉树的定义是递归的，所以考虑从顶部节点开始往下递归，判断递归的每队节点是否对称，只要有一对节点不对称，那么整颗树就不是对称，反之，如果每对节点都对称，那么整棵树是对称。
 */
public class SymmetricTree {

    public static boolean isSymmetric(TreeNode node) {
        return isMirror(node, node);
    }

    /**
     * base case
     * recursive formula
     *
     * @param node
     * @param node1
     * @return
     */
    private static boolean isMirror(TreeNode node, TreeNode node1) {
        if (node == null ^ node1 == null) {
            return false;
        }
        if (node == null && node1 == null) {
            return true;
        }
        return node.val == node1.val && isMirror(node.left, node1.right) && isMirror(node.right, node1.left);
    }

    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
    }

}
