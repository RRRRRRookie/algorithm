package broken.line.kite.rookie.class04;

import java.util.Stack;

/**
 * 后进先出
 * 尾部加 尾部弹出 用一个指针就够了
 * push() pop() peek()
 *
 * @author: wanjia1
 * @date: 2023/10/6
 */
public class OneWayListImpStack<V> {

    Node<V> head;

    int size;

    public OneWayListImpStack() {
        size = 0;
        head = null;
    }

    public static void testStack() {
        OneWayListImpStack<Integer> myStack = new OneWayListImpStack<>();
        Stack<Integer> test = new Stack<>();
        int testTime = 5000000;
        int maxValue = 200000000;
        System.out.println("测试开始！");
        for (int i = 0; i < testTime; i++) {
            if (myStack.isEmpty() != test.isEmpty()) {
                System.out.println("Oops!");
            }
            if (myStack.size() != test.size()) {
                System.out.println("Oops!");
            }
            double decide = Math.random();
            if (decide < 0.33) {
                Integer num = (int) (Math.random() * maxValue);
                myStack.push(num);
                test.push(num);
            } else if (decide < 0.66) {
                if (!myStack.isEmpty()) {
                    int num1 = myStack.pop();
                    int num2 = test.pop();
                    if (num1 != num2) {
                        System.out.println("Oops!");
                    }
                }
            } else {
                if (!myStack.isEmpty()) {
                    int num1 = myStack.peek();
                    int num2 = test.peek();
                    if (num1 != num2) {
                        System.out.println("Oops!");
                    }
                }
            }
        }
        if (myStack.size() != test.size()) {
            System.out.println("Oops!");
        }
        while (!myStack.isEmpty()) {
            int num1 = myStack.pop();
            int num2 = test.pop();
            if (num1 != num2) {
                System.out.println("Oops!");
            }
        }
        System.out.println("测试结束！");
    }

    public static void main(String[] args) {
        testStack();
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void push(V value) {
        Node<V> node = new Node<>(value);
        if (head == null) {
            head = node;
        } else {
            node.next = head;
            head = node;
        }
        size++;
    }

    public V pop() {
        if (head != null) {
            size--;
            V value = head.value;
            head = head.next;
            return value;
        }
        return null;
    }

    public V peek() {
        return head == null ? null : head.value;
    }

    public static class Node<V> {
        V value;
        Node<V> next;

        public Node(V value) {
            this.value = value;
        }
    }


}
