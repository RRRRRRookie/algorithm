package broken.line.kite.bitwise.operation;

/**
 * @author: wanjia1
 * @date: 2023/4/30
 * https://leetcode.com/problems/divide-two-integers
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
        print(minValue << 2);

        System.out.println("==============================================");

        int maxValue = Integer.MAX_VALUE;
        print(maxValue);
        print(maxValue >> 2);
        print(maxValue >>> 2);
        print(maxValue << 2);
    }

    // print 整数中包含的1 & 两个1相遇才是1
    public static void print(int num) {
        for (int i = 31; i >= 0; i--) {
            System.out.print((num & (1 << i)) != 0 ? "1" : "0");
        }
        System.out.println();
    }

    public static void printBit(int num) {
        for (int i = 31; i >= 0; i--) {
            System.out.print((num & (1 << i)) != 0 ? "1" : "0");
        }
        System.out.println();
    }

    private static int add(int num1, int num2) {
        // step 1 num1 ^ num2 无进位相加
        // step 2 ((num1 & num2) << 1) 进位信息
        // step 3 (num1 ^ num2) + ((num1 & num2) << 1)
        // step 4 循环 a' + b'
        // step 5 当无进位时 a' 就是答案
        int sum = num1;
        while (num2 != 0) {
            sum = num1 ^ num2;
            num2 = ((num1 & num2) << 1);
            num1 = sum;
        }
        return sum;
    }

    private static int minus(int num1, int num2) {
        return add(num1, negative(num2));
    }

    public static int negative(int num) {
        return add(~num, 1);
    }

    public static boolean isNegative(int num) {
        return num < 0;
    }

    // 负数？
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

    public static int divide(int a, int b) {
        if (a == Integer.MIN_VALUE && b == Integer.MIN_VALUE) {
            return 1;
        }
        if (a != Integer.MIN_VALUE && b == Integer.MIN_VALUE) {
            return 0;
        }
        if (a == Integer.MIN_VALUE && b != Integer.MIN_VALUE) {
            if (b == negative(1)) {
                return Integer.MAX_VALUE;
            }
            // (a + 1 ) / b = c
            int res = innerDivide(add(a, 1), b);
            // a - b*c = e ==
            int mid2 = minus(res, multi(b, res));
            // e / b
            int mid3 = innerDivide(mid2, b);
            // res = e/b + c
            return add(res, mid3);
        }
        return innerDivide(a, b);
    }


    public static int innerDivide(int a, int b) {

        int x = isNegative(a) ? negative(a) : a;
        int y = isNegative(b) ? negative(b) : b;

        int res = 0;
        for (int i = 30; i >= 0; i--) {
            if ((x >> i) >= y) {
                res |= (1 << i);
                x = minus(x, y << i);
            }
        }

        return isNegative(a) ^ isNegative(b) ? negative(res) : res;
    }


}
