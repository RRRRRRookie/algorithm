package broken.line.kite.rookie.class01;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Objects;

/**
 * @author: wanjia1
 * @date: 2023/10/3
 */
@Slf4j
public class SelectSorter {

    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 5, -4, 9, -1, 100, 13};
        int[] arr2 = {1, 3, 4, 5, -4, 9, -1, 100, 13};
//        System.out.println(Arrays.equals(Arrays.sort(arr), sort(arr)));
        sort(arr2);
        Arrays.sort(arr);
        log.info("对比结果 {}", Arrays.equals(arr, arr2));
    }

    private static void sort(int[] arr) {
        if (Objects.isNull(arr) || arr.length < 2) {
            return;
        }
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            int minIndex = i;
            for (int j = i; j < length; j++) {
                minIndex = arr[minIndex] > arr[j] ? j : minIndex;
            }
            swap(arr, i, minIndex);
        }

    }

    private static void swap(int[] arr, int i, int j) {
        int current = arr[i];
        arr[i] = arr[j];
        arr[j] = current;
    }


}
