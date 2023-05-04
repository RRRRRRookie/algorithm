package broken.line.kite.bitwise.operation;

import org.junit.jupiter.api.Test;

/**
 * @author: wanjia1
 * @date: 2023/5/3
 */
class OperationTest {

    @Test
    void print() {
        int num = Integer.MIN_VALUE;
        printBit(num);
    }

    private void printBit(int num) {
        int i = 31;
        // 0 为边界值
        while (i >= 0) {
            if (((1 << i) & num) != 0) {
                System.out.print("1");
            } else {
                System.out.print("0");
            }
            i--;
        }
        System.out.println();

    }

    @Test
    void testAdd() {
        int num = add(5, 6);
    }

    // 考虑0
    private int add(int num1, int num2) {
        int sum = num1;
        while (num2 != 0) {
            // 无进位相加
            sum = num1 ^ num2;
            // 有进位相加
            num2 |= ((num1 & num2) << 1);
            num1 = sum;
        }
        return sum;
    }

    private int minus(int num, int num2) {
        return add(num, add(~num2, 1));
    }

    private int multi(int num, int num2) {
        int res = 0;
        while (num2 != 0) {
            // 不断进位相加 且该位上有数才相加
            if ((num2 & 1) != 0) {
                res = add(res, num);
            }
            // num 不断进位 作为乘数
            num <<= 1;
            // num2 始终保持后移一位 处理下一位的结果
            num2 >>>= 1;
        }
        return res;
    }

    private int divide(int num1, int num2) {
        if (num1 == Integer.MIN_VALUE && num2 == Integer.MIN_VALUE) {
            return 1;
        }
        if (num1 != Integer.MIN_VALUE && Integer.MIN_VALUE == num2) {
            return 0;
        }
        if (num1 == Integer.MIN_VALUE && num2 != Integer.MIN_VALUE) {
            if (num2 == -1) {
                return Integer.MAX_VALUE;
            }
            // (a + 1) / b = c;
            int midRes = innerDivide((num1 + 1), num2);
            // a - (b * c) [a - (a + 1)]
            int leftResp = minus(num1, multi(num2, midRes));
            // -1 / b
            int midRes2 = innerDivide(leftResp, num2);
            // (a+1) / b + (-1/b)
            return add(midRes, midRes2);
        }
        return innerDivide(num1, num2);

    }

    /**
     * 仅支持绝对值计算
     *
     * @param num1
     * @param num2
     * @return
     */
    private int innerDivide(int num1, int num2) {

        int x = isNegative(num1) ? abs(num1) : num1;
        int y = isNegative(num2) ? abs(num2) : num2;

        int res = 0;
        // 不断判断和减去
        for (int i = 30; i >= 0; i--) {
            if ((x >> i) >= y) {
                res |= (1 << i);
                x = minus(x, y << i);
            }
        }


        return res;
    }

    private int abs(int num1) {
        return add(~num1, 1);
    }

    private boolean isNegative(int num1) {
        return num1 > 0;
    }


}