package broken.line.kite.tree;

/**
 * @author: wanjia1
 * @date: 2023/5/2
 * 二叉树 不能有环路
 * 孩子节点 其他节点不能染指
 */
public class BinaryTree {

    // 先序遍历 每一棵树都是 头左右
    // 中序遍历 左头右
    // 后序遍历 左右头
    // 递归序
    // TODO 构建二叉树

    private void processFirst(Node node) {
        if (node == null) {
            return;
        }
        System.out.println(node.value);
        processFirst(node.left);
        processFirst(node.right);
    }

    private void processMid(Node node) {
        if (node == null) {
            return;
        }
        processMid(node.left);
        System.out.println(node.value);
        processMid(node.right);
    }

    private void processBehind(Node node) {
        if (node == null) {
            return;
        }
        processBehind(node.left);
        processBehind(node.right);
        System.out.println(node.value);
    }

    public static class Node<T> {
        T value;
        Node<T> left;
        Node<T> right;

        public Node(T value) {
            this.value = value;
        }
    }


}
