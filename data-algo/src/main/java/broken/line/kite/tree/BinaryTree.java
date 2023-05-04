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

    private static void processFirst(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.value);
        processFirst(node.left);
        processFirst(node.right);
    }

    private static void processMid(Node node) {
        if (node == null) {
            return;
        }
        processMid(node.left);
        System.out.print(node.value);
        processMid(node.right);
    }

    private static void processBehind(Node node) {
        if (node == null) {
            return;
        }
        processBehind(node.left);
        processBehind(node.right);
        System.out.print(node.value);
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        head.right.right = new Node(7);

        processFirst(head);
        System.out.println("========");
        processMid(head);
        System.out.println("========");
        processBehind(head);
        System.out.println("========");

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
