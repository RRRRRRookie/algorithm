package broken.line.kite.rookie.class03;

import lombok.extern.slf4j.Slf4j;

/**
 * @author: wanjia1
 * @date: 2023/10/4
 */
@Slf4j
public class BinarySearch {


    /**
     * 给定一个有序数组 查找某个数字
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 5, 6, 7};
        search(arr, -32);
    }

    private static void search(int[] arr, int num) {
        int L = 0;
        int R = arr.length - 1;
        // 可能会溢出
//
        while (L <= R) {
//            int mid = (L >> 1) + (R >> 1);
            int mid = (L + R) / 2;
            if (num < arr[mid]) {
                R = mid - 1;
            } else if (num > arr[mid]) {
                L = mid + 1;
            } else {
                log.info("index is {}", mid);
                return;
            }
        }
        log.info("index is -1");
    }


}
