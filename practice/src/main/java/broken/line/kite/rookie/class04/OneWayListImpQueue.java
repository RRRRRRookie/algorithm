package broken.line.kite.rookie.class04;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 队列 先进先出 方法列表
 * 需要头尾两个指针来实现
 * offer() poll() 分别是向尾部添加新节点 和从头部弹出节点
 *
 * @author: wanjia1
 * @date: 2023/10/6
 */
public class OneWayListImpQueue<V> {

    Node<V> head;

    Node<V> tail;


    int size;

    public OneWayListImpQueue() {
        this.size = 0;
        head = null;
        tail = null;
    }

    public static void testQueue() {
        OneWayListImpQueue<Integer> myQueue = new OneWayListImpQueue<>();
        Queue<Integer> test = new LinkedList<>();
        int testTime = 5000000;
        int maxValue = 200000000;
        System.out.println("测试开始！");
        for (int i = 0; i < testTime; i++) {
            if (myQueue.isEmpty() != test.isEmpty()) {
                System.out.println("Oops!");
            }
            if (myQueue.size() != test.size()) {
                System.out.println("Oops!");
            }
            double decide = Math.random();
            if (decide < 0.33) {
                int num = (int) (Math.random() * maxValue);
                myQueue.offer(num);
                test.offer(num);
            } else if (decide < 0.66) {
                if (!myQueue.isEmpty()) {
                    int num1 = myQueue.poll();
                    int num2 = test.poll();
                    if (num1 != num2) {
                        System.out.println("Oops!");
                    }
                }
            } else {
                if (!myQueue.isEmpty()) {
                    int num1 = myQueue.peek();
                    int num2 = test.peek();
                    if (num1 != num2) {
                        System.out.println("Oops!");
                    }
                }
            }
        }
        if (myQueue.size() != test.size()) {
            System.out.println("Oops!");
        }
        while (!myQueue.isEmpty()) {
            int num1 = myQueue.poll();
            int num2 = test.poll();
            if (num1 != num2) {
                System.out.println("Oops!");
            }
        }
        System.out.println("测试结束！");
    }

    public static void main(String[] args) {
        testQueue();
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void offer(V value) {
        Node<V> node = new Node<>(value);
        if (tail == null) {
            head = node;
        } else {
            tail.next = node;
        }
        tail = node;
        size++;
    }

    public V poll() {
        if (head != null) {
            size--;
            Node<V> cur = head;
            head = head.next;
            if (head == null) {
                tail = null;
            }
            return cur.value;
        }
        return null;
    }

    public V peek() {
        if (head != null) {
            return head.value;
        }
        return null;
    }

    public static class Node<V> {
        Node<V> next;
        V value;

        public Node(V value) {
            this.value = value;
        }
    }


}
