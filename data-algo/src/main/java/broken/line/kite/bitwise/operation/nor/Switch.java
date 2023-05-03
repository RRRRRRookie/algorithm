package broken.line.kite.bitwise.operation.nor;

/**
 * @author: wanjia1
 * @date: 2023/4/30
 * 0 ^ N = N
 * a ^ b ^ c = b ^ c ^ a 满足交换律
 * <p>
 * &	与	两个位都为1时，结果才为1
 * |	或	两个位都为0时，结果才为0
 *      同或 相同为1 不同为0
 * ^	异或	两个位相同为0，相异为1 可以近似理解为无进位相加
 * ~	取反	0变1，1变0
 * <<	左移	各二进位全部左移若干位，高位丢弃，低位补0
 * >>	右移	各二进位全部右移若干位，对无符号数，高位补0，有符号数，各编译器处理方法不一样，有的补符号位（算术右移），有的补0（逻辑右移）
 * <p>
 * 参考 https://blog.csdn.net/weixin_44606517/article/details/102796480
 */
public class Switch {


    // arr中，只有一种数，出现奇数次
    static void printOddTimesNum1(int[] arr) {
        int eor = 0;
        for (int i = 0; i < arr.length; i++) {
            eor ^= arr[i];
        }
        System.out.println(eor);
    }

    static void printOddTimesNum2(int[] arr) {
        int eor = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            eor ^= arr[i];
        }

        // 提取出整形数 最右侧的1 N&((~N) +1)
        int rightOne = eor & ((~eor) + 1);

        int onlyOne = 0;


        for (int i = 0; i < arr.length; i++) {
            if ((rightOne & arr[i]) != 0) {
                onlyOne ^= arr[i];
            }
        }
        System.out.printf("一个数字是%s 另一个数字是%s%n", onlyOne, (onlyOne ^ eor));
    }


    // 怎么把一个int类型的数，提取出二进制中最右侧的1来
    // 求有多少个1
    public static int bitCounts(int num) {
        int count = 0;
        while (num != 0) {
            int rightOne = num & ((~num) + 1);
            num ^= rightOne;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(bitCounts(-1));
        System.out.println(bitCounts(1));
    }


}
