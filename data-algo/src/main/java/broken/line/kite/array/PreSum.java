package broken.line.kite.array;

import lombok.Data;

/**
 * @author: wanjia1
 * @date: 2023/5/1
 */
@Data
public class PreSum {

    private int[] arr;

    private int[] sumArr;

    public PreSum(int[] arr) {
        this.sumArr = initSumArr(arr);
    }

    private int[] initSumArr(int[] arr) {
        // 可能会有值越界
        int[] ansArr = new int[arr.length];
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            count += arr[i];
            ansArr[i] = count;
        }
        return ansArr;
    }

    public int getPreSum(int left, int right) {
        // TODO enhance invalid check
        if (right < left) {
            throw new RuntimeException("not allowed");
        }
        return left == 0 ? sumArr[right] : sumArr[right] - sumArr[left - 1];
    }


}
