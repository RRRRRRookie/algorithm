package broken.line.kite.list;

/**
 * 两个链表相加问题
 * 给定两个链表的头节点head1和head2，
 * 认为从左到右是某个数字从低位到高位，返回相加之后的链表
 * 例子     4 -> 3 -> 6        2 -> 5 -> 3
 * 返回     6 -> 8 -> 9
 * 解释     634 + 352 = 986
 * 测试链接：https://leetcode.com/problems/add-two-numbers/
 *
 * @author: wanjia1
 * @date: 2023/5/1
 */
public class AddTwoList {

    public ListNode addTwoNumbers(ListNode head1, ListNode head2) {
        int length1 = getLength(head1);
        int length2 = getLength(head2);
        ListNode l = length1 > length2 ? head1 : head2;
        ListNode s = l.equals(head1) ? head2 : head1;
        ListNode curlL = l;
        ListNode curlS = s;
        ListNode last = curlL;
        int carry = 0;
        //先遍历短的 在遍历长的
        while (curlS != null) {
            int sum = carry + curlL.val + curlS.val;
            curlL.val = sum % 10;
            carry = sum / 10;
            last = curlL;
            curlL = curlL.next;
            curlS = curlS.next;
        }

        while (curlL != null) {
            int sum = carry + curlL.val;
            curlL.val = sum % 10;
            carry = sum / 10;
            last = curlL;
            curlL = curlL.next;
        }

        if (carry != 0) {
            last.next = new ListNode(1);
        }

        return l;
    }

    private int getLength(ListNode head) {
        int count = 0;
        // head.next != null 头节点没算上
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }


}
