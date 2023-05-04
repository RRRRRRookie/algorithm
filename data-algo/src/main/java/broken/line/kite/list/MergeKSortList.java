package broken.line.kite.list;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author: wanjia1
 * @date: 2023/5/4
 */
public class MergeKSortList {

    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null) {
            return null;
        }
        PriorityQueue<ListNode> heap = new PriorityQueue<>(new ListNodeComparator());
        for (int i = 0; i < lists.length; i++) {
            heap.add(lists[i]);
        }

        if (heap.isEmpty()) {
            return null;
        }
        ListNode head = heap.poll();
        // 作为遍历指针
        ListNode pre = head;
        if (pre.next != null) {
            heap.add(pre.next);
        }
        while (!heap.isEmpty()) {
            final ListNode cur = heap.poll();
            pre.next = cur;
            // 保证这一次添加的节点和下一次添加的节点能够连上
            pre = cur;
            if (cur.next != null) {
                heap.add(cur.next);
            }
        }


        return head;
    }

    public static class ListNode {
        ListNode next;
        int val;
    }

    public static class ListNodeComparator implements Comparator<ListNode> {

        @Override
        public int compare(ListNode o1, ListNode o2) {
            return o1.val - o2.val;
        }
    }


}
