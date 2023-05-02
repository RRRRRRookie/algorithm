package broken.line.kite.bitwise.operation;

/**
 * @author: wanjia1
 * @date: 2023/5/1
 */
public class BitMap {

    private long[] bits;

    public BitMap(int max) {
        // (max + 64) >> 6 (max + 64) / 64
        this.bits = new long[(max + 64) >> 6];
    }

    public void add(int num) {
        // num % 64 == num & 63
        // 1L << (num & 63) 查找对应的位置
        bits[num >> 6] |= 1L << (num & 63);
    }

    public void delete(int num) {
        bits[num >> 6] &= ~(1L << (num & 63));
    }

    public boolean exist(int num) {
        return (bits[num >> 6] & (1L << (num & 63))) != 0;
    }


}
