package broken.line.kite.rookie.class06;

import lombok.extern.slf4j.Slf4j;

/**
 * @author: wanjia1
 * @date: 2023/10/6
 */
@Slf4j
public class BinaryTree {

    /**
     * 递归序 先序遍历 头左右
     * 每个节点都会遍历三次
     *
     * @param head
     */
    public void pre(TreeNode head) {
        if (head == null) {
            return;
        }
        log.info("value is {}", head.val);
        pre(head.left);
        pre(head.right);
    }

    /**
     * 中序遍历 左头右
     *
     * @param head
     */
    public void mid(TreeNode head) {
        if (head == null) {
            return;
        }
        mid(head.left);
        log.info("value is {}", head.val);
        mid(head.right);
    }

    /**
     * 后序遍历 左右头
     *
     * @param head
     */
    public void pos(TreeNode head) {
        if (head == null) {
            return;
        }
        pos(head.left);
        pos(head.right);
        log.info("value is {}", head.val);
    }

    public static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;

        public TreeNode(TreeNode left, TreeNode right, int val) {
            this.left = left;
            this.right = right;
            this.val = val;
        }
    }


}
