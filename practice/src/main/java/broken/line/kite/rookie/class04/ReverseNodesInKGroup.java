package broken.line.kite.rookie.class04;

/**
 * @author: wanjia1
 * @date: 2023/10/9
 * leet code link https://leetcode.com/problems/reverse-nodes-in-k-group/
 * <p>
 * K个节点的组内逆序调整问题：
 * 给定一个单链表的头节点head，和一个正数k 实现k个节点的小组内部逆序，
 * 如果最后一组不够k个就不调整
 * 例子: 调整前：1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8，k = 3
 * 调整后：3 -> 2 -> 1 -> 6 -> 5 -> 4 -> 7 -> 8
 */
public class ReverseNodesInKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        // 记录第一次反转的尾部节点位置
        ListNode start = head;
        //寻找第k节点位置
        ListNode kEnd = findKEnd(start, k);
        if (kEnd == null) {
            return head;
        }
        // 第一组反转成功 记录第一次反转成功的节点为新链表的头部节点
        head = kEnd;
        reverseFromStartToEnd(start, kEnd);
        // 反转完毕后 新的链表尾部节点
        ListNode lastEnd = start;
        while (lastEnd.next != null) {
            start = lastEnd.next;
            ListNode subEnd = findKEnd(start, k);
            if (subEnd == null) {
                break;
            }
            reverseFromStartToEnd(start, subEnd);
            // 上一个反转的尾部节点 指向反转后的头部节点
            lastEnd.next = subEnd;
            lastEnd = start;
        }
        return head;
    }

    /**
     * 每一组函数 只维护它与其下一段子节点的正确链接
     *
     * @param start
     * @param end
     */
    private void reverseFromStartToEnd(ListNode start, ListNode end) {
        // 记录下一个尾部节点
        end = end.next;
        ListNode pre = null;
        ListNode cursor = start;
        ListNode next = null;
        // 遍历该指针 如果已经遍历到end了 则不用在反转了 而不是next
        while (cursor != end) {
            next = cursor.next;
            cursor.next = pre;
            pre = cursor;
            cursor = next;
        }
        // 让反转过来的新尾部节点 原来的头部节点 指向原来尾部节点的下一个节点
        start.next = end;
    }

    private ListNode findKEnd(ListNode head, int k) {
        // head.next !=null head 可能为空会空指针
        while (head != null && --k != 0) {
            head = head.next;
        }
        return head;
    }

    public static class ListNode {
        public int val;
        public ListNode next;
    }


}
