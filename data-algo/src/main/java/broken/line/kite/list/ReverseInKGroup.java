package broken.line.kite.list;

/**
 * K个节点的组内逆序调整问题：
 * 给定一个单链表的头节点head，和一个正数k
 * 实现k个节点的小组内部逆序，如果最后一组不够k个就不调整
 * 例子:
 * 调整前：1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8，k = 3
 * 调整后：3 -> 2 -> 1 -> 6 -> 5 -> 4 -> 7 -> 8
 * 测试链接：https://leetcode.com/problems/reverse-nodes-in-k-group/
 *
 * @author: wanjia1
 * @date: 2023/5/1
 */
public class ReverseInKGroup {


    public static void main(String[] args) {

    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode start = head;
        ListNode end = getKEnd(start, k);
        if (end == null) {
            return head;
        }
        // 否则第一组就凑齐了
        head = end;

        reverse(start, end);
        // 获得上一组的尾部节点
        ListNode lastEnd = start;
        while (lastEnd.next != null) {
            start = lastEnd.next;
            ListNode curEnd = getKEnd(start, k);
            if (curEnd == null) {
                return head;
            }
            // 这句话不对 因为第一组逆序的返回 就是你要返回的新头部节点 head = curEnd;
            reverse(start, curEnd);
            // 让上一组的尾部节点 指向这一组的头部节点
            lastEnd.next = end;
            // 将反转后的新尾部节点 赋予循环
            lastEnd = start;
        }
        return head;

    }

    private static void reverse(ListNode start, ListNode end) {

        // 没有这句话 最后一个节点不会反转
        end = end.next;
        ListNode pre = null;
        // 这个额外引用让反转后的最后一个节点 start 指到第k+1个节点 end
        ListNode cur = start;
        ListNode next = null;
        // 反转到end + 1个节点 就不要在反转了
        while (cur != end) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        // 让反转后的最后一个节点 start 指到第k+1个节点 end 3 -> 2 -> 1 -> 4
        start.next = end;
    }

    private static ListNode getKEnd(ListNode start, int k) {
        /**
         *  1个节点的时候 有问题 因为1个节点不需要寻找下一个节点 返回其本身即可
         while (start != null && k > 0) {
         start = start.next;
         k--;
         }
         */
        // 这么写传负数的第一个case就可以返回
        while (start != null && --k > 0) {
            start = start.next;
        }
        return start;
    }

    public static class ListNode {
        public int val;
        public ListNode next;
    }
}
