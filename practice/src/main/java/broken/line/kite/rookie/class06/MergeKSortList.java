package broken.line.kite.rookie.class06;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author: wanjia1
 * @date: 2023/10/16
 * 合并k个有序链表 解决思路是 使用小跟堆 不断的将最小的节点从小跟堆里弹出 并将弹出的节点至于尾部节点上
 * 对于链表来说 头节点一般为特殊case
 * https://leetcode.cn/problems/merge-k-sorted-lists/
 */
public class MergeKSortList {

    public ListNode mergeKLists(ListNode[] lists) {
        // exception case
        if (lists == null) {
            return null;
        }
        // 小根堆
        PriorityQueue<ListNode> heap = new PriorityQueue<>(new ListComparator());

        for (int i = 0; i < lists.length; i++) {
            ListNode node = lists[i];
            if (node != null) {
                heap.add(node);
            }
        }
        // 使用heap来判断 则head必然不为null
        if (heap.isEmpty()) {
            return null;
        }
        // 返回头节点的地址
        final ListNode head = heap.poll();
        // 复制头节点 并遍历它
        ListNode pre = head;
        // 头节点为特殊case
        if (pre.next != null) {
            heap.add(pre.next);
        }
        while (!heap.isEmpty()) {
            // 小根堆弹出节点当作 下一个节点
            ListNode cur = heap.poll();
            // 衔接下一个节点
            pre.next = cur;
            // 记录cur作为 上一个节点作为 衔接点
            pre = cur;
            // 把弹出的节点链表的下一个节点添加进去
            if (cur.next != null) {
                heap.add(cur.next);
            }
        }
        // 把弹出的头节点返回
        return head;
    }

    public static class ListNode {
        public int val;
        public ListNode next;
    }

    public static class ListComparator implements Comparator<ListNode> {

        /**
         * 如果是负数 则放在前面 如果是0 则无所谓 如果是1 则放在后面
         * 所以
         *
         * @param o1 the first object to be compared.
         * @param o2 the second object to be compared.
         * @return
         */
        @Override
        public int compare(ListNode o1, ListNode o2) {
            return o1.val - o2.val;
        }
    }


}
