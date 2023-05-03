package broken.line.kite.list;

/**
 * 两个链表相加问题
 * 给定两个链表的头节点head1和head2，
 * 认为从左到右是某个数字从低位到高位，返回相加之后的链表
 * 例子     4 -> 3 -> 6        2 -> 5 -> 3
 * 返回     6 -> 8 -> 9
 * 解释     634 + 352 = 986
 *
 * @author: wanjia1
 * @date: 2023/5/1
 */
public class AddTwoList {

    public static class Node<T> {
        T value;

        ReverseList.Node<T> next;

        public Node(T value) {
            this.value = value;
        }

    }


}
