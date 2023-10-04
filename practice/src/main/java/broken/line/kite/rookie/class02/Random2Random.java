package broken.line.kite.rookie.class02;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * @author: wanjia1
 * @date: 2023/10/4
 */
@Slf4j
public class Random2Random {

    public static void main(String[] args) {
        // [0,1) 内数字等比出现
        log.info("Math.Random() {}", Math.random());
        average_test(8, 1000000);
        power2_test(0.71, 10000000);
        power2_test(0.15, 10000000);
        from1_7_test(8, 10000000);
        random_2_avg();
    }

    public static int random() {
        return Math.random() < 0.756 ? 1 : 0;
    }

    /**
     * 如何把不等概率随机函数变成等概率随机函数
     *
     * @return
     */
    private static int random_2_avg() {
        int res;
        do {
            res = random();
        } while (res == random());
        return res;
    }

    private static void from1_7_test(int length, int times) {
        int[] counts = new int[length];
        for (int j = 0; j < times; j++) {
            int num = from1_5to1_7();
            counts[num]++;
        }
        Arrays.stream(counts).forEach(obj -> log.info("出现 {} 次", obj));
    }

    //
    private static int from1_5() {
//        return (int) (Math.random() * 6);
        return ((int) (Math.random() * 5)) + 1;
    }

    private static int generateNum() {
        int cursor;
        do {
            cursor = from1_5();
        } while (cursor == 3);
        return cursor < 3 ? 0 : 1;
    }

    /**
     * 如何用1~5的等概率随机函数加工出1~7的等概率随机函数
     * 解法 先将from1_5函数 修改为0,1等概率发生器 generateNum()
     * 再让0,1发生器 接近确定[1,7]的范围 generate0_7()
     * 根据范围生成[0,6] from0_6() + 1 生成1，7
     */
    private static int from1_5to1_7() {
        return from0_6() + 1;
    }

    private static int from0_6() {
        int ans;
        do {
            ans = generate0_7();
        } while (ans == 7);
        return ans;
    }

    private static int generate0_7() {
        return (generateNum() << 2) + (generateNum() << 1) + generateNum();
    }


    /**
     * 返回[0,1)的一个小数
     * 任意的x，x属于[0,1)，[0,x)范围上的数出现概率由原来的x调整成x平方
     */
    private static void power2_test(double v, int times) {
        int count = 0;
        for (int j = 0; j < times; j++) {
            // 为什么 因为a<x * b<x
            if (Math.max(Math.random(), Math.random()) < v) {
                count++;
            }
        }

        log.info("预计概率 {}", Math.pow(v, 2));
//        log.info("实际概率 {}",  count /  times);
        log.info("实际概率 {}", (double) count / (double) times);

    }

    /**
     * 证明均等性 [0,X)上其概率是 1/X
     *
     * @param max
     * @param times
     */
    private static void average_test(int max, int times) {
        int[] counts = new int[max];
        for (int i = 0; i < times; i++) {
            int num = (int) (Math.random() * max);
            counts[num]++;
        }
        for (int i = 0; i < max; i++) {
            log.info("当前数字{}出现了{}次", i, counts[i]);
        }
    }


    public static double X_Power2() {
        // why
        return Math.max(Math.random(), Math.random());
    }


}
