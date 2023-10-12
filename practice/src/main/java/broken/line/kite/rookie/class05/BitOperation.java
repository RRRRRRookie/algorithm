package broken.line.kite.rookie.class05;

/**
 * @author: wanjia1
 * @date: 2023/10/6
 * ^ 无进位相加 & 进位 位置
 * 不断循环 a & b 为 0 结束
 *  测试链接：https://leetcode.com/problems/divide-two-integers
 */
public class BitOperation {


    /**
     * @param a
     * @param b
     * @return
     */
    public static int add(int a, int b) {
        int sum = a;
        while (b != 0) {
            // 无进位相加
            sum = a ^ b;
            // 与运算获得进位 左移
            b = (a & b) << 1;
            a = sum;
        }
        return sum;
    }

    public static int neg(int num) {
        return (~num) + 1;
    }

    public static int minus(int a, int b) {
        return add(a, neg(b));
    }

    public static int multi(int a, int b) {
        int res = 0;
        while (b != 0) {
            if ((b & 1) != 0) {
                res = add(res, a);
            }
            a <<= 1;
            b >>>= 1;
        }
        return res;
    }

    public static int div(int a, int b) {
        return 0;
    }

    public static int divide(int a, int b) {
        return 0;
    }


}
