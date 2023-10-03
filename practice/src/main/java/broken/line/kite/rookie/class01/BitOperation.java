package broken.line.kite.rookie.class01;

import lombok.extern.slf4j.Slf4j;

/**
 * @author: wanjia1
 * @date: 2023/10/3
 */
@Slf4j
public class BitOperation {

    /**
     * java 中的位运算
     * & 与 同一则为一
     * | 或 有一则为一
     * ~ 取反包括符号位置都取反 假定高四位为符号位置 1001 0110
     * ||
     * &&
     * ^ 相同为0 不同为1
     * << 不包括符号位左移
     * >> 不包括符号位右移
     * >>> 包括符号位右移
     */
    public static String printBinary(int num) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 31; i >= 0; i--) {
            // 必须从
            stringBuilder.append((num & (1 << i)) == 0 ? "0" : "1");
        }
        return stringBuilder.toString();
    }

    /**
     * 一个byte = 8bit
     * byte short int long
     * 1 2 4 8
     * 8 16 32 64
     *
     * @param args
     */
    public static void main(String[] args) {
        printBinary(17);
        log.info((0 & 0) + "");
        log.info((0 | 0) + "");
        log.info((0 | 1) + "");
        log.info((1 | 1) + "");
        log.info("0 ^ 1 {}", 0 ^ 1);
        log.info("1 ^ 1 {}", 1 ^ 1);
        log.info("0 ^ 0 {}", 0 ^ 0);
//        01111111111111111111111111111111 最高位是符号位 2147483647
        log.info("java integer MAX 十进制 {} 二进制 {}", Integer.MAX_VALUE, printBinary(Integer.MAX_VALUE));
//        10000000000000000000000000000000 -2147483648
        log.info("java integer MIN 十进制 {} 二进制 {}", Integer.MIN_VALUE, printBinary(Integer.MIN_VALUE));
/*
        11111111111111111111111111111111 -1 为什么是这么一长串 不管符号位置 取反+1
        为什么是取反 +1 为了加减乘除 均使用一套算法 而不用走条件分支
            为了对称的表示2^32个数字 由分析我们得知 我们共有2^32个数字
            二进制取反加一 逻辑门拼接 这样不用处理裸数处理 处理两套逻辑
            -2^31 , 0 , 2^31 -1 刚好是 2^32 0 归于非负区域
 */
        log.info(" 负1的 十进制 {} 二进制 {}", -1, printBinary(-1));
//        -101
        log.info("101 取反 + 1 {}", ~101 + 1);
//        -888888
        log.info("888888 取反 + 1 {}", ~888888 + 1);
        log.info("-888888 取反 + 1 {}", ~-888888 + 1);
        // 0补位
        log.info("Integer.MIN 带符号右移动 {}", printBinary(Integer.MIN_VALUE >>> 1));
        // 符号位补位
        log.info("Integer.MIN 不带符号右移动 {}", printBinary(Integer.MIN_VALUE >> 1));

        // 求相反数 取反+1 -a  ~a + 1
        // 边界条件
        log.info("min 取反加一 {}", ~Integer.MIN_VALUE + 1);
        log.info("min 取反加一 带括号{}", (~Integer.MIN_VALUE) + 1);
        log.info("max 取反加一 带括号 {}", (~Integer.MAX_VALUE) + 1);
        log.info("max 取反加一 {}", ~Integer.MAX_VALUE + 1);
        log.info("0 取反加一 带括号{}", (~0) + 1);
        log.info("0 取反加一 {}", ~0 + 1);


    }

}
