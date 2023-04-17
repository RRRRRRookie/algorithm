package broken.line.kite;

/**
 * @author: wanjia1
 * @date: 2023/4/17
 */
public class Printer {

    public static void main(String[] args) {
        printNCursor(10);
//        printNLoop(10);
    }

    private static void printNLoop(int i) {
        for (int j = 0; j < i; j++) {
            System.out.println(j + 1);
        }
    }

    /**
     * 递归是通过栈实现的 后进先出
     *
     * @param i
     */
    private static void printNCursor(int i) {
        if (i > 0) {
            printNCursor(--i);
            System.out.println(i + 1);
        }
    }

}
