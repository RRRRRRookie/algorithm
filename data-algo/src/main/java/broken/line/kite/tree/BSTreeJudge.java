package broken.line.kite.tree;

/**
 * @author: wanjia1
 * @date: 2023/5/5
 * 判断是否是搜索二叉树
 */
public class BSTreeJudge {

    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static class Info {
        public boolean isBST;
        public int max;
        public int min;

        public Info(boolean is, int ma, int mi) {
            isBST = is;
            max = ma;
            min = mi;
        }
    }

    class Solution {
        public Info process(TreeNode node) {
            if (node == null) {
                return null;
            }
            Info left = process(node.left);
            Info right = process(node.right);

            int max = node.val;
            int min = node.val;


            if (left != null) {
                max = Math.max(left.max, node.val);
                min = Math.min(left.min, node.val);
            }

            if (right != null) {
                max = Math.max(right.max, node.val);
                min = Math.min(right.min, node.val);
            }

            boolean leftS = left == null || left.isBST;
            boolean rightS = right == null || right.isBST;

            boolean leftPS = left == null || left.max <= node.val;
            boolean rightPS = right == null || right.min >= node.val;


            boolean isBST = leftS && rightS && leftPS && rightPS;

            return new Info(isBST, max, min);

        }
    }

}
