package broken.line.kite.rookie.class01;

import lombok.extern.slf4j.Slf4j;

/**
 * 给定一个参数N，返回1!+2!+3!+4!+…+N!的结果
 *
 * @author: wanjia1
 * @date: 2023/10/3
 */
@Slf4j
public class Factorial {

    /**
     * @param args
     */
    public static void main(String[] args) {
        log.info("8的阶乘 {}", factorialMine(8));
        log.info("0的阶乘 {}", factorialMine(0));
        log.info("8的阶乘 {}", factorial(8));
        log.info("0的阶乘 {}", factorial(0));
    }

    private static long factorial(int num) {
        long total = 0;
        long cursor = 1;
        for (int i = 1; i <= num; i++) {
            cursor *= i;
            total += cursor;
        }
        return total;
    }

    private static long factorialMine(int num) {
        long total = 0;
        for (int i = 1; i <= num; i++) {
            total += subFactorial(i);
        }
        return total;
    }

    /**
     * 特殊case 0的阶乘是一
     *
     * @param num
     * @return
     */
    private static long subFactorial(int num) {
        int total = 1;
        for (int i = 1; i <= num; i++) {
            total *= i;
        }
        return total;
    }
}
