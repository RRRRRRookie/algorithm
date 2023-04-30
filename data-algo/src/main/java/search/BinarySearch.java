package search;

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
        int mid;
        while (left < right) {
            mid = left + ((right - left) >> 1);
            if (arr[mid] != num) {
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


}
