package broken.line.kite.rookie.class05;

/**
 * @author: wanjia1
 * @date: 2023/10/6
 * ^ 无进位相加 & 进位 位置
 * 不断循环 a & b 为 0 结束
 * 测试链接：https://leetcode.com/problems/divide-two-integers
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
        int x = isNeg(a) ? neg(a) : a;
        int y = isNeg(b) ? neg(b) : b;
        int res = 0;
        // 因为int有32位 第32位为符号位 故此 0～30 共 31个数字即可
        for (int i = 30; i >= 0; i--) {
            // 从高位开始计算
            while ((x >> i) >= y) {
                // 如果该位有值 值或上该值
                res |= (1 << i);
                // 该位计算完毕后 删除对应的值
                x = minus(x, y << i);
            }
        }

        return isNeg(a) ^ isNeg(b) ? neg(res) : res;
    }

    private static boolean isNeg(int num) {
        return num < 0;
    }

    public static int divide(int a, int b) {

        if (a == Integer.MIN_VALUE && b == Integer.MIN_VALUE) {
            return 1;
        } else if (a == Integer.MIN_VALUE) {
            if (b == neg(1)) {
                return Integer.MAX_VALUE;
            } else {
                // 因为边界值的限制 先+1 求出商 (a+1)/b
                int res = div(add(a, 1), b);
                // (a+1)/b * b
                int multi = multi(res, b);
                // a - ((a+1)/b * b) 求出对应的多加的值
                int minus = minus(a, multi);
                // -1 /b
                int div = div(minus, b);
                return add(div, res);
            }
        } else if (b == Integer.MIN_VALUE) {
            return 0;
        }
        return div(a, b);
    }


}
