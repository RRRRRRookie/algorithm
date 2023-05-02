package broken.line.kite.list;

/**
 * @author: wanjia1
 * @date: 2023/5/1
 */
public class AddTwoList {

    public static class Node<T> {
        T value;

        ReverseList.Node<T> next;

        public Node(T value) {
            this.value = value;
        }

    }


}
