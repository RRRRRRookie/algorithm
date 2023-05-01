package broken.line.kite.list;

import java.util.Objects;

/**
 * @author: wanjia1
 * @date: 2023/5/1
 */
public class LInkedListToStackAndQueue {

    public static class Node<T> {
        T value;
        Node<T> next;

        public Node(T value) {
            this.value = value;
        }
    }

    public static class MyQueue<T> {
        Node<T> head;
        Node<T> tail;
        private int size;

        /**
         * isEmpty() size() offer() poll() peek()
         */

        public boolean isEmpty() {
            return this.size == 0;
        }

        public int size() {
            return this.size;
        }

        public void offer(T value) {
            Node<T> current = new Node<>(value);
            if (Objects.isNull(this.tail)) {
                this.tail = current;
                this.head = current;
            } else {
                tail.next = current;
                tail = current;
            }
            size++;
        }

        public T poll() {
            T value = null;
            if (head != null) {
                value = head.value;
                head = head.next;
                size--;
            }
            if (head == null) {
                tail = null;
            }
            return value;
        }

        public T peek() {
            return head == null ? null : head.value;
        }


    }

    public static class MyStack<T> {
        Node<T> head;
        int size;

        public T pop() {
            T value = null;
            if (head != null) {
                value = head.value;
                head = head.next;
                size--;
            }
            return value;
        }

        public void push(T value) {
            Node<T> current = new Node<>(value);
            current.next = head;
            head = current;
            size++;
        }

    }


}
