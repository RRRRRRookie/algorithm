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

    public static class Node<T> {
        T value;
        Node<T> left;
        Node<T> right;

        public Node(T value) {
            this.value = value;
        }
    }


}
