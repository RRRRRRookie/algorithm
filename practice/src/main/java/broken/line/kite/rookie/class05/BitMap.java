package broken.line.kite.rookie.class05;

import java.util.HashSet;

/**
 * 使用位图来作为set存储数字 对空间有极大压缩
 * 如 int类型 为 4byte 32bit 则存储值为 0x0000 代表32个1
 * 不代表对应的大小 而只代表对应的位置有没有值
 * 扩容32倍
 *
 * @author: wanjia1
 * @date: 2023/10/6
 */
public class BitMap {

    private long[] bits;


    public BitMap(int max) {
        // >> 6 相当于/64 +64是为了边界
        this.bits = new long[(max + 64) >> 6];
    }

    public static void main(String[] args) {
        System.out.println("测试开始！");
        int max = 10000;
        BitMap bitMap = new BitMap(max);
        HashSet<Integer> set = new HashSet<>();
        int testTime = 10000000;
        for (int i = 0; i < testTime; i++) {
            int num = (int) (Math.random() * (max + 1));
            double decide = Math.random();
            if (decide < 0.333) {
                bitMap.add(num);
                set.add(num);
            } else if (decide < 0.666) {
                bitMap.delete(num);
                set.remove(num);
            } else {
                if (bitMap.exist(num) != set.contains(num)) {
                    System.out.println("Oops!");
                    break;
                }
            }
        }
        for (int num = 0; num <= max; num++) {
            if (bitMap.exist(num) != set.contains(num)) {
                System.out.println("Oops!");
            }
        }
        System.out.println("测试结束！");
    }

    public void add(int num) {
        // & 63 相当于%64
        bits[num >> 6] |= (1L << (num & 63));
    }

    public void delete(int num) {
        bits[num >> 6] &= ~(1L << (num & 63));
    }

    public boolean exist(int num) {
        // 错误原因 因为1000010111 不等于1
//        return (bits[num >> 6] & (1L << (num & 63))) == 1;
        return (bits[num >> 6] & (1L << (num & 63))) != 0;
    }

}
