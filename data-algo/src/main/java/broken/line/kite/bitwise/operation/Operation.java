package broken.line.kite.bitwise.operation;

/**
 * @author: wanjia1
 * @date: 2023/4/30
 */
public class Operation {

    public static void main(String[] args) {


        int num = 5;
        int negativeNum = -5;

        printBit(num);
        printBit(negativeNum);
        printBit(negativeNum >> 2);
        printBit(negativeNum >>> 2);

        System.out.println("==============================================");


        int minValue = Integer.MIN_VALUE;
        print(minValue);
        print(minValue >> 2);
        print(minValue >>> 2);

    }

    // print 整数中包含的1 & 两个1相遇才是1
    public static void print(int num) {
        for (int i = 31; i >= 0; i--) {
            System.out.print((num & (1 << i)) != 0 ? "1" : "0");
        }
        System.out.println();
    }

    /**
     * 反码
     * 补码
     */


    public static void printBit(int num) {
        for (int i = 31; i >= 0; i--) {
            System.out.print((num & (1 << i)) != 0 ? "1" : "0");
        }
        System.out.println();
    }


}
