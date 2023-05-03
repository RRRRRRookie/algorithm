package broken.line.kite.list;

/**
 * @author: wanjia1
 * @date: 2023/5/3
 */
class DoubleLinkedListToDequeTest {

    public static class DoubleNode<T> {
        T value;
        DoubleNode<T> last;
        DoubleNode<T> next;

        public DoubleNode(T value) {
            this.value = value;
        }
    }

    /**
     * 双端队列 实现
     * size() isEmpty()
     * offer(T) -> offerTail(T)
     * poll() -> poolHead()
     * offerHead(T) offerTail(T)
     * pollHead() pollTail()
     * peekHead() peekTail()
     *
     * @param <T>
     */
    public static class MyDeque<T> {

        DoubleNode<T> head;
        DoubleNode<T> tail;
        int size;

        public int size() {
            return this.size;
        }

        public boolean isEmpty() {
            return this.size == 0;
        }

        public void offer(T t) {
            this.offerTail(t);
        }

        public void offerTail(T t) {
            DoubleNode<T> cur = new DoubleNode<>(t);
            // 使用另一端判断
            if (head == null) {
                head = tail = cur;
            } else {
                tail.next = cur;
                cur.last = tail;
                tail = cur;
            }
            size++;
        }

        public void offerHead(T t) {
            DoubleNode<T> cur = new DoubleNode<>(t);
            if (tail == null) {
                head = tail = cur;
            } else {
                head.last = cur;
                cur.next = head;
                head = cur;
            }
            size++;
        }

        public T poll() {
            return this.pollHead();
        }


        public T pollHead() {
            T value = null;
            if (head != null) {
                value = head.value;
                if (head == tail) {
                    head = tail = null;
                } else {
                    // 挪动头指针指向 下一个节点
                    head = head.next;
                    // 清理指针
                    head.last = null;
                }

                size--;
            }

            return value;
        }

        public T pollTail() {
            T value = null;
            if (tail != null) {
                value = tail.value;
                if (tail == head) {
                    head = tail = null;
                } else {
                    tail = tail.last;
                    tail.next = null;
                }
                size--;
            }
            return value;
        }

        public T peekHead() {
            return head == null ? null : head.value;
        }

        public T peekTail() {
            return tail == null ? null : tail.value;
        }


    }


}