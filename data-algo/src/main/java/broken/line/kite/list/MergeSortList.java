package broken.line.kite.list;

/**
 * 两个有序链表的合并
 * 给定两个有序链表的头节点head1和head2，
 * 返回合并之后的大链表，要求依然有序
 * 例子     1 -> 3 -> 3 -> 5 -> 7   2 -> 2 -> 3 -> 3-> 7
 * 返回     1 -> 2 -> 2 -> 3 -> 3 -> 3 -> 3 -> 5 -> 7
 * 测试链接：https://leetcode.com/problems/merge-two-sorted-lists
 *
 * @author: wanjia1
 * @date: 2023/5/1
 */
public class MergeSortList {

    public ListNode mergeTwoLists(ListNode head1, ListNode head2) {
        if (head1 == null || head2 == null) {
            return head1 == null ? head2 : head1;
        }
        ListNode head = head1.val < head2.val ? head1 : head2;
        // 小端
        ListNode cur1 = head.next;
        // 大端
        ListNode cur2 = head == head1 ? head2 : head1;
        // 遍历不完剩下的
        ListNode pre = head;
        while (cur1 != null && cur2 != null) {
            // 传递的是节点 而不是节点的值
            if (cur1.val > cur2.val) {
                pre.next = cur2;
                cur2 = cur2.next;
            } else {
                pre.next = cur1;
                cur1 = cur1.next;
            }
            pre = pre.next;
        }
        pre.next = cur1 == null ? cur2 : cur1;
        return head;
    }

    public static class ListNode {
        public int val;
        public ListNode next;
    }


}
