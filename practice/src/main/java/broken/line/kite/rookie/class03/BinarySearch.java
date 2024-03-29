package broken.line.kite.rookie.class03;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Objects;

/**
 * @author: wanjia1
 * @date: 2023/10/4
 */
@Slf4j
public class BinarySearch {


    private static boolean search(int[] arr, int num) {
        if (Objects.isNull(arr) || arr.length == 0) {
            log.info("index is -1");
            return false;
        }
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
                return true;
            }
        }
        log.info("index is -1");
        return false;
    }

    public static boolean test(int[] sortedArr, int num) {
        for (int cur : sortedArr) {
            if (cur == num) {
                return true;
            }
        }
        return false;
    }

    // for test
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    /**
     * 给定一个有序数组 查找某个数字
     *
     * @param args
     */
    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 10;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr = generateRandomArray(maxSize, maxValue);
            Arrays.sort(arr);
            int value = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
            if (test(arr, value) != search(arr, value)) {
                System.out.println("出错了！");
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
    }


}
