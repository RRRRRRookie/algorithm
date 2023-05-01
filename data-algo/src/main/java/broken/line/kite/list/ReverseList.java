package broken.line.kite.list;

import broken.line.kite.utils.RandomUtils;

/**
 * @author: wanjia1
 * @date: 2023/5/1
 */
public class ReverseList {

    public static void main(String[] args) {
        final Node<Integer> pre = generateRandomList(10, 100);
        reverseSingleList(pre);
    }

    private static Node<Integer> reverseSingleList(Node<Integer> head) {
        Node<Integer> pre = null;
        Node<Integer> next;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    private static DoubleNode<Integer> reverseList(DoubleNode<Integer> head) {
        DoubleNode<Integer> pre = null;
        DoubleNode<Integer> next = null;
        while (head.next != null) {
            next = head.next;
            head.next = pre;
            head.last = next;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static Node<Integer> generateRandomList(int size, int maxValue) {
        int length = RandomUtils.getRandomLength(size);
        if (length == 0) {
            return null;
        }
        length--;
        Node<Integer> head = new Node<>(RandomUtils.getRandomByMax(maxValue));
        Node<Integer> cursor = head;
        while (length > 0) {
            Node<Integer> current = new Node<>(RandomUtils.getRandomByMax(maxValue));
            cursor.next = current;
            cursor = current;
            length--;
        }
        return head;
    }

    public static class Node<T> {
        T value;

        Node<T> next;

        public Node(T value) {
            this.value = value;
        }

    }

    public static class DoubleNode<T> {
        T value;

        DoubleNode<T> last;

        DoubleNode<T> next;

        public DoubleNode(T value) {
            this.value = value;
        }

    }


}
