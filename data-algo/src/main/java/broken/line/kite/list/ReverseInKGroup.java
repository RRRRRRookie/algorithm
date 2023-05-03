package broken.line.kite.list;

/**
 * K个节点的组内逆序调整问题：
 * 给定一个单链表的头节点head，和一个正数k
 * 实现k个节点的小组内部逆序，如果最后一组不够k个就不调整
 * 例子:
 * 调整前：1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8，k = 3
 * 调整后：3 -> 2 -> 1 -> 6 -> 5 -> 4 -> 7 -> 8
 *
 * @author: wanjia1
 * @date: 2023/5/1
 */
public class ReverseInKGroup {

    public static void reverse(ListNode start, ListNode end) {

    }

    public static class ListNode {
        public int val;
        public ListNode next;
    }
}
