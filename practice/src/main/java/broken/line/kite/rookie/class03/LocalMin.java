package broken.line.kite.rookie.class03;

import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

/**
 * 给定一个无序且相邻不相等的数组 求局部最小值
 * 局部最小值是
 * arr[0] < arr[1]
 * arr[n-1] > arr[n]
 * arr[i-1] > arr[i] && arr[i] < arr[i-1]
 * 通过判断 i到i+1的递增递减趋势 (因为互不相等 故此必有两数之间必有递增递减) 不断二分
 *
 * @author: wanjia1
 * @date: 2023/10/5
 */
@Slf4j
public class LocalMin {


    private static int find(int[] arr) {
        int index = -1;
        if (Objects.isNull(arr) || arr.length == 0) {
            return index;
        }
        int length = arr.length;
        if (length == 1) {
            return 0;
        }
        if (arr[0] < arr[1]) {
            return 0;
        }
        if (arr[length - 2] > arr[length - 1]) {
            return length - 1;
        }
        int L = 0;
        int R = length - 1;
        // 边界条件 想进入该表达式 应该保证永远有 3个数字 故此将L <= R 修改为 L < R - 1
        while (L < R - 1) {
            int mid = (R - L) / 2 + L;
            if (arr[mid - 1] > arr[mid] && arr[mid] < arr[mid + 1]) {
                return mid;
            } else if (arr[mid - 1] < arr[mid]) {
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        // 边界条件 如果只剩下两个数字了 应该走这个判断
        return arr[L] < arr[R] ? L : R;
    }

    public static int[] randomArray(int maxLen, int maxValue) {
        int len = (int) (Math.random() * maxLen);
        int[] arr = new int[len];
        if (len > 0) {
            arr[0] = (int) (Math.random() * maxValue);
            for (int i = 1; i < len; i++) {
                do {
                    arr[i] = (int) (Math.random() * maxValue);
                } while (arr[i] == arr[i - 1]);
            }
        }
        return arr;
    }

    // 也用于测试
    public static boolean check(int[] arr, int minIndex) {
        if (arr.length == 0) {
            return minIndex == -1;
        }
        int left = minIndex - 1;
        int right = minIndex + 1;
        boolean leftBigger = left >= 0 ? arr[left] > arr[minIndex] : true;
        boolean rightBigger = right < arr.length ? arr[right] > arr[minIndex] : true;
        return leftBigger && rightBigger;
    }

    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int maxLen = 100;
        int maxValue = 200;
        int testTime = 1000000;
        System.out.println("测试开始");
        for (int i = 0; i < testTime; i++) {
            int[] arr = randomArray(maxLen, maxValue);
            int ans = find(arr);
            if (!check(arr, ans)) {
                printArray(arr);
                System.out.println(ans);
                break;
            }
        }
        System.out.println("测试结束");

    }


}
