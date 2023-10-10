package broken.line.kite.rookie.class04;

/**
 * 两个链表相加问题 给定两个链表的头节点head1和head2，
 * 认为从左到右是某个数字从低位到高位，返回相加之后的链表
 * 例子 4 -> 3 -> 6 2 -> 5 -> 3 返回 6 -> 8 -> 9 解释 634 + 352 = 986
 * <p>
 * leetcode link https://leetcode.com/problems/add-two-numbers/
 *
 * @author: wanjia1
 * @date: 2023/10/10
 */
public class AddTwoNumbers {

    /**
     * 解题思路 比较两个链表的长度 找到较长的链表
     * 开始进行数字相加
     * 长的链表没有结束 短的也没有结束
     * 短的链表结束了 长的还没有结束
     * 判断是否有进位的值
     * 返回长链表的头部
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int size1 = getLength(l1);
        int size2 = getLength(l2);

        // 得出两个链表的长度 并标识出哪个较长
        ListNode curL = size1 >= size2 ? l1 : l2;
        ListNode curS = curL == l1 ? l2 : l1;
        // 应该返回长链条 作为节点
        ListNode l = curL;
        ListNode temp = curL;
        int carry = 0;

        while (curS != null) {
            int sum = curL.val + curS.val + carry;
            carry = sum / 10;
            curL.val = sum % 10;
            curS = curS.next;
            temp = curL;
            curL = curL.next;
        }

        while (curL != null) {
            int sum = curL.val + carry;
//            carry = sum >= 10 ? 1 : 0;
            carry = sum / 10;
            curL.val = sum % 10;
            temp = curL;
            curL = curL.next;
        }

        if (carry > 0) {
            temp.next = new ListNode(carry);
        }
        return l;
    }

    private int getLength(ListNode node) {
        int count = 0;
        // 用node.next判断会有空指针
        while (node != null) {
            count++;
            node = node.next;
        }
        return count;
    }


    public static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

}
