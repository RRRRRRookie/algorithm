package broken.line.kite.list;

/**
 * @author: wanjia1
 * @date: 2023/5/2
 */
class LInkedListToStackAndQueueTest {


    public static class Node<T> {
        T value;
        Node<T> next;

        public Node(T value) {
            this.value = value;
        }
    }

    /**
     * 使用单向链表 实现 栈
     * 栈什么特性 FILO size() isEmpty() push(T t) pop() peek()
     */
    public static class MyStack<T> {

        Node<T> head;

        private int size;

        public int size() {
            return this.size;
        }

        public boolean isEmpty() {
            return this.size == 0;
        }

        public void push(T t) {
            Node<T> newNode = new Node<>(t);
            // 根据栈的特性 让新进来的节点成为单向链表的头节点即可
            // 1 将新节点的新一个节点指针指向 head
            newNode.next = head;
            // 2 当前栈对象的头节点指针指向 新节点
            this.head = newNode;
            size++;
        }

        public T pop() {
            if (head == null) {
                return null;
            }
            size--;
            Node<T> pre = head;
            this.head = head.next;
            pre.next = null;
            return pre.value;
        }

        public T peek() {
            return head == null ? null : head.value;
        }


    }


}