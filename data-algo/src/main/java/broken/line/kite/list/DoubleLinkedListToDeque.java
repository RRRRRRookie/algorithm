package broken.line.kite.list;

/**
 * @author: wanjia1
 * @date: 2023/5/1
 */
public class DoubleLinkedListToDeque {

    public static class DoubleNode<T> {
        T value;
        DoubleNode<T> last;
        DoubleNode<T> next;

        public DoubleNode(T value) {
            this.value = value;
        }
    }

    public static class Deque<T> {
        DoubleNode<T> head;
        DoubleNode<T> tail;
        int size;

        public Deque() {
            this.head = null;
            this.tail = null;
            this.size = 0;
        }

        public boolean isEmpty() {
            return this.size == 0;
        }

        public int size() {
            return this.size;
        }


        public void pushHead(T value) {
            DoubleNode<T> current = new DoubleNode<>(value);
            if (head == null) {
                head = current;
                tail = current;
            } else {
                current.next = head;
                head.last = current;
                head = current;
            }
            size++;
        }

        public void pushTail(T value) {
            DoubleNode<T> current = new DoubleNode<>(value);
            if (tail == null) {
                head = current;
                tail = current;
            } else {
                current.last = tail;
                tail.next = current;
                tail = current;
            }
            size++;
        }

        public T pollHead() {
            T ans = null;
            if (head == null) {
                return null;
            }
            size--;
            ans = head.value;
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                head = head.next;
                head.last = null;
            }
            return ans;
        }

        public T pollTail() {
            T ans = null;
            if (tail == null) {
                return null;
            }
            ans = tail.value;
            size--;
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                tail = tail.last;
                tail.next = null;
            }
            return ans;
        }

        public T peekHead() {
            return head == null ? null : head.value;
        }


        public T peekTail() {
            return tail == null ? null : tail.value;
        }

    }


}
