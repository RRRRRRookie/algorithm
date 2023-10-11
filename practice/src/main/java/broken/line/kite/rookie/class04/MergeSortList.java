package broken.line.kite.rookie.class04;

import java.util.Objects;

/**
 * @author: wanjia1
 * @date: 2023/10/10
 * <p>
 * 两个有序链表的合并
 * 给定两个有序链表的头节点head1和head2， 返回合并之后的大链表，要求依然有序
 * 例子 1 -> 3 -> 3 -> 5 -> 7 2 -> 2 -> 3 -> 3-> 7
 * 返回 1 -> 2 -> 2 -> 3 -> 3 -> 3 -> 3 -> 5 -> 7
 * https://leetcode.cn/problems/merge-two-sorted-lists/
 */
public class MergeSortList {

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if (list1 == null) {
            return list2;
        }

        if (list2 == null) {
            return list1;
        }

        ListNode firstNode = list1.val <= list2.val ? list1 : list2;

        if (firstNode == list1) {
            list1 = list1.next;
        } else {
            list2 = list2.next;
        }

        ListNode cur = firstNode;

        while (list1 != null || list2 != null) {

            if (list1 == null) {
                cur.next = list2;
                break;
            }

            if (list2 == null) {
                cur.next = list1;
                break;
            }

            if (list1.val <= list2.val) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }

            cur = cur.next;

        }


        return firstNode;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(1);
        ListNode listNode5 = new ListNode(2);
        ListNode listNode6 = new ListNode(3);

        listNode.next = listNode2;
        listNode2.next = listNode3;

        listNode4.next = listNode5;
        listNode5.next = listNode6;

        mergeTwoLists(listNode, listNode4);

    }

    public static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof ListNode)) return false;
            ListNode listNode = (ListNode) o;
            return val == listNode.val && Objects.equals(next, listNode.next);
        }

        @Override
        public int hashCode() {
            return Objects.hash(val, next);
        }
    }

}
