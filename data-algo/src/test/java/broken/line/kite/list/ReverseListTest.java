package broken.line.kite.list;

import org.junit.jupiter.api.Test;

/**
 * @author: wanjia1
 * @date: 2023/5/2
 */
class ReverseListTest {


    @Test
    void test_reverseSingleList() {
        Node<Integer> head = new Node<>(0);
        head.next = new Node<>(1);
        head.next.next = new Node<>(2);

        Node<Integer> newHead = reverseList(head);


    }

    // 本质上是双指针
    private Node<Integer> reverseList(Node<Integer> head) {
        Node<Integer> pre = null;
        Node<Integer> next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    @Test
    void reverseDoubleList() {

        DoubleNode<Integer> head = new DoubleNode<>(0);

        DoubleNode<Integer> newHead = reverseList(head);

    }

    private DoubleNode<Integer> reverseList(DoubleNode<Integer> current) {
        DoubleNode<Integer> pre = null;
        DoubleNode<Integer> next = null;
        while (current != null) {
            // 1 记录当前指针的下一个节点
            next = current.next;
            // 2 反转指针 next 指向 pre
            current.next = pre;
            // 3 反转指针 last 指向 1 记录好的 next
            current.last = next;
            // 4 记录下当前指针地址
            pre = current;
            // 5 将已经反转的节点 递进为下一个节点
            current = next;
        }
        return pre;
    }

    static class Node<T> {
        T value;
        Node<T> next;

        public Node(T value) {
            this.value = value;
        }
    }

    static class DoubleNode<T> {
        T value;
        DoubleNode<T> last;
        DoubleNode<T> next;

        public DoubleNode(T value) {
            this.value = value;
        }
    }
}