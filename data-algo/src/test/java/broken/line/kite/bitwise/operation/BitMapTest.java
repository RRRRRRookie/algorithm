package broken.line.kite.bitwise.operation;

import java.util.HashSet;

/**
 * @author: wanjia1
 * @date: 2023/5/3
 */
class BitMapTest {

    public static class MyBitMap {

        private long[] bits;

        public MyBitMap(int max) {
            // 因为可能有余数 max /64 + 1
            this.bits = new long[(max + 64) >> 6];
        }

        public static void main(String[] args) {
            System.out.println("测试开始！");
            int max = 10000;
            MyBitMap bitMap = new MyBitMap(max);
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
                    if (bitMap.contains(num) != set.contains(num)) {
                        System.out.println("Oops!");
                        break;
                    }
                }
            }
            for (int num = 0; num <= max; num++) {
                if (bitMap.contains(num) != set.contains(num)) {
                    System.out.println("Oops!");
                }
            }
            System.out.println("测试结束！");
        }

        public void add(int num) {
            // 第一步 求余数 即 这64个位置 你该放在哪里 num % 64 -> num & 63 TODO
            bits[num >> 6] |= 1L << (num & 63);
        }

        public void delete(int num) {
//            bits[num >> 6] ^= 1L << (num & 63);
            // 找到位置 求反 之后&
            bits[num >> 6] &= ~(1L << (num & 63));
        }

        public boolean contains(int num) {
            // (bits[num >> 6] & (1L << (num & 63))) == 1L 错的 因为是某一位是1
//            (bits[num >> 6] & (1L << (num & 63))) != 0
            return (bits[num >> 6] & (1L << (num & 63))) != 0;
        }


    }


}