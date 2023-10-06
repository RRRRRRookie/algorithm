package broken.line.kite.rookie.class04;

import lombok.extern.slf4j.Slf4j;

/**
 * @author: wanjia1
 * @date: 2023/10/5
 */
@Slf4j
public class TwoWayList {

    public static void main(String[] args) {
        DoubleNode node = new DoubleNode(0);
        DoubleNode result = reverse(node);

    }

    private static DoubleNode reverse(DoubleNode head) {
        DoubleNode pre = null;
        DoubleNode next;
        // 遍历头部指针
        while (head != null) {
            // 记录头部节点的下一个节点 为下一次反转做准备
            next = head.next;
            // 记录完毕 反转next指针
            head.next = pre;
            // 反转pre指针
            head.pre = next;
            // 操作完毕后 将当前节点记录为pre节点 为下一次反转做准备
            pre = head;
            //
            head = next;
        }
        return pre;
    }

    static class DoubleNode {
        private int value;
        private DoubleNode pre;
        private DoubleNode next;

        public DoubleNode(int value) {
            this.value = value;
        }
    }
}
