package broken.line.kite;

import java.util.Objects;

/**
 * @author: wanjia1
 * @date: 2023/4/17
 */
public class MaxSequenceCounter {

    public static void main(String[] args) {
//        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] arr = {-2, -1};
        System.out.println(loopCount(arr));
//        System.out.println(partitionCount(arr));
    }

    /**
     * 求解方式为暴力破解
     * 从 0 到 n 每个遍历求和 并利用中间变量maxCount存储值
     * 从 i+1 到 n 每个遍历求和 并利用中间变量maxCount存储值
     * 从 n-1 到 n 每个遍历求和 并利用中间变量maxCount存储值
     * 其中求和包括它自己不加任何其它的元素
     *
     * @param nums
     * @return
     */
    public static int loopCount(int[] nums) {
        if (Objects.isNull(nums)) {
            return 0;
        }
        int maxCount = nums[0];
        for (int i = 0; i < nums.length; i++) {
            int loopCount = nums[i];
            maxCount = Math.max(loopCount, maxCount);
            for (int j = i + 1; j < nums.length; j++) {
                loopCount += nums[j];
                maxCount = Math.max(loopCount, maxCount);
            }
        }
        return maxCount;
    }

    public static int partitionCount(int[] arr) {
        return 0;
    }


}
