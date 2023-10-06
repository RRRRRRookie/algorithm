package broken.line.kite.rookie.class04;

/**
 * @author: wanjia1
 * @date: 2023/10/5
 */
public class OneWayList {

    /**
     * 使用双指针
     * 包括head理论上我们有三个指针
     * head 当前位置指针
     * next 记录下一个节点的指针
     * pre  记录之前指针的位置
     *
     * @param head
     * @return
     */
    public static Node reverse(Node head) {
        Node pre = null;
        Node next = null;
        while (head != null) {
            // 记录head的next位置
            next = head.next;
            // 存储完毕后 head就可以将指针指向pre
            head.next = pre;
            // head的工作完成了 但是为了被下一次反转指过去 还是要记录他的位置
            pre = head;
            // head的位置记录完了 就可以将他的位置向下移 为了下一步反转
            head = next;
        }
        return pre;
    }

    static class Node {
        int data;
        Node next;
    }


}
