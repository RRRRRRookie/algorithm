package broken.line.kite;

/**
 * @author: wanjia1
 * @date: 2023/4/18
 */
public class CustomizeSingleNodeSequenceTable<T> {

    Node<T> head;

    public Node<T> CustomizeSingleNodeSequenceTable() {
        this.head = new Node<>();
        return head;
    }

    public static class Node<T> {
        Node<T> next;
        T value;
    }


}
