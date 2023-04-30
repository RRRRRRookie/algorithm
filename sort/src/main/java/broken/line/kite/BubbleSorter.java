package broken.line.kite;

import java.util.Objects;

/**
 * @author: wanjia1
 * @date: 2023/4/30
 */
public class BubbleSorter {

    public static void sort(int[] arr) {
        if (Objects.isNull(arr) || arr.length < 2) {
            return;
        }
        int last = arr.length - 1;
        for (int i = last; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    SortUtils.swap(arr, j, j + 1);
                }
            }
        }
    }

}
