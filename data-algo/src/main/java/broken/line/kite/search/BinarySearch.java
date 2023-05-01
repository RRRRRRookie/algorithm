package broken.line.kite.search;

import java.util.Objects;

/**
 * @author: wanjia1
 * @date: 2023/4/30
 */
public class BinarySearch {

    public static boolean find(int[] arr, int num) {
        boolean exist = false;
        if (Objects.isNull(arr) || arr.length == 0) {
            return exist;
        }
        int left = 0;
        int right = arr.length;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (arr[mid] == num) {
                return true;
            } else if (arr[mid] > num) {
                // 为什么是mid -1
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        // left??
        return arr[left] == num;

    }

    // 有序数组中找到>=num最左的位置
    public static int findNearLeft(int[] arr, int num) {
        int index = -1;
        if (Objects.isNull(arr) || arr.length == 0) {
            return index;
        }
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (arr[mid] >= num) {
                index = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return index;
    }


    // 在arr上，找满足<=value的最右位置
    public static int findNearRight(int[] arr, int num) {
        int index = -1;
        if (Objects.isNull(arr) || arr.length == 0) {
            return index;
        }
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (arr[mid] <= num) {
                index = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return index;
    }

    /**
     * 寻找局部最小值 非有序数组 且各元素不相等
     * 简单算法遍历 就可以了
     */
    public static int findLocalMin(int[] arr) {
        if (Objects.isNull(arr) || arr.length == 0) {
            return -1;
        }
        if (arr.length == 1 || arr[0] < arr[1]) {
            return 0;
        }
        if (arr[arr.length - 2] > arr[arr.length - 1]) {
            return arr.length - 1;
        }
        int left = 1;
        int right = arr.length - 2;

        while (left < right) {
            int mid = left + ((right - left) >> 1);
            // 错了
            if (arr[mid] > arr[mid - 1]) {
                right = mid - 1;
            } else if (arr[mid] < arr[mid + 1]) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return left;
    }

}
