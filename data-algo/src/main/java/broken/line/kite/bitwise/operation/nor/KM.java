package broken.line.kite.bitwise.operation.nor;

/**
 * @author: wanjia1
 * @date: 2023/5/9
 * <p>
 * 一个数组中有一种数出现K次，其他数都出现了M次，
 * 已知M > 1，K < M，找到出现了K次的数
 * 要求额外空间复杂度O(1)，时间复杂度O(N)
 */
public class KM {

    public static void main(String[] args) {
        int[] arr = {1, 1, 2222, 2222, 2222};
        System.out.println(findK(arr, 2, 3));
    }

    private static int findK(int[] arr, int k, int m) {

        int[] bitArr = new int[32];
        for (int value : arr) {
            for (int j = 0; j <= 31; j++) {
                if (((value >> j) & 1) != 0) {
                    bitArr[j]++;
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < bitArr.length; i++) {
            if (bitArr[i] % m != 0) {
                ans |= (1 << i);
            }
        }

        return ans;

    }


}
