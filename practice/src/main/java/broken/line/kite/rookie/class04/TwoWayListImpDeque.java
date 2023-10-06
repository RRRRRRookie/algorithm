package broken.line.kite.rookie.class04;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: wanjia1
 * @date: 2023/10/6
 */
public class TwoWayListImpDeque<V> {

    int size;

    Node<V> head;

    Node<V> tail;

    public static void testDeque() {
        TwoWayListImpDeque<Integer> myDeque = new TwoWayListImpDeque<>();
        Deque<Integer> test = new LinkedList<>();
        int testTime = 5000000;
        int maxValue = 200000000;
        System.out.println("测试开始！");
        for (int i = 0; i < testTime; i++) {
            if (myDeque.isEmpty() != test.isEmpty()) {
                System.out.println("Oops!");
            }
            if (myDeque.size() != test.size()) {
                System.out.println("Oops!");
            }
            double decide = Math.random();
            if (decide < 0.33) {
                int num = (int) (Math.random() * maxValue);
                if (Math.random() < 0.5) {
                    myDeque.pushHead(num);
                    test.addFirst(num);
                } else {
                    myDeque.pushTail(num);
                    test.addLast(num);
                }
            } else if (decide < 0.66) {
                if (!myDeque.isEmpty()) {
                    int num1 = 0;
                    int num2 = 0;
                    if (Math.random() < 0.5) {
                        num1 = myDeque.popHead();
                        num2 = test.pollFirst();
                    } else {
                        num1 = myDeque.popTail();
                        num2 = test.pollLast();
                    }
                    if (num1 != num2) {
                        System.out.println("Oops!");
                    }
                }
            } else {
                if (!myDeque.isEmpty()) {
                    int num1 = 0;
                    int num2 = 0;
                    if (Math.random() < 0.5) {
                        num1 = myDeque.peekHead();
                        num2 = test.peekFirst();
                    } else {
                        num1 = myDeque.peekTail();
                        num2 = test.peekLast();
                    }
                    if (num1 != num2) {
                        System.out.println("Oops!");
                    }
                }
            }
        }
        if (myDeque.size() != test.size()) {
            System.out.println("Oops!");
        }
        while (!myDeque.isEmpty()) {
            int num1 = myDeque.popHead();
            int num2 = test.pollFirst();
            if (num1 != num2) {
                System.out.println("Oops!");
            }
        }
        System.out.println("测试结束！");
    }

    public static void main(String[] args) {
        testDeque();
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void pushHead(V value) {
        Node<V> node = new Node<>(value);
        if (head == null) {
            head = node;
            tail = node;
        } else {
            node.next = head;
            head.last = node;
            head = node;
        }
        size++;
    }

    public void pushTail(V value) {
        Node<V> node = new Node<>(value);
        if (tail == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            node.last = tail;
            tail = node;
        }
        size++;
    }

    public V popHead() {
        if (head != null) {
            V value = head.value;
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                final Node<V> cur = head.next;
                cur.last = null;
                head = cur;
            }
            size--;
            return value;
        }
        return null;
    }

//    public V popHead() {
//        if (head != null) {
//            V value = head.value;
//            Node<V> next = head.next;
//            if (next != null) {
//                next.last = null;
//            } else {
//                head = null;
//                tail = null;
//            }
//            size--;
//            return value;
//        }
//        return null;
//    }


    public V popTail() {
        if (tail != null) {
            V value = tail.value;
            if (tail == head) {
                head = null;
                tail = null;
            } else {
                tail = tail.last;
                tail.next = null;
            }
            size--;
            return value;
        }
        return null;
    }

    public V peekHead() {
        return head == null ? null : head.value;
    }

    public V peekTail() {
        return tail == null ? null : tail.value;
    }

    public static class Node<V> {

        Node<V> last;
        Node<V> next;
        V value;

        public Node(V value) {
            this.value = value;
        }
    }

}
